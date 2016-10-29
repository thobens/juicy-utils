package ch.nosedev.juicyutils.functions;

/**
 * Equivalent of {@link java.util.function.Predicate}, but in addition it throws an {@link Exception} of the type <code>E</code>.
 *
 * @param <T> The type of the parameter accepted by {@link #testChecked(Object)}
 * @param <E> The Exception thrown by {@link #testChecked(Object)}
 */
@FunctionalInterface
public interface CheckedPredicate<T, E extends Exception> {

    /**
     * Equivalent of {@link java.util.function.Predicate#test(Object)}
     *
     * @param arg the argument for the consumer
     * @throws E a checked exception
     * @return true if the test succeeds, false otherwise
     */
    boolean testChecked(T arg) throws E;
}
