// Normally you would have these in a separate 'repositories' sub-package
package build_spring_app;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

// 'CrudRepository' is a generic interface which provides basic ORM features like searching by table Id, .save, .delete, etc.
// 1st param - ORM data object type
// 2nd param - Id column type
public interface PlantRepository extends CrudRepository<Plant, Integer> {
    // Spring will generate the complete implementation based on the input 'Plant' model and the method name
    List<Plant> findByHasFruitTrue();

    List<Plant> findByHasFruitFalse();

    List<Plant> findByQuantityLessThan(Integer quantity);

    // Combines 'hasFruit = true' && 'quantity < X'
    List<Plant> findByHasFruitTrueAndQuantityLessThan(Integer quantity);

    // Combines 'hasFruit = false' && 'quantity < X'
    List<Plant> findByHasFruitFalseAndQuantityLessThan(Integer quantity);
} 
