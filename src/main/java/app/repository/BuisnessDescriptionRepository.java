package app.repository;

import app.models.BuisnessDescription;
import org.springframework.data.repository.CrudRepository;


public interface BuisnessDescriptionRepository extends CrudRepository<BuisnessDescription, Integer> {
    public BuisnessDescription getByCategory (String category);
}

