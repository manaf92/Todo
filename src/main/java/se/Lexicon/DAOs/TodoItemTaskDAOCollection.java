package se.Lexicon.DAOs;

import se.Lexicon.model.Person;
import se.Lexicon.model.TodoItemTask;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class TodoItemTaskDAOCollection implements TodoItemTaskDAO{

    Collection<TodoItemTask> todoItemTasks= new ArrayList<>();

    @Override
    public Object persist(Object o) {
        return todoItemTasks.add((TodoItemTask) o) ? o:null;
    }

    @Override
    public Object findById(Object id) {
        return todoItemTasks.stream()
                .filter(t->t.getId()==(int)id).findFirst().get();
    }

    @Override
    public Collection findAll() {
        return new ArrayList(todoItemTasks);
    }

    @Override
    public Collection findByAssignedStatus(Object status) {
        return todoItemTasks.stream()
                .filter(t->t.isAssigned()==(Boolean) status)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Collection findByPersonId(Object personId) {
        return todoItemTasks.stream()
                .filter(t->t.getId()==(int) personId)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void remove(Object id) {
        todoItemTasks.removeIf(t->t.getId()==(int)id);
    }


    // Non-Generic Way
    /*

    @Override
    public TodoItemTask persist(TodoItemTask todoItemTask) {
        return todoItemTasks.add(todoItemTask) ? todoItemTask:null;
    }

    @Override
    public TodoItemTask findById(int id) {
        return todoItemTasks.stream()
                .filter(t->t.getId()==id)
                .findFirst().get();
    }

    @Override
    public Collection<TodoItemTask> findAll() {
        return new ArrayList<>(todoItemTasks);
    }

    @Override
    public Collection<TodoItemTask> findByAssignedStatus(boolean status) {
        return todoItemTasks.stream()
                .filter(TodoItemTask::isAssigned)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Collection<TodoItemTask> findByPersonId(int personId) {
        return todoItemTasks.stream()
                .filter(t->t.getAssignee().getId()==personId).
                collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void remove(int id) {
        todoItemTasks.removeIf(t->t.getId()==id);
    }

    */
}
