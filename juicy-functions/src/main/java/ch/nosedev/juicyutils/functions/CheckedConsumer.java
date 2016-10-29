package ch.nosedev.juicyutils.functions;

public interface CheckedConsumer<T, E extends Exception> {


    void acceptChecked(T t) throws E;

}
