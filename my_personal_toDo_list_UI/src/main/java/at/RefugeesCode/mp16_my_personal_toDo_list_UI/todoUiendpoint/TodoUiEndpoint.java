package at.RefugeesCode.mp16_my_personal_toDo_list_UI.todoUiendpoint;

import at.RefugeesCode.mp16_my_personal_toDo_list_UI.model.Todo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
@RequestMapping("/")
public class TodoUiEndpoint {
    private RestTemplate restTemplate;

    private List<Todo> todoList;


    @Value("${todosurl}")
    String todosurl;

    public TodoUiEndpoint(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @ModelAttribute("todo")
    Todo addTodo() {
        return new Todo();
    }

    @PostMapping
    public String postNewTodo(Todo todo) {
        restTemplate.postForEntity(todosurl, todo, Todo.class);
        return "redirect:/";
    }



    @GetMapping
    String page() {
        return "home";
    }

    @ModelAttribute("todos")

    List<Todo> getTodoList() {
        return restTemplate.getForObject(todosurl, List.class);
    }

    @PostMapping("/{id}/done")
  String setDone(@PathVariable String id) {
        restTemplate.put(todosurl + "/" + id + "/done", Todo.class);
        return "redirect:/";
    }

    @PostMapping("/{id}/undone")
    String setundone(@PathVariable String id) {
        restTemplate.put(todosurl + "/" + id + "/undone", Todo.class);
        return "redirect:/";

    }

    @DeleteMapping("/{id}/delete")
    String delete(@PathVariable String id)
    {
        restTemplate.put(todosurl + "/" + id + "/delete", Todo.class);
        return "redirect:/";
    }
}
