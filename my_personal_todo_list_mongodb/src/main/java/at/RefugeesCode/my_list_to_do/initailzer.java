package at.RefugeesCode.my_list_to_do;

import at.RefugeesCode.my_list_to_do.model.Todo;
import at.RefugeesCode.my_list_to_do.presistance.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration

public class initailzer {



    @Bean
    ApplicationRunner todorunner(Repository repository){

        return args -> {
            repository.deleteAll();
            List<Todo> todos = createListOfTodoes();
            repository.saveAll(todos);
        };



    }

    private List<Todo> createListOfTodoes() {
        return Stream .of(new Todo("coding",false),
                new Todo("swimming",true),
                new Todo("reading",false)
        ).collect(Collectors.toList());
    }


}
