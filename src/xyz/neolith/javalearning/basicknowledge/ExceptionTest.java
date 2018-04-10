package xyz.neolith.javalearning.basicknowledge;

/**
 * Except {@code RuntimeException} all the Exception and the subclasses
 * are checkedException
 * @author sunlggggg
 * @date 2018/4/10
 */
class UncheckedException extends RuntimeException{

    UncheckedException(String message){
        super(message);
    }
}

class CheckedException extends Exception{
    CheckedException(String message){
        super(message);
    }
}
public class ExceptionTest {
    private static void testUncheckedException(){
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
