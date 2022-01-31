package se.Lexicon.DAOs;

import se.Lexicon.model.TodoItem;
import se.Lexicon.model.TodoItemTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TodoItemTaskDAOCollection implements TodoItemTaskDAO {

    // Singleton

    private final Collection<TodoItemTask> todoItemTasks;
    public static TodoItemTaskDAOCollection INSTANCE;

    // empty constructor
    private TodoItemTaskDAOCollection() {
        this.todoItemTasks = new ArrayList<>();
    }

    // constructor with list of TodoItemTask
    private TodoItemTaskDAOCollection(Collection<TodoItemTask> todoItemTasks) {
        this.todoItemTasks = todoItemTasks;
    }

    public static TodoItemTaskDAOCollection getInstance(){
        if (INSTANCE==null) INSTANCE = new TodoItemTaskDAOCollection();
        return INSTANCE;
    }

    public static TodoItemTaskDAOCollection getTestInstance(List<TodoItemTask> todoItemTasks){
        return new TodoItemTaskDAOCollection(todoItemTasks);
    }
    // end Singleton





    @Override
    public TodoItemTask persist(TodoItemTask todoItemTask) {
        todoItemTasks.add(todoItemTask);
        return todoItemTask;
    }

    @Override
    public TodoItemTask findById(Integer id) {
        return todoItemTasks.stream()
                .filter(t->t.getId()==(int)id).findFirst().get();
    }

    @Override
    public List<TodoItemTask> findAll() {
        return new ArrayList(todoItemTasks);
    }

    @Override
    public List<TodoItemTask> findByAssignedStatus(Boolean status) {
        return todoItemTasks.stream()
                .filter(t->t.isAssigned()== status)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public List<TodoItemTask> findByPersonId(Integer personId) {
        return todoItemTasks.stream()
                .filter(t->t.getId()== personId)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void remove(Integer id) {
        todoItemTasks.removeIf(t->t.getId()==id);
    }


    // Non-Generic Way
}
