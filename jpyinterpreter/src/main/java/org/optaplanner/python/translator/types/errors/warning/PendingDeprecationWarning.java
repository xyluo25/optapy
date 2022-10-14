package org.optaplanner.python.translator.types.errors.warning;

import java.util.List;

import org.optaplanner.python.translator.PythonLikeObject;
import org.optaplanner.python.translator.types.PythonLikeType;

public class PendingDeprecationWarning extends Warning {
    public final static PythonLikeType PENDING_DEPRECATION_WARNING_TYPE =
            new PythonLikeType("PendingDeprecationWarning", PendingDeprecationWarning.class, List.of(WARNING_TYPE)),
            $TYPE = PENDING_DEPRECATION_WARNING_TYPE;

    static {
        PENDING_DEPRECATION_WARNING_TYPE.setConstructor(((positionalArguments,
                namedArguments,
                callerInstance) -> new PendingDeprecationWarning(PENDING_DEPRECATION_WARNING_TYPE, positionalArguments)));
    }

    public PendingDeprecationWarning() {
        super(PENDING_DEPRECATION_WARNING_TYPE);
    }

    public PendingDeprecationWarning(String message) {
        super(PENDING_DEPRECATION_WARNING_TYPE, message);
    }

    public PendingDeprecationWarning(PythonLikeType type, List<PythonLikeObject> args) {
        super(type, args);
    }

    public PendingDeprecationWarning(PythonLikeType type) {
        super(type);
    }

    public PendingDeprecationWarning(PythonLikeType type, String message) {
        super(type, message);
    }
}
