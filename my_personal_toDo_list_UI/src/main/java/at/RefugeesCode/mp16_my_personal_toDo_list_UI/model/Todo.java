package at.RefugeesCode.mp16_my_personal_toDo_list_UI.model;


import org.springframework.stereotype.Service;

@Service
public class Todo {

    private String id;
    private String task;
    private boolean done;

    public void setId(String id) {
        this.id = id;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setDone(boolean done) {
        this.done = done;
    }


    public String getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public boolean getDone() {
        return done;
    }

}

