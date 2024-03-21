package org.spring_demo;

public class SuperHero {
    private final String firstName;
    private final String lastName;
    private final String superpower;

    public SuperHero(String firstName, String lastName, String superpower) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.superpower = superpower;
    }
    
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSuperpower() {
        return superpower;
    }
}
