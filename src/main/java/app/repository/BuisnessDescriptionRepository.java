package app.repository;

import app.models.BuisnessDescriptionDB;
import org.springframework.data.repository.CrudRepository;


public interface BuisnessDescriptionRepository extends CrudRepository<BuisnessDescriptionDB, Integer> {
    Iterable<BuisnessDescriptionDB> getByCategory (String category);
}

