package org.optaplanner.python.translator.opcodes.exceptions;

import java.util.ArrayList;
import java.util.List;

import org.optaplanner.python.translator.FunctionMetadata;
import org.optaplanner.python.translator.PythonBytecodeInstruction;
import org.optaplanner.python.translator.StackMetadata;
import org.optaplanner.python.translator.ValueSourceInfo;
import org.optaplanner.python.translator.implementors.ExceptionImplementor;
import org.optaplanner.python.translator.opcodes.OpcodeWithoutSource;
import org.optaplanner.python.translator.opcodes.controlflow.AbstractControlFlowOpcode;
import org.optaplanner.python.translator.types.PythonInteger;
import org.optaplanner.python.translator.types.PythonLikeType;
import org.optaplanner.python.translator.types.PythonNone;
import org.optaplanner.python.translator.types.errors.PythonBaseException;
import org.optaplanner.python.translator.types.errors.PythonTraceback;

public class SetupFinallyOpcode extends AbstractControlFlowOpcode {

    public SetupFinallyOpcode(PythonBytecodeInstruction instruction) {
        super(instruction);
    }

    @Override
    public List<Integer> getPossibleNextBytecodeIndexList() {
        return List.of(getBytecodeIndex() + 1,
                getBytecodeIndex() + instruction.arg + 1);
    }

    @Override
    public List<StackMetadata> getStackMetadataAfterInstructionForBranches(FunctionMetadata functionMetadata,
            StackMetadata stackMetadata) {
        return List.of(stackMetadata.copy(),
                stackMetadata.copy()
                        .push(ValueSourceInfo.of(new OpcodeWithoutSource(), PythonNone.NONE_TYPE))
                        .push(ValueSourceInfo.of(new OpcodeWithoutSource(), PythonInteger.getIntType()))
                        .push(ValueSourceInfo.of(new OpcodeWithoutSource(), PythonNone.NONE_TYPE))
                        .push(ValueSourceInfo.of(new OpcodeWithoutSource(), PythonTraceback.TRACEBACK_TYPE))
                        .push(ValueSourceInfo.of(new OpcodeWithoutSource(), PythonBaseException.BASE_EXCEPTION_TYPE))
                        .push(ValueSourceInfo.of(new OpcodeWithoutSource(), PythonLikeType.getTypeType())));
    }

    @Override
    public void implement(FunctionMetadata functionMetadata, StackMetadata stackMetadata) {
        ExceptionImplementor.createTryFinallyBlock(functionMetadata.methodVisitor, functionMetadata.className, instruction,
                stackMetadata,
                functionMetadata.bytecodeCounterToLabelMap,
                (bytecodeIndex, runnable) -> {
                    functionMetadata.bytecodeCounterToCodeArgumenterList
                            .computeIfAbsent(bytecodeIndex, key -> new ArrayList<>()).add(runnable);
                });
    }
}
