package org.spring_demo;

import java.util.ArrayList;
import java.util.List;

public class SuperHeroRepository {
    private List<SuperHero> repository = new ArrayList<>();

    public void save(SuperHero superhero) {
        repository.add(superhero);
    }
}
