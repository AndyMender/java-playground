package codecademy.intermediate_course;

import java.io.Serializable;

// 'Serializable' does not contain any methods so no need for overrides,
// however, the definition of the serialized class needs to be imported for the JVM to know its composition.
public class Person implements Serializable {
    private String name;   
    private int age;
    // Used by the JVM to check for compatibility and properly deserialize the object.
    // If the value is not specified, the default might not work across JVM versions.
    private static final long serialVersionUID = 1L;

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
}
