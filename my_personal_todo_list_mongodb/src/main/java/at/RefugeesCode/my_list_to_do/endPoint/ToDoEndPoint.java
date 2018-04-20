package at.RefugeesCode.my_list_to_do.endPoint;

import at.RefugeesCode.my_list_to_do.model.Todo;
import at.RefugeesCode.my_list_to_do.presistance.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class ToDoEndPoint {
    private Repository repository;

    public ToDoEndPoint(Repository repository){
        this.repository = repository;

    }


    @PostMapping
    Todo addTodo(@RequestBody Todo todo){
       repository.save(todo);
       return todo;


    }
    @GetMapping
    List<Todo> findAll(){
        return repository.findAll();
    }
    @GetMapping("/{id}")
    Todo findbyId(@PathVariable String id){

        return repository.findById(id).get();
    }
    @PutMapping("/{id}/done")
    Todo checkDone(@PathVariable String id){

        Todo todo = repository.findById(id).get();
        todo.setDone(true);
        repository.save(todo);
        return todo;
    }
    @PutMapping("/{id}/notdone")
    Todo checkunDone(@PathVariable String id){
        Todo todo = repository.findById(id).get();
        todo.setDone(false);
        repository.save(todo);
        return todo;
    }
    @DeleteMapping("/{id}/delete")
    void delete(@PathVariable String id){
        repository.deleteById(id);
    }

}
