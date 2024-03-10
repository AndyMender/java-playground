package codecademy.intermediate_course;

import java.io.Serializable;

// 'Serializable' does not contain any methods so no need for overrides,
// however, the definition of the serialized class needs to be imported for the JVM to know its composition.
//
// serialization can be customized by overriding 'readObject' and 'writeObject' from the 'Serializable' interface
public class Person implements Serializable {
    private String name;        // String is a reference type, but it implements 'Serializable' so 'Person' can be serialized
    private int age;
    // Used by the JVM to check for compatibility and properly deserialize the object.
    // If the value is not specified, the default might not work across JVM versions.
    private static final long serialVersionUID = 1L;

    // NOTE: If the constructor only initializes fields, the default constructor can take care of that
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String toString() {
        return String.format("{ 'name': '%s', 'age': '%s' }", this.name, this.age);
    }

    @Override
    public boolean equals(Object obj) {
        // null case won't have any attributes - handle separately
        if (obj == null) {
            return false;
        }

        // A different class might have different attributes - handle separately
        if (obj.getClass() != this.getClass()) {
            return false;
        } 

        final Person other = (Person) obj;
        // NOTE: Strings use the 'equals()' operator for comparison!
        return (
            (this.getAge() == other.getAge()) &&
            (this.getName().equals(other.getName()))
        );
    }
}
