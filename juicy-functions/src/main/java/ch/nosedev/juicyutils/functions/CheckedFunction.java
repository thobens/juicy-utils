package ch.nosedev.juicyutils.functions;

@FunctionalInterface
public interface CheckedFunction<T, R, E extends Exception> {

    R applyChecked(T param) throws E;

}
