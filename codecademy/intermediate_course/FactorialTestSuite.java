package codecademy.intermediate_course;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  // List of test classes to bundle togethe
  TestFactorial.class
})

// No content needed - just a dummy prop for the test runner
public class FactorialTestSuite {

}
