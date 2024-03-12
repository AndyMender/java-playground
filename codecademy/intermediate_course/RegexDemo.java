package codecademy.intermediate_course;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("hammer time");       
        Matcher matcher = pattern.matcher("Iiiiiit's hammer time!");

        System.out.println(matcher.matches());
        // NOTE: 'Matcher.find()' will start sliding along the target String, impacting '.results()'
        System.out.println(matcher.results().count());
    }
}
