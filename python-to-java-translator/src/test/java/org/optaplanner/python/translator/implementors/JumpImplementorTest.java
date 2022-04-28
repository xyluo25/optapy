package org.optaplanner.python.translator.implementors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.optaplanner.python.translator.PythonBytecodeToJavaBytecodeTranslator.translatePythonBytecode;

import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.optaplanner.python.translator.CompareOp;
import org.optaplanner.python.translator.PythonBytecodeInstruction;
import org.optaplanner.python.translator.PythonCompiledFunction;
import org.optaplanner.python.translator.types.PythonBoolean;
import org.optaplanner.python.translator.util.PythonFunctionBuilder;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class JumpImplementorTest {
    @Test
    public void testIfTrue() {
        PythonCompiledFunction pythonCompiledFunction = PythonFunctionBuilder.newFunction("a")
                .loadParameter("a")
                .loadConstant(5)
                .compare(CompareOp.LESS_THAN)
                .ifTrue(block -> {
                    block.loadConstant(10);
                    block.op(PythonBytecodeInstruction.OpCode.RETURN_VALUE);
                })
                .loadConstant(-10)
                .op(PythonBytecodeInstruction.OpCode.RETURN_VALUE)
                .build();

        Function javaFunction = translatePythonBytecode(pythonCompiledFunction, Function.class);
        assertThat(javaFunction.apply(1L)).isEqualTo(10L);
        assertThat(javaFunction.apply(10L)).isEqualTo(-10L);
    }

    @Test
    public void testIfFalse() {
        PythonCompiledFunction pythonCompiledFunction = PythonFunctionBuilder.newFunction("a")
                .loadParameter("a")
                .loadConstant(5)
                .compare(CompareOp.LESS_THAN)
                .ifFalse(block -> {
                    block.loadConstant(10);
                    block.op(PythonBytecodeInstruction.OpCode.RETURN_VALUE);
                })
                .loadConstant(-10)
                .op(PythonBytecodeInstruction.OpCode.RETURN_VALUE)
                .build();

        Function javaFunction = translatePythonBytecode(pythonCompiledFunction, Function.class);
        assertThat(javaFunction.apply(1L)).isEqualTo(-10L);
        assertThat(javaFunction.apply(10L)).isEqualTo(10L);
    }

    @Test
    public void testIfTrueKeepTop() {
        PythonCompiledFunction pythonCompiledFunction = PythonFunctionBuilder.newFunction("a")
                .loadParameter("a")
                .loadConstant(5)
                .compare(CompareOp.LESS_THAN)
                .ifTruePopTop(block -> {
                    block.loadConstant(true);
                    block.op(PythonBytecodeInstruction.OpCode.RETURN_VALUE);
                })
                .op(PythonBytecodeInstruction.OpCode.RETURN_VALUE) // Top is False (block was skipped)
                .build();

        Function javaFunction = translatePythonBytecode(pythonCompiledFunction, Function.class);
        assertThat(javaFunction.apply(1L)).isEqualTo(PythonBoolean.TRUE);
        assertThat(javaFunction.apply(10L)).isEqualTo(PythonBoolean.FALSE);
    }

    @Test
    public void testIfFalseKeepTop() {
        PythonCompiledFunction pythonCompiledFunction = PythonFunctionBuilder.newFunction("a")
                .loadParameter("a")
                .loadConstant(5)
                .compare(CompareOp.LESS_THAN)
                .ifFalsePopTop(block -> {
                    block.loadConstant(false);
                    block.op(PythonBytecodeInstruction.OpCode.RETURN_VALUE);
                })
                .op(PythonBytecodeInstruction.OpCode.RETURN_VALUE) // Top is True (block was skipped)
                .build();

        Function javaFunction = translatePythonBytecode(pythonCompiledFunction, Function.class);
        assertThat(javaFunction.apply(1L)).isEqualTo(PythonBoolean.TRUE);
        assertThat(javaFunction.apply(10L)).isEqualTo(PythonBoolean.FALSE);
    }
}
