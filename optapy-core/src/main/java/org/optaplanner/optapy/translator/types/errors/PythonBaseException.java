package org.optaplanner.optapy.translator.types.errors;

import java.util.Map;

import org.optaplanner.optapy.PythonLikeObject;
import org.optaplanner.optapy.translator.types.PythonLikeType;

/**
 * Python base class for all exceptions. Equivalent to Java's {@link Throwable}.
 */
public class PythonBaseException extends RuntimeException implements PythonLikeObject {
    final static PythonLikeType BASE_EXCEPTION_TYPE = new PythonLikeType("BaseException");

    Map<String, PythonLikeObject> dict;

    final PythonLikeType type;

    public PythonBaseException(PythonLikeType type) {
        this.type = type;
    }

    /**
     * Python errors are supposed to be extremely low cost, to the point you are encouraged
     * to write code with try...except instead of if...then. See
     * <a href="https://docs.python.org/3/glossary.html#term-EAFP">the Python glossary</a>
     * for more information.
     *
     * @return this
     */
    @Override
    public Throwable fillInStackTrace() {
        // Do nothing
        return this;
    }

    @Override
    public PythonLikeObject __getAttributeOrNull(String attributeName) {
        return dict.get(attributeName);
    }

    @Override
    public void __setAttribute(String attributeName, PythonLikeObject value) {
        dict.put(attributeName, value);
    }

    @Override
    public void __deleteAttribute(String attributeName) {
        dict.remove(attributeName);
    }

    @Override
    public PythonLikeType __getType() {
        return type;
    }
}
