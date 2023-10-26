package codecademy.intro_course;

public class DataConvertion {
    public static void main(String[] args){
        int num = 15;
        // Int printing as int
        System.out.println("Pure int value: " + num);

        // Convert int value to String
        // NOTE: No difference in output
        String string = String.valueOf(num);
        System.out.println("Converted string value: " + string);
        
        // Convert String back to an int
        // NOTE: Calling .parseInt() on an invalid integer will throw
        int numBack = Integer.parseInt(string);
        System.out.println("Pure int value again: " + numBack);
        numBack++;
        System.out.println("Pure int value again: " + numBack);
    }
}
