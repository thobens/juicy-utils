package ch.nosedev.juicyutils.functions;

/**
 * Created by thobens on 20.10.16.
 */
@FunctionalInterface
public interface Catcher<E extends Throwable> {

    void catchException(E e);

}
