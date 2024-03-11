package codecademy.intermediate_course;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HugeProblemSolver extends Thread {
    private final int maxWaitMili = 30 * 1000;
    private String clientName;

    public HugeProblemSolver(String name) {
        // Required constructor used for passing information to the start() method.
        this.clientName = name;
    }

    public String getClientName() {
        return this.clientName;
    }

    private void solveComputation() {
        int waitTime = new Random().nextInt(this.maxWaitMili);
        waitTime = Math.max(waitTime, 5 * 1000);

        // NOTE: 'Thread.sleep()' can throw - need to handle it
        try {
            System.out.println(
                String.format(
                    "Oh boy, this is a HARD problem, %s, give me around %d secs, okay?",
                    this.getClientName(),
                    waitTime / 1000
                )
            );
            // Random wait/sleep to simulate threads
            Thread.sleep(waitTime);
        } catch (InterruptedException exc) {
            System.err.println(exc);
        } finally {
            System.out.println(String.format("Done processing, %s!", this.getClientName()));
        }
    }

    // Will be kicked off by 'Thread.run()'
    @Override
    public void run() {
        solveComputation();
        System.out.println("The answer is: 42");
    }

    public static void main(String[] args){
        List<HugeProblemSolver> problems = Arrays.asList(
            new HugeProblemSolver("Brian"),
            new HugeProblemSolver("Mike"),
            new HugeProblemSolver("Bob")
        );

        problems.stream().forEach(problem -> {
            problem.start();
        });
    }
}
