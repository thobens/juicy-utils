package ch.nosedev.juicyutils.functions;

/**
 * Equivalent of {@link java.util.function.Function}, but in addition it throws an {@link Exception} of the type <code>E</code>.
 *
 * @param <T> The type of the parameter accepted by {@link #applyChecked(Object)
 * @param <R> The return type of {@link #applyChecked(Object)}
 * @param <E> The Exception thrown by {@link #applyChecked(Object)}
 */
@FunctionalInterface
public interface CheckedFunction<T, R, E extends Exception> {

    /**
     * Equivalent of {@link java.util.function.Function#apply(Object)}
     *
     * @param arg The argument of this function
     * @return The return type of this function
     * @throws E a checked exception
     */
    R applyChecked(T arg) throws E;

}
