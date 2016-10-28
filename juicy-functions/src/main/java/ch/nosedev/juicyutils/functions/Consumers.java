package ch.nosedev.juicyutils.functions;

import java.util.function.Consumer;

/**
 * Created by thobens on 20.10.16.
 */
public class Consumers<T, E extends Throwable> extends AbstractJuicyFunctions<Consumer<T>, Void, E> {

    protected CheckedConsumer<T, E> consumer;

    protected Consumers(CheckedConsumer<T, E> consumer) {
        super();
        this.consumer = consumer;
    }

    public static <T, E extends Throwable> Consumers<T, E> doTry(CheckedConsumer<T, E> consumer) {
        return new Consumers<>(consumer);
    }

    @Override
    public Consumer<T> thenCatch(Catcher<E> catcher) {
        return (arg) -> {
            try {
                consumer.acceptChecked(arg);
            } catch(Throwable e) {
                if(catcher != null) {
                    catcher.catchException((E) e);
                }
            }
        };
    }

}
