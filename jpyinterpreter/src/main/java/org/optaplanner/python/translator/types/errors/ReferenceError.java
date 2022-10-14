package org.optaplanner.python.translator.types.errors;

import java.util.List;

import org.optaplanner.python.translator.PythonLikeObject;
import org.optaplanner.python.translator.types.PythonLikeType;

/**
 * Raised when a buffer related operation cannot be performed.
 */
public class ReferenceError extends PythonBaseException {
    final public static PythonLikeType REFERENCE_ERROR_TYPE =
            new PythonLikeType("ReferenceError", ReferenceError.class, List.of(PythonBaseException.BASE_EXCEPTION_TYPE)),
            $TYPE = REFERENCE_ERROR_TYPE;

    static {
        REFERENCE_ERROR_TYPE.setConstructor(
                ((positionalArguments, namedArguments, callerInstance) -> new ReferenceError(REFERENCE_ERROR_TYPE,
                        positionalArguments)));
    }

    public ReferenceError(PythonLikeType type) {
        super(type);
    }

    public ReferenceError(PythonLikeType type, String message) {
        super(type, message);
    }

    public ReferenceError(PythonLikeType type, List<PythonLikeObject> args) {
        super(type, args);
    }
}
