package app.repository;

import app.entities.MessageDB;
import org.springframework.data.repository.CrudRepository;


public interface MessagesRepository extends CrudRepository<MessageDB, Integer> {
    Iterable<MessageDB> findAllByOrderByDateAsc();
}

