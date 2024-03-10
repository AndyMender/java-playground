package codecademy.intermediate_course;

public class Teacher extends SchoolPerson {
    private String subject;

    public Teacher(String name, String subject) {
        super(name);
        this.subject = subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return this.subject;
    }

    public String toString() {
        final String[] splitName = this.getClass().getName().split("\\.");

        return String.format(
            "%s (name: %s, responsible for: %s)",
            splitName[splitName.length - 1],
            this.getName(),
            this.getSubject()
        );
    } 
}
