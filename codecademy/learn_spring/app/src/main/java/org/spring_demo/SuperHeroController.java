package org.spring_demo;

import java.lang.Iterable;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;   // enum containing GET, POST, DELETE, etc.
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// NOTE: The default HTTP 'method' is 'RequestMethod.GET'
@RestController
@RequestMapping("/superHeroes")
public class SuperHeroController {
  private final SuperHeroRepository superHeroRepository;
  private final SuperReportRepository superReportRepository;

  // TODO: The repository objects can be fed from the main 'App' code
  public SuperHeroController(SuperHeroRepository superHeroRepository, SuperReportRepository superReportRepository) {
    this.superHeroRepository = superHeroRepository;
    this.superReportRepository = superReportRepository;
  }

  // Main endpoint
  // NOTE: In addition to 'GetMapping' and 'PostMapping', there are wrappers for other HTTP methods
  @GetMapping()
  public Iterable<SuperHero> getSuperHeros() {
    Iterable<SuperHero> superHeroes = superHeroRepository.findAll();
    return superHeroes;
  }

  // 'RequestBody' is used to convert the HTTP POST payload JSON into a Java object
  @PostMapping("/addNew")
  public String createNewSuperHero(@RequestBody SuperHero superHero) {
    superHeroRepository.save(superHero);
    return String.format(
      "Superhero %s %s successfully added!",
      superHero.getFirstName(),
      superHero.getLastName()
    );
  }

  // 'RequestParam' is used to consume URL query parameters
  @PostMapping("/help")
  public String postHelp(@RequestParam String postalCode, @RequestParam String streetAddress) {
    SuperReport newSuperReport = new SuperReport(postalCode, streetAddress, "");
    superReportRepository.save(newSuperReport);
    return String.format(
      "Thanks! Superheroes have been dispatched to %s, %s!",
      streetAddress,
      postalCode
    );
  }

  @GetMapping("/heroReport")
  public Iterable<SuperReport> getHeroReports() {
    Iterable<SuperReport> superReport = superReportRepository.findAll();
    return superReport;
  }

  // parametrized mapping
  @PostMapping("/{postalCode}")
  public Iterable<SuperReport> getHeroReportByPostal(@PathVariable String postalCode) {
    Iterable<SuperReport> superReport = superReportRepository.findByPostalCode(postalCode);
    return superReport;
  }
}