package codecademy.intro_course;

import java.util.Collections;
import java.util.ArrayList;

public class Dog implements Comparable<Dog> {
    String breed;
    String name;
    boolean hasOwner;
    double age;
    
    public Dog(String name, String breed, double age, boolean hasOwner) {
        this.breed = breed;
        this.name = name;
        this.hasOwner = hasOwner;
        this.age = age;
        // Optional variable transformation go here
    }

    // Make the class printable
    public String toString() {
        // NOTE: One could use a proper JSON implementation like 'jackson' or 'gson'
        return String.format("{'breed': '%s', 'age': '%s', 'name': '%s'}", this.breed, this.age, this.name);
    }

    // NOTE: When leveraging the built-in comparator, only 1 implementation can be selected.
    // However, 'Collections.sort()' works with a custom comparator as well
    @Override public int compareTo(Dog b) {
        return (this.age == b.age) ? 0
            : (this.age > b.age) ? 1
            : -1;
    }

    public static void main(String[] args) {
        var dogs = new ArrayList<Dog>();

        var barney = new Dog("Barney", "retriever", 2, false);
        var stevie = new Dog("Stevie", "chihua hua", 1.5, true);

        System.out.println("Here are my dogs...");
        System.out.println(barney);
        System.out.println(stevie);
 
        dogs.add(barney);
        dogs.add(stevie);
        dogs.add(new Dog("Barney", "retriever", 1.25, false));

        System.out.println("New dogs were added. All are here...");
        dogs.forEach(dog -> {
            System.out.println(dog);
        });
        Collections.sort(dogs);
        System.out.println("I arranged the dogs by age...");
        dogs.forEach(dog -> {
            System.out.println(dog);
        });
   }  
}
