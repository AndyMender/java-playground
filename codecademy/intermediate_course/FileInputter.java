package codecademy.intermediate_course;

import java.io.FileReader;
import java.io.IOException;

public class FileInputter {
    public static void main(String[] args) throws IOException {
        String filePath = "./README.md";

        // try-with-resources without read buffering via 'BufferedReader'
        // Also takes a param of type 'File' constructed from the 'fileName'
        try (var reader = new FileReader(filePath)) {
            while(reader.ready()) {
                System.out.print((char) reader.read());
            }
        }
    }
}
