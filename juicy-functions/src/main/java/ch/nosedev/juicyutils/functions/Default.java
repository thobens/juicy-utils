package ch.nosedev.juicyutils.functions;

/**
 * Created by thobens on 28.10.16.
 */
public interface Default<T> {

    static Default<Void> defaultNull() {
        return () -> null;
    }

    T returnDefault();
}
