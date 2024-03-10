package codecademy.intermediate_course;

public class ContainerHandler {
    public static void main(String[] args) {
        String word = "Hello";
        int number = 56;
        Book book = new Book("Fire and the Wolf");
        
        // Demonstrate the use of generics
        Container<String> wordBox = new Container<>(word);
        // NOTE: 'number' is auto-boxed to the 'Integer' type,
        //       using 'Integer.valueOf(number)'
        // 
        // Unboxing can be done using 'Integer.intValue()'
        Container<Integer> intBox = new Container<>(number);
        Container<Book> bookBox = new Container<>(book);

        System.out.println("Box of words: " + wordBox.getData());
        System.out.println("Box of numbers: " + intBox.getData());
        System.out.println("Box of books: " + bookBox.getData());
    }
}
