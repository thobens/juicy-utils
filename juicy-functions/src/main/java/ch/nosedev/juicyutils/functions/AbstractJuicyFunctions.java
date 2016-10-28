package ch.nosedev.juicyutils.functions;

/**
 * Created by thobens on 28.10.16.
 */
public abstract class AbstractJuicyFunctions<F, R, E extends Throwable> implements JuicyFunctions<F, R, E> {

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
