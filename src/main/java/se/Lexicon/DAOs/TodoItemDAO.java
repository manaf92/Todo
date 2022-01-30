package se.Lexicon.DAOs;

import se.Lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.Collection;

public interface TodoItemDAO<T,P> extends DAO {

    T findById(P p);
    Collection<T> findAllByDoneStatus ( P p);
    Collection<T> findByTitleContains (P p);
    Collection<T> findByPersonId ( P p);
    Collection<T> findByDeadlineBefore (P p);
    Collection<T> findByDeadlineAfter (P p);

    // Non-Generic Way
    /*
        TodoItem persist (TodoItem todoItem);
        TodoItem findById ( int id);
        Collection<TodoItem> findAll ();
        Collection<TodoItem> findAllByDoneStatus ( boolean done);
        Collection<TodoItem> findByTitleContains (String title);
        Collection<TodoItem> findByPersonId ( int id);
        Collection<TodoItem> findByDeadlineBefore (LocalDate date);
        Collection<TodoItem> findByDeadlineAfter (LocalDate date);
        void remove ( int id);
     */

}
