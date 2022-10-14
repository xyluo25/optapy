package org.optaplanner.python.translator.types.errors.io;

import java.util.List;

import org.optaplanner.python.translator.PythonLikeObject;
import org.optaplanner.python.translator.types.PythonLikeType;

/**
 * Raised when a buffer related operation cannot be performed.
 */
public class InterruptedError extends OSError {
    final public static PythonLikeType INTERRUPTED_ERROR_TYPE =
            new PythonLikeType("InterruptedError", InterruptedError.class, List.of(OS_ERROR_TYPE)),
            $TYPE = INTERRUPTED_ERROR_TYPE;

    static {
        INTERRUPTED_ERROR_TYPE.setConstructor(
                ((positionalArguments, namedArguments, callerInstance) -> new InterruptedError(INTERRUPTED_ERROR_TYPE,
                        positionalArguments)));
    }

    public InterruptedError(PythonLikeType type) {
        super(type);
    }

    public InterruptedError(PythonLikeType type, List<PythonLikeObject> args) {
        super(type, args);
    }

    public InterruptedError(PythonLikeType type, String message) {
        super(type, message);
    }
}
