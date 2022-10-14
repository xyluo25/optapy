package org.optaplanner.python.translator.types.errors.arithmetic;

import java.util.List;

import org.optaplanner.python.translator.PythonLikeObject;
import org.optaplanner.python.translator.types.PythonLikeType;
import org.optaplanner.python.translator.types.errors.PythonException;

/**
 * The base class for those built-in exceptions that are raised for various arithmetic errors
 */
public class ArithmeticError extends PythonException {
    final public static PythonLikeType ARITHMETIC_ERROR_TYPE =
            new PythonLikeType("ArithmeticError", ArithmeticError.class, List.of(EXCEPTION_TYPE)),
            $TYPE = ARITHMETIC_ERROR_TYPE;

    static {
        ARITHMETIC_ERROR_TYPE.setConstructor(
                ((positionalArguments, namedArguments, callerInstance) -> new ArithmeticError(ARITHMETIC_ERROR_TYPE,
                        positionalArguments)));
    }

    public ArithmeticError(PythonLikeType type) {
        super(type);
    }

    public ArithmeticError(PythonLikeType type, List<PythonLikeObject> args) {
        super(type, args);
    }

    public ArithmeticError(PythonLikeType type, String message) {
        super(type, message);
    }
}
