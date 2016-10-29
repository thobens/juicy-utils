package ch.nosedev.juicyutils.functions;

public interface JuicyFunctions<F, R, E extends Exception> {

    JuicyFunctions<F, R, E> returnDefault(R def);

    F thenCatch(Catcher<E> catcher);

    F swallow();
}
