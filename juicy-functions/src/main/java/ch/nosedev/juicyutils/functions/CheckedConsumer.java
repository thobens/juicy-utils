package ch.nosedev.juicyutils.functions;

/**
 * Created by thobens on 28.10.16.
 */
public interface CheckedConsumer<T, E extends Throwable>  {


    void acceptChecked(T t) throws E;

}
