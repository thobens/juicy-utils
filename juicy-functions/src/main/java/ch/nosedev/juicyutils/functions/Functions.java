package ch.nosedev.juicyutils.functions;

import java.util.function.Function;

public class Functions<T, R, E extends Exception> extends AbstractJuicyFunctions<Function<T, R>, R, E> {

    protected CheckedFunction<T, R, E> consumer;

    protected Functions(CheckedFunction<T, R, E> func) {
        super();
        this.consumer = func;
    }

    public static <T, R, E extends Exception> Functions<T, R, E> doTry(CheckedFunction<T, R, E> consumer) {
        return new Functions<>(consumer);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Function<T, R> thenCatch(Catcher<E> catcher) {
        return (arg) -> {
            try {
                return consumer.applyChecked(arg);
            } catch (Exception e) {
                if(catcher != null) {
                    catcher.catchException((E) e);
                }
                return (R) def.returnDefault();
            }
        };
    }

}
