package org.optaplanner.python.translator.types.errors.unicode;

import java.util.List;

import org.optaplanner.python.translator.PythonLikeObject;
import org.optaplanner.python.translator.types.PythonLikeType;

public class UnicodeDecodeError extends UnicodeError {
    public final static PythonLikeType UNICODE_DECODE_ERROR_TYPE =
            new PythonLikeType("UnicodeDecodeError", UnicodeDecodeError.class, List.of(UNICODE_ERROR_TYPE)),
            $TYPE = UNICODE_DECODE_ERROR_TYPE;

    static {
        UNICODE_DECODE_ERROR_TYPE.setConstructor(((positionalArguments,
                namedArguments, callerInstance) -> new UnicodeDecodeError(UNICODE_DECODE_ERROR_TYPE, positionalArguments)));
    }

    public UnicodeDecodeError() {
        super(UNICODE_DECODE_ERROR_TYPE);
    }

    public UnicodeDecodeError(String message) {
        super(UNICODE_DECODE_ERROR_TYPE, message);
    }

    public UnicodeDecodeError(PythonLikeType type, List<PythonLikeObject> args) {
        super(type, args);
    }

    public UnicodeDecodeError(PythonLikeType type) {
        super(type);
    }

    public UnicodeDecodeError(PythonLikeType type, String message) {
        super(type, message);
    }
}
