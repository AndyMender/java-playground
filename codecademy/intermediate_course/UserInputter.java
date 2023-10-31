package codecademy.intermediate_course;

// NOTE: java.lang is imported by default, java.util and java.io are not!
import java.util.Scanner;

public class UserInputter {
    public static void main(String[] args) {
        // Scanner supports a look-ahead check if a value of a given type is available
        // and reading all value types one by one, from a string, file and stdin.
        // A delimiter can be set to parse simple data files (for instance, CSV)
        Scanner input = new Scanner(System.in);
        String userName = "player";

        System.out.print("What is your name traveler? ");
        if (input.hasNext()) {
            userName = input.next();
        }
        System.out.printf("Welcome to the Wilderness %s...\n", userName);
    }
}
