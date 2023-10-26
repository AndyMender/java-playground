package codecademy.intro_course;

public class TestProfile {
    public static void main(String[] args) {
        String name = "Andy";
        int age = 34;
        double desiredSalary = 74000.00;
        boolean lookingForJob = false;
        System.out.print("Hello, my name is " + name + ".");
        System.out.print(" I am " + age + " years old.");
        System.out.println(" I am " + (lookingForJob ? "looking for a job." : "not looking for a job."));
        if (lookingForJob) {
            System.out.println("My expected salary is approximately: " + desiredSalary);
        }
    }
}
