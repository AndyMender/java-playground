package codecademy.intermediate_course;

public class Factorial {
    public static int compute(int n) {
        int m = n;
        int factorial = 1;

        while (m > 0) {
            factorial *= m;
            m--;
        }

        return factorial;
    }
}
