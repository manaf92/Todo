package se.Lexicon.DAOs;

import se.Lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class TodoItemDAOCollection implements TodoItemDAO{
    Collection<TodoItem> todoItems = new ArrayList<>();

    @Override
    public Object persist(Object todoItem) {
        return todoItems.add((TodoItem) todoItem)? todoItem:null;
    }

    @Override
    public Object findById(Object id) {
        return todoItems.stream()
                .filter(t->t.getId()==(int) id)
                .findFirst().get();
    }

    @Override
    public Collection findAll() {
        return new ArrayList<>(todoItems);
    }

    @Override
    public Collection findAllByDoneStatus(Object done) {
        return todoItems.stream()
                .filter(t->t.isDone()==(Boolean)done)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Collection findByTitleContains(Object title) {
        return todoItems.stream()
                .filter(t->t.getTitle().equals((String)title))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Collection findByPersonId(Object personId) {
        return todoItems.stream()
                .filter(t->t.getCreator().getId()==(int)personId)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Collection findByDeadlineBefore(Object date) {
        return todoItems.stream()
                .filter(t->t.getDeadLine().isAfter((LocalDate)date))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Collection findByDeadlineAfter(Object date) {
        return todoItems.stream()
                .filter(t->t.getDeadLine().isBefore((LocalDate)date))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void remove(Object id) {
        todoItems.removeIf(t->t.getId()==(int)id);
    }


    // Non-Generic Way
    /*

    @Override
    public TodoItem persist(TodoItem todoItem) {
        return todoItems.add(todoItem)? todoItem:null;
    }

    @Override
    public TodoItem findById(int id) {
        return todoItems.stream()
                .findFirst().get();
    }

    @Override
    public Collection<TodoItem> findAll() {
        return new ArrayList<>(todoItems);
    }

    @Override
    public Collection<TodoItem> findAllByDoneStatus(boolean done) {
        return todoItems.stream()
                .filter(TodoItem::isDone)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Collection<TodoItem> findByTitleContains(String title) {
        return todoItems.stream()
                .filter(t->t.getTitle().equals(title))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Collection<TodoItem> findByPersonId(int personId) {
        return todoItems.stream()
                .filter(t->t.getCreator().getId()==personId)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Collection<TodoItem> findByDeadlineBefore(LocalDate date) {
        return todoItems.stream()
                .filter(t->t.getDeadLine().isAfter(date))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public Collection<TodoItem> findByDeadlineAfter(LocalDate date) {
        return todoItems.stream()
                .filter(t->t.getDeadLine().isBefore(date))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public void remove(int id) {
        todoItems.removeIf(t->t.getId()==id);
    }

    */
}
