package org.spring_demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SuperHeroRepository {
    private List<SuperHero> repository = new ArrayList<>();

    public void save(SuperHero superhero) {
        repository.add(superhero);
    }

    // TODO: Should return a copy instead of a reference?
    public List<SuperHero> findAll() {
        return repository;
    }

    public List<SuperHero> findByFirstName(String firstName) {
        return repository
            .stream()
            .filter(x -> x.getFirstName().equals(firstName))
            .collect(Collectors.toList());
    }

    public List<SuperHero> findByLastName(String lastName) {
        return repository
            .stream()
            .filter(x -> x.getLastName().equals(lastName))
            .collect(Collectors.toList());
    }

    public List<SuperHero> findBySuperpower(String superpower) {
        return repository
            .stream()
            .filter(x -> x.getSuperpower().equals(superpower))
            .collect(Collectors.toList());
    }

}