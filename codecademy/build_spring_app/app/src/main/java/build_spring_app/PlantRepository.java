// Normally you would have these in a separate 'repositories' sub-package
package build_spring_app;

import org.springframework.data.repository.CrudRepository;

// 'CrudRepository' is a generic interface which provides basic ORM features like searching by table Id, .save, .delete, etc.
// 1st param - ORM data object type
// 2nd param - Id column type
public interface PlantRepository extends CrudRepository<Plant, Integer> {

    
} 