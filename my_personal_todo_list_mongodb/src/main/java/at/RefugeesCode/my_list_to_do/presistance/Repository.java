package at.RefugeesCode.my_list_to_do.presistance;

import at.RefugeesCode.my_list_to_do.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface Repository extends MongoRepository<Todo,String> {
    List<Todo> findAll();
    Optional<Todo> findById(String id) ;

}
