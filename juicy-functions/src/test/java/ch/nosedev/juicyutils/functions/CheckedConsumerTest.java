package ch.nosedev.juicyutils.functions;

import org.junit.Before;
import org.junit.Test;

import static ch.nosedev.juicyutils.functions.Consumers.doTry;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

/**
 * Created by thobens on 28.10.16.
 */
public class CheckedConsumerTest {

    private TestException expectedException;

    @Before
    public void setup() {
        expectedException = spy(new TestException());
    }

    @Test
    public void tryCatchWithConsumerAcceptingNullThrowsNpe() {
        doTry(this::doSomething).thenCatch(Throwable::printStackTrace).accept(null);

        // Behavior verification is accepted here since we do not depend on implementation details (expectedException is a test class)
        verify(expectedException).printStackTrace();
    }

    @Test
    public void tryCatchWithConsumerAcceptingNonNullYieldsNoError() {
        doTry(this::doSomething).thenCatch(Throwable::printStackTrace).accept("asdf");

        // Behavior verification is accepted here since we do not depend on implementation details (expectedException is a test class)
        verifyZeroInteractions(expectedException);
    }

    @Test
    public void tryCatchWithConsumerAcceptingNullSwallowsException() {
        doTry(this::doSomething).swallow().accept(null);

        // Behavior verification is accepted here since we do not depend on implementation details (expectedException is a test class)
        verifyZeroInteractions(expectedException);
    }


    /**
     * Serves as a consumer method to create function pointers to.
     *
     * @param s some string
     * @throws NullPointerException Thrown if s is null
     */
    private void doSomething(String s) throws TestException {
        if(s == null) {
            throw expectedException;
        }
        s.length();
    }

    /**
     * Test Class for behavior verification
     */
    private class TestException extends Exception {

        public void printStackTrace() {

        }

    }

}
