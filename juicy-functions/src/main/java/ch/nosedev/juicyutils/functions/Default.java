package ch.nosedev.juicyutils.functions;

/**
 * Functional interface to return a default value. It is supposedly helping prevent NPEs.
 * @param <T> The type of the default value to return by {@link #returnDefault()}
 */
@FunctionalInterface
public interface Default<T> {

    T returnDefault();
}
