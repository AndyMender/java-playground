package codecademy.intermediate_course;

import org.junit.Test;
// NOTE: 'static' imports allow pulling static methods from classes
import static org.junit.Assert.*;

public class TestFactorial {
    @Test
    public void testFactorial() {
        assertEquals(Factorial.compute(4), 24);
        assertEquals(Factorial.compute(5), 120);
        assertEquals(Factorial.compute(1), 1);
        assertEquals(Factorial.compute(0), 1);
  }
}
