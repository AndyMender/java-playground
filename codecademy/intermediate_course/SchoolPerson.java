package codecademy.intermediate_course;

public abstract class SchoolPerson {
    private String name;

    public SchoolPerson(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        final String[] splitName = this.getClass().getName().split("\\.");

        return String.format(
            "%s (name: %s)",
            splitName[splitName.length - 1],
            this.getName()
        );
    } 
}
