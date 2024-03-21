package org.spring_demo;

public class SuperReport {
    // Client's dispatch details
    private final String postalCode;
    private final String streetAddress;
    // Needed for searches in the 'SuperHeroRepository'
    private final String heroName;

    public SuperReport(String postalCode, String streetAddress, String heroName) {
        this.postalCode = postalCode;
        this.streetAddress = streetAddress;
        this.heroName = heroName;
    }
}
