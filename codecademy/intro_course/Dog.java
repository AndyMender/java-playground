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
        return "Woof woof! I am a dog of breed " + this.breed + " and I am " + this.age + " years old!" 
        + " My name is " + this.name + ". Woof woof!";
    }

    @Override public int compareTo(Dog b) {
        if (this.age == b.age) return 0;
        else if (this.age > b.age) return 1;
        else return -1;
    }

    public static void main(String[] args) {
        var dogs = new ArrayList<Dog>();

        var barney = new Dog("Barney", "retriever", 2, false);
        var stevie = new Dog("Stevie", "chihua hua", 1.5, true);

        System.out.println(barney);
        System.out.println(stevie);
 
        dogs.add(barney);
        dogs.add(stevie);
        dogs.add(new Dog("Barney", "retriever", 1.25, false));

        // Super verbose due to the toString() override in Dog class...
        System.out.println(dogs);
        Collections.sort(dogs);
        System.out.println(dogs);
   }  
}
