package ch.nosedev.juicyutils.functions;

import org.junit.Before;
import org.junit.Test;

import static ch.nosedev.juicyutils.functions.Predicates.doTry;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CheckedPredicateTest {

    private TestException expectedException;

    @Before
    public void setup() {
        expectedException = spy(new TestException());
    }

    @Test
    public void tryCatchWithPredicateTestingNullThrowsNpe() {
        doTry(this::doSomething).returnDefault(false).thenCatch(Exception::printStackTrace).test(null);

        // Behavior verification is accepted here since we do not depend on implementation details (expectedException is a test class)
        verify(expectedException).printStackTrace();
    }

    @Test
    public void tryCatchWithPredicateTestingNonNullYieldsNoError() {
        doTry(this::doSomething).thenCatch(Exception::printStackTrace).test("asdf");

        // Behavior verification is accepted here since we do not depend on implementation details (expectedException is a test class)
        verifyZeroInteractions(expectedException);
    }

    @Test
    public void tryCatchWithPredicateTestingNonNullYieldsNoErrorReturningNonNull() {
        boolean expected = false;

        boolean actual = doTry(this::doSomething).thenCatch(Exception::printStackTrace).test("asdf");

        // Behavior verification is accepted here since we do not depend on implementation details (expectedException is a test class)
        verifyZeroInteractions(expectedException);
        assertEquals(expected, actual);
    }

    @Test
    public void tryCatchWithPredicateTestingNullYieldsNoErrorReturningDefault() {
        boolean expected = true;

        boolean actual = doTry(this::doSomething).returnDefault(expected).thenCatch(Exception::printStackTrace).test(null);

        // Behavior verification is accepted here since we do not depend on implementation details (expectedException is a test class)
        verify(expectedException).printStackTrace();
        assertEquals(expected, actual);
    }

    @Test
    public void tryCatchWithPredicateTestingNullSwallowsException() {
        doTry(this::doSomething).swallow().test(null);

        // Behavior verification is accepted here since we do not depend on implementation details (expectedException is a test class)
        verifyZeroInteractions(expectedException);
    }

    /**
     * Serves as a predicate method to create function pointers to
     *
     * @param s some string
     * @throws NullPointerException Thrown if s is null
     */
    private boolean doSomething(String s) throws TestException {
        if (s == null) {
            throw expectedException;
        }
        return s.isEmpty();
    }

    /**
     * Test Class for behavior verification
     */
    private class TestException extends Exception {

        public void printStackTrace() {

        }

    }
}
