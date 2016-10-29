package ch.nosedev.juicyutils.functions;

/**
 * Basic implementation of {@link JuicyFunctions}
 *
 * @param <F> Any functional interface
 * @param <R> Return Type (use {@link Void} for no return type)
 * @param <E> Exception thrown by the abstract method of F
 */
public abstract class AbstractJuicyFunctions<F, R, E extends Exception> implements JuicyFunctions<F, R, E> {

    protected Default<R> def = () -> null;

    protected AbstractJuicyFunctions() {
        // empty default constructor
    }

    @Override
    public JuicyFunctions<F, R, E> returnDefault(R def) {
        this.def = () -> def;
        return this;
    }

}
