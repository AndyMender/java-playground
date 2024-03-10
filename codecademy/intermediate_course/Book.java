package codecademy.intermediate_course;

public class Book {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    // No setter is needed
    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return String.format("{ 'name': '%s' }", this.title);
    }
}
