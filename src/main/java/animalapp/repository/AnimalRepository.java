package animalapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import animalapp.bean.Animal;


// Repository extends the JpaRepository for access to its class methods (Ex. findAll() method)
// Repository uses the Animal class and the Id is of type Long
// Repository communicates with the DB to create a table for the Animal class
public interface AnimalRepository extends JpaRepository<Animal, Long> {}