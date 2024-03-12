package codecademy.intermediate_course;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrencyDemo {
    private static String userNameDefault = "Dave";
    private static long userIDDefault = 1L;
    private static long orderNumberDefault = 0L;

    public static String fetchUserName() {
        return userNameDefault;
    }

    public static long fetchUserID() {
        return userIDDefault;
    }

    public static long fetchOrderNumber() {
        return orderNumberDefault;
    }

    public static void main(String[] args) {
        try (ExecutorService execService = Executors.newVirtualThreadPerTaskExecutor()) {
            // We can assume the fetch functions have the relevant information of a user 
            Future<String> userName = execService.submit(() -> fetchUserName());
            Future<Long> userID = execService.submit(() -> fetchUserID());
            Future<Long> orderNumber = execService.submit(() -> fetchOrderNumber());

            // Get results from the completed tasks 
            try {
                String result1 = userName.get(); 
                long result2 = userID.get(); 
                long result3 = orderNumber.get(); 

                System.out.println(
                    String.format("username: %s, userID: %d, order number: %d", 
                    result1,
                    result2,
                    result3
                ));

            } catch (InterruptedException | ExecutionException exc) {
                System.err.println(exc);
            }
        }
    }
}
