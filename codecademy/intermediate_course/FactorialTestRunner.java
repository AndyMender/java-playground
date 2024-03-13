package codecademy.intermediate_course;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class FactorialTestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(FactorialTestSuite.class);

        for (Failure failure : result.getFailures()) {
        System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());

    }
}
