package ch.nosedev.juicyutils.functions;

public abstract class AbstractJuicyFunctions<F, R, E extends Exception> implements JuicyFunctions<F, R, E> {

    protected Default<?> def = Default.defaultNull();

    protected AbstractJuicyFunctions() {
        def = Default.defaultNull();
    }

    public JuicyFunctions<F, R, E> returnDefault(R def) {
        this.def = () -> def;
        return this;
    }


    @Override
    public F swallow() {
        return thenCatch(null);
    }
}
