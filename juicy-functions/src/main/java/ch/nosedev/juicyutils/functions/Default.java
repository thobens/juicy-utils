package ch.nosedev.juicyutils.functions;

/**
 * Convenient functional interface to return a default value. It is supposedly helping prevent NPEs.
 *
 * @param <T> The type of the default value to return by {@link #returnDefault()}
 */
@FunctionalInterface
public interface Default<T> {

    /**
     * Returns a default value. It should be statically returned by this method.
     *
     * @return a default value
     */
    T returnDefault();
}
