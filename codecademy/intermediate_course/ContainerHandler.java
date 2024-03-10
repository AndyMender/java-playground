package codecademy.intermediate_course;

public class ContainerHandler {
    public static void main(String[] args) {
        String word = "Hello";
        Book book = new Book("Fire and the Wolf");
        
        // Demonstrate the use of generics
        Container<String> wordBox = new Container<>(word);
        Container<Book> bookBox = new Container<>(book);

        System.out.println("Box of words: " + wordBox.getData());
        System.out.println("Box of books: " + bookBox.getData());
    }
}
