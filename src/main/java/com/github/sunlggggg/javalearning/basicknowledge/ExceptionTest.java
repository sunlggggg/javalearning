package com.github.sunlggggg.javalearning.basicknowledge;

/**
 * Except {@code RuntimeException} all the Exception and the subclasses
 * are checkedException
 *
 * @author sunlggggg
 * @date 2018/4/10
 */
class UncheckedException extends RuntimeException {
    static final long serialVersionUID = 1L;
    UncheckedException(String message) {
        super(message);
    }
}

class CheckedException extends Exception {
    static final long serialVersionUID = 1L;
    CheckedException(String message) {
        super(message);
    }
}

/**
 * @author sunlggggg
 */
public class ExceptionTest {
    private static void testUncheckedException() {
        throw new UncheckedException("this a unchecked exception");
    }

    private static void testCheckedException() throws CheckedException {
        throw new CheckedException("this a checked exception");
    }

    public static void main(String[] args) {
        try {
            ExceptionTest.testCheckedException();
        } catch (CheckedException e) {
            e.printStackTrace();
        }
        ExceptionTest.testUncheckedException();
    }
}
