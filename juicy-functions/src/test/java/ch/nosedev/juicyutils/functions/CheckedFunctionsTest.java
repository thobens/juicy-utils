package ch.nosedev.juicyutils.functions;

import org.junit.Before;
import org.junit.Test;

import static ch.nosedev.juicyutils.functions.Functions.doTry;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

/**
 * Created by thobens on 28.10.16.
 */
public class CheckedFunctionsTest {

    private TestException expectedException;

    @Before
    public void setup() {
        expectedException = spy(new TestException());
    }

    @Test
    public void tryCatchWithFunctionApplyingNullThrowsNpeAndDefaultsToNull() {
        Integer actual = doTry(this::doSomething).thenCatch(Throwable::printStackTrace).apply(null);

        verify(expectedException).printStackTrace();
        assertNull(actual);
    }

    @Test
    public void tryCatchWithFunctionApplyingNullWithDefaultThrowsNpeAndReturnsNonNull() {
        Integer expected = 1;

        Integer actual = doTry(this::doSomething).returnDefault(expected).thenCatch(Throwable::printStackTrace).apply(null);

        verify(expectedException).printStackTrace();
        assertEquals(expected, actual);
    }

    @Test
    public void tryCatchWithFunctionApplyingNonNullYieldsNoError() {
        String expected = "asdf";

        Integer actual = doTry(this::doSomething).thenCatch(Throwable::printStackTrace).apply(expected);

        // Behavior verification is accepted here since we do not depend on implementation details (expectedException is a test class)
        verifyZeroInteractions(expectedException);
        assertEquals(expected.length(), actual.intValue());
    }

    @Test
    public void tryCatchWithFunctionApplyingNullSwallowsException() {
        Integer actual = doTry(this::doSomething).swallow().apply(null);

        // Behavior verification is accepted here since we do not depend on implementation details (expectedException is a test class)
        verifyZeroInteractions(expectedException);
        assertNull(actual);
    }


    /**
     * Serves as a function method to create function pointers for testing.
     *
     * @param s some string
     * @throws NullPointerException Thrown if s is null
     * @return length of s
     */
    private Integer doSomething(String s) throws TestException {
        if(s == null) {
            throw expectedException;
        }
        return s.length();
    }

    /**
     * Test Class for behavior verification
     */
    private class TestException extends Exception {

        public void printStackTrace() {

        }

    }

}
