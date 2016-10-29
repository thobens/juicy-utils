package ch.nosedev.juicyutils.functions;

/**
 * Builder interface to create an anonymous method and handling an exception
 *
 * @param <F>
 * @param <R>
 * @param <E>
 */
public interface JuicyFunctions<F, R, E extends Exception> {

    /**
     * Returns a default value of <code>R</code>
     *
     * @param def The default value to return
     * @return An instance of this object for chaining
     */
    JuicyFunctions<F, R, E> returnDefault(R def);

    /**
     * Currently the build method.
     *
     * @param catcher The anonymous function that catches the exception thrown by
     * @return An anonymous function wrapping a checked function
     */
    F thenCatch(Catcher<E> catcher);

    /**
     * Default method to make shure that the thrown exception by the function proxy to
     *
     * @return An anonymous function wrapping a checked function with the default
     */
    default F swallow() {
        return thenCatch(null);
    }
}
