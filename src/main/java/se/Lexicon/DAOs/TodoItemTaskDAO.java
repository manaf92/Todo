package se.Lexicon.DAOs;

import se.Lexicon.model.TodoItemTask;

import java.util.Collection;

public interface TodoItemTaskDAO<T,P> extends DAO {

    T findById(P p);
    Collection<T> findByAssignedStatus(P p);
    Collection<T> findByPersonId(P p);

    // Non-Generic Way
    /*

    TodoItemTask persist(TodoItemTask todoItemTask);
    TodoItemTask findById(int id);
    Collection<TodoItemTask> findAll();
    Collection<TodoItemTask> findByAssignedStatus(boolean status);
    Collection<TodoItemTask> findByPersonId(int personId);
    void remove(int id);

    */
}
