package ch.nosedev.juicyutils.functions;

/**
 * Functional interface to catch a previously thrown {@link Exception}
 *
 * @param <E> Type of the {@link Exception} to catch
 */
@FunctionalInterface
public interface Catcher<E extends Exception> {

    /**
     * Receives an {@link Exception} for further exception handling.
     *
     * @param e an {@link Exception}
     */
    void catchException(E e);

}
