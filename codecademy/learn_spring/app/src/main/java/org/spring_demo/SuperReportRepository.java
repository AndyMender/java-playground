package org.spring_demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SuperReportRepository {
    private List<SuperReport> repository = new ArrayList<>(); 

    public void save(SuperReport heroReport) {
        repository.add(heroReport);
    }

    // TODO: Should return a copy instead of a reference?
    public List<SuperReport> findAll() {
        return repository;
    }
    
    public List<SuperReport> findByPostalCode(String postalCode) {
        return repository
            .stream()
            .filter(x -> x.getPostalCode().equals(postalCode))
            .collect(Collectors.toList());
    }

    public List<SuperReport> findByStreetAddress(String streetAddress) {
        return repository
            .stream()
            .filter(x -> x.getStreetAddress().equals(streetAddress))
            .collect(Collectors.toList());
    }

    public List<SuperReport> findByHeroName(String heroName) {
        // It's okay for 'heroName' to be empty - multiple returned records are supported
        return repository
            .stream()
            .filter(x -> x.getHeroName().equals(heroName))
            .collect(Collectors.toList());
    }
}
