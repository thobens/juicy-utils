package ch.nosedev.juicyutils.functions;

import java.util.function.Consumer;

/**
 * {@link JuicyFunctions} implementation for the {@link Consumer} function
 *
 * @param <T> The type of the parameter accepted by this {@link #consumer}s implementation of {@link Consumer#accept(Object)}
 * @param <E> The Exception caught by {@link #thenCatch(Catcher)}
 */
public class Consumers<T, E extends Exception> extends AbstractJuicyFunctions<Consumer<T>, Void, E> {

    protected CheckedConsumer<T, E> consumer;

    protected Consumers(CheckedConsumer<T, E> consumer) {
        super();
        this.consumer = consumer;
    }

    /**
     * Builder method to initialize builder
     *
     * @param consumer The {@link CheckedConsumer} object that possibly throws <code>E</code>
     * @param <T>      The type of the parameter accepted by the given consumer
     * @param <E>      The Exception thrown by the consumer}
     * @return A reference to this object
     */
    public static <T, E extends Exception> Consumers<T, E> doTry(CheckedConsumer<T, E> consumer) {
        return new Consumers<>(consumer);
    }

    @Override
    public Consumer<T> thenCatch(Catcher<E> catcher) {
        return arg -> {
            try {
                consumer.acceptChecked(arg);
            } catch (Exception e) {
                if(catcher != null) {
                    catcher.catchException((E) e);
                }
            }
        };
    }

}
