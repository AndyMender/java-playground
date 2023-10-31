package codecademy.intermediate_course;

import java.io.IOException;
import java.io.PrintWriter;

public class FileOutputter {
    public static void main(String[] args) throws IOException {
        String filePath = "./test_output.txt";

        try (var writer = new PrintWriter(filePath)) {
            writer.println("Some text");
            writer.println("Even more text!");
        }
    }  
}
