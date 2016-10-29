package ch.nosedev.juicyutils.functions;

import java.util.function.Consumer;

public class Consumers<T, E extends Exception> extends AbstractJuicyFunctions<Consumer<T>, Void, E> {

    protected CheckedConsumer<T, E> consumer;

    protected Consumers(CheckedConsumer<T, E> consumer) {
        super();
        this.consumer = consumer;
    }

    public static <T, E extends Exception> Consumers<T, E> doTry(CheckedConsumer<T, E> consumer) {
        return new Consumers<>(consumer);
    }

    @Override
    public Consumer<T> thenCatch(Catcher<E> catcher) {
        return (arg) -> {
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
