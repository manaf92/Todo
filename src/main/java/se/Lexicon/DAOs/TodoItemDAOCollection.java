package se.Lexicon.DAOs;

import se.Lexicon.model.Person;
import se.Lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class TodoItemDAOCollection implements TodoItemDAO{


    // Singleton

    private final Collection<TodoItem> todoItems;
    public static TodoItemDAOCollection INSTANCE;

    private TodoItemDAOCollection() {
        this.todoItems = new ArrayList<>();
    }


    private TodoItemDAOCollection(Collection<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }

    public static TodoItemDAOCollection getInstance(){
        if (INSTANCE==null) INSTANCE = new TodoItemDAOCollection();
        return INSTANCE;
    }

    public static TodoItemDAOCollection getTestInstance(List<TodoItem> todoItems){
        return new TodoItemDAOCollection(todoItems);
    }
    // end Singleton



    @Override
    public TodoItem persist(TodoItem todoItem) {
        return todoItems.add(todoItem)? todoItem : null;
    }

    @Override
    public TodoItem findById(Integer id) {
        return todoItems.stream()
                .filter(t->t.getId()== id)
                .findFirst().get();
    }

    @Override
    public Collection<TodoItem> findAll() {
        return new ArrayList<>(todoItems);
    }

    @Override
    public Collection<TodoItem> findAllByDoneStatus(Boolean done) {
        return todoItems.stream()
                .filter(t->t.isDone()==done)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {
        return todoItems.stream()
                .filter(t->t.getTitle().contains(title))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Collection<TodoItem> findByPersonId(Integer personId) {
        return todoItems.stream()
                .filter(t->t.getCreator().getId()==personId)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Collection<TodoItem> findByDeadlineBefore(LocalDate date) {
        return todoItems.stream()
                .filter(t-> !t.getDeadLine().isAfter(date))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Collection<TodoItem> findByDeadlineAfter(LocalDate date) {
        return todoItems.stream()
                .filter(t-> !t.getDeadLine().isBefore(date))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void remove(Integer id) {
        todoItems.removeIf(t->t.getId()==id);
    }


    // Non-Generic Way
}
