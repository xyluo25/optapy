package org.optaplanner.python.translator.types.errors.io.connection;

import java.util.List;

import org.optaplanner.python.translator.PythonLikeObject;
import org.optaplanner.python.translator.types.PythonLikeType;

/**
 * Raised when a buffer related operation cannot be performed.
 */
public class BrokenPipeError extends ConnectionError {
    final public static PythonLikeType BROKEN_PIPE_ERROR_TYPE =
            new PythonLikeType("BrokenPipeError", BrokenPipeError.class, List.of(CONNECTION_ERROR_TYPE)),
            $TYPE = BROKEN_PIPE_ERROR_TYPE;

    static {
        BROKEN_PIPE_ERROR_TYPE.setConstructor(
                ((positionalArguments, namedArguments, callerInstance) -> new BrokenPipeError(BROKEN_PIPE_ERROR_TYPE,
                        positionalArguments)));
    }

    public BrokenPipeError(PythonLikeType type) {
        super(type);
    }

    public BrokenPipeError(PythonLikeType type, List<PythonLikeObject> args) {
        super(type, args);
    }

    public BrokenPipeError(PythonLikeType type, String message) {
        super(type, message);
    }
}
