package ch.nosedev.juicyutils.functions;

import java.util.function.Function;

/**
 * {@link JuicyFunctions} implementation for the {@link Function} function
 *
 * @param <T> The type of the parameter accepted by this {@link #func}s implementation of {@link Function#apply(Object)}
 * @param <R> The return type of this {@link #func}s  implementation of {@link Function#apply(Object)}
 * @param <E> The Exception caught by {@link #thenCatch(Catcher)}
 */
public class Functions<T, R, E extends Exception> extends AbstractJuicyFunctions<Function<T, R>, R, E> {

    protected CheckedFunction<T, R, E> func;

    protected Functions(CheckedFunction<T, R, E> func) {
        super();
        this.func = func;
    }

    /**
     * Builder method to initialize builder
     *
     * @param func The {@link CheckedConsumer} object that possibly throws <code>E</code>
     * @param <T>  The type of the parameter accepted by the given function
     * @param <R> The return type of the given function
     * @param <E>  The Exception thrown by the consumer}
     * @return A reference to this object
     */
    public static <T, R, E extends Exception> Functions<T, R, E> doTry(CheckedFunction<T, R, E> func) {
        return new Functions<>(func);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Function<T, R> thenCatch(Catcher<E> catcher) {
        return arg -> {
            try {
                return func.applyChecked(arg);
            } catch (Exception e) {
                if(catcher != null) {
                    catcher.catchException((E) e);
                }
                return (R) def.returnDefault();
            }
        };
    }

}
