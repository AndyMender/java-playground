package codecademy.intermediate_course;

public class Student extends SchoolPerson {
    private String bestSubject;

    public Student(String name, String bestSubject) {
        super(name);
        this.bestSubject = bestSubject;
    }

    public String getBestSubject() {
        return this.bestSubject;
    }

    public void setSubject(String bestSubject) {
        this.bestSubject = bestSubject;
    }

    public String toString() {
        final String[] splitName = this.getClass().getName().split("\\.");

        return String.format(
            "%s (name: %s, best student: %s)",
            splitName[splitName.length - 1],
            this.getName(),
            this.getBestSubject()
        );
    }
}
