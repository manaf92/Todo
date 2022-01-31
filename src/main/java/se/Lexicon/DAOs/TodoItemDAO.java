package se.Lexicon.DAOs;

import se.Lexicon.model.TodoItem;

import java.time.LocalDate;
import java.util.Collection;

public interface TodoItemDAO extends GenericDao<TodoItem,Integer> {

    Collection<TodoItem> findAllByDoneStatus ( Boolean status);
    Collection<TodoItem> findByTitleContains (String title);
    Collection<TodoItem> findByPersonId ( Integer personId);
    Collection<TodoItem> findByDeadlineBefore (LocalDate date);
    Collection<TodoItem> findByDeadlineAfter (LocalDate date);

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
