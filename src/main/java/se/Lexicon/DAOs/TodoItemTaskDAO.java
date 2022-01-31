package se.Lexicon.DAOs;

import se.Lexicon.model.TodoItem;
import se.Lexicon.model.TodoItemTask;

import java.util.Collection;

public interface TodoItemTaskDAO extends GenericDao<TodoItemTask,Integer> {
    Collection<TodoItemTask> findByAssignedStatus(Boolean assignedStatus);
    Collection<TodoItemTask> findByPersonId(Integer personId);

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
