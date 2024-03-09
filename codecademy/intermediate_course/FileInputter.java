package codecademy.intermediate_course;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileInputter {
    public static void main(String[] args) throws IOException {
        String filePath = "./README.md.bak";

        // try-with-resources without read buffering via 'BufferedReader'
        // Also takes a param of type 'File' constructed from the 'fileName'
        try (var reader = new FileReader(filePath)) {
            System.out.println("Reading file content:");
            while(reader.ready()) {
                System.out.print((char) reader.read());
            }
        } catch (FileNotFoundException exc) {
            System.err.println("Error: " + exc.getMessage());
            System.err.println("Couldn't find file to read: " + filePath + ". Exiting!");
        }
    }
}
