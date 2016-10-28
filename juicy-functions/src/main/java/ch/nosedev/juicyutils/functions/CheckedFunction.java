package ch.nosedev.juicyutils.functions;

/**
 * Created by thobens on 20.10.16.
 */
@FunctionalInterface
public interface CheckedFunction<T, R, E extends Throwable> {

    R applyChecked(T param) throws E;

}
