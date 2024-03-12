package codecademy.intermediate_course;

// NOTE: Implementing 'Runnable' is a more lightweight approach to threading
public class SmallProblemSolver {
    public static void main(String[] args) {
        // NOTE: In the background 'Thread' will still create a 'Runnable' object.
        //       The downside is that the threads are anonymous and untracked.
        //       The upside is that the class doesn't need to implement 'Runnable'.
        new Thread(() -> {
            System.out.println(Factorial.compute(0));
        }).start();

        new Thread(() -> {
            System.out.println(Factorial.compute(5));
        }).start();

        new Thread(() -> {
            System.out.println(Factorial.compute(7));
        }).start();
    }
}
