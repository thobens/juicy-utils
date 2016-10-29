package ch.nosedev.juicyutils.functions;

/**
 * Equivalent of {@link java.util.function.Consumer}, but in addition it throws an {@link Exception} of the type <code>E</code>.
 *
 * @param <T> The type of the parameter accepted by {@link #acceptChecked(Object)}
 * @param <E> The Exception thrown by {@link #acceptChecked(Object)}
 */
@FunctionalInterface
public interface CheckedConsumer<T, E extends Exception> {

    /**
     * Equivalent of {@link java.util.function.Consumer#accept(Object)}
     *
     * @param arg the argument for the consumer
     * @throws E a checked exception
     */
    void acceptChecked(T arg) throws E;

}
