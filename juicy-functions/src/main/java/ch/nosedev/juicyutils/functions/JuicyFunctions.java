package ch.nosedev.juicyutils.functions;

/**
 * Created by thobens on 28.10.16.
 */
public interface JuicyFunctions<F, R, E extends Throwable> {

    JuicyFunctions<F, R, E> returnDefault(R def);

    F thenCatch(Catcher<E> catcher);

    F swallow();
}
