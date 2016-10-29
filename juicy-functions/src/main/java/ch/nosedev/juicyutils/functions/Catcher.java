package ch.nosedev.juicyutils.functions;

@FunctionalInterface
public interface Catcher<E extends Exception> {

    void catchException(E e);

}
