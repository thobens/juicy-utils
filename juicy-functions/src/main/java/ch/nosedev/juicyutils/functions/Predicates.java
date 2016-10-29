package ch.nosedev.juicyutils.functions;

import java.util.function.Predicate;

/**
 * {@link JuicyFunctions} implementation for the {@link java.util.function.Predicate} function
 *
 * @param <T> The type of the parameter accepted by this {@link #predicate}s implementation of {@link java.util.function.Predicate#test(Object)} (Object)}
 * @param <E> The Exception caught by {@link #thenCatch(Catcher)}
 */
public class Predicates<T, E extends Exception> extends AbstractJuicyFunctions<Predicate<T>, Boolean, E> {

    protected CheckedPredicate<T, E> predicate;

    protected Predicates(CheckedPredicate<T, E> predicate) {
        super();
        this.def = () -> false;
        this.predicate = predicate;
    }

    /**
     * Builder method to initialize builder
     *
     * @param predicate The {@link CheckedPredicate} object that possibly throws <code>E</code>
     * @param <T>       The type of the parameter accepted by the given predicate
     * @param <E>       The Exception thrown by the predicate
     * @return A reference to this object
     */
    public static <T, E extends Exception> Predicates<T, E> doTry(CheckedPredicate<T, E> predicate) {
        return new Predicates<>(predicate);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Predicate<T> thenCatch(Catcher<E> catcher) {
        return arg -> {
            try {
                return predicate.testChecked(arg);
            } catch (Exception e) {
                if (catcher != null) {
                    catcher.catchException((E) e);
                }
                return def.returnDefault();
            }
        };
    }

}
