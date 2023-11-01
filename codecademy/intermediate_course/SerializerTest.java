package codecademy.intermediate_course;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializerTest {
    public static void main (String[] args) throws ClassNotFoundException, IOException {
        String filePath = "./persons.data";
        var benjamin = new Person("Benjamin", 21);
        var thomas = new Person("Thomas", 39);

        // Serialize object data
        try(
            var outputFile = new FileOutputStream(filePath);
            var outputStream = new ObjectOutputStream(outputFile)
        ) {
            outputStream.writeObject(benjamin);
            outputStream.writeObject(thomas);
        }

        // Deserialize object data
        try(
            var inputFile = new FileInputStream(filePath);
            var inputStream = new ObjectInputStream(inputFile)
        ) {
            // NOTE: Reading is done in reverse order to serialization
            var person2 = (Person) inputStream.readObject();
            assert person2.getAge() == thomas.getAge();
            assert person2.getName() == thomas.getName();
        }
    }
}
