package se.Lexicon.model;
import se.Lexicon.Sequencers.PersonIdSequencer;
import se.Lexicon.Sequencers.TodoItemTaskIdSequencer;

import java.util.Objects;

public class TodoItemTask {
    private int id ;
    private boolean assigned;
    private TodoItem todoItem;
    private Person assignee;

    public TodoItemTask(TodoItem todoItem, Person assignee){
        this.id = TodoItemTaskIdSequencer.nextId();

        setTodoItem(todoItem);
        setAssignee(assignee);

    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public void setTodoItem(TodoItem todoItem) {
        this.todoItem = todoItem;
    }

    public void setAssignee(Person assignee) {
        assigned= assignee==null?false:true;
        if (assigned)
            this.assignee = assignee;
    }

    public int getId() {
        return id;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public TodoItem getTodoItem() {
        return todoItem;
    }

    public Person getAssignee() {
        return assignee;
    }

    @Override
    public String toString() {
        return "TodoItemTask{" +
                "id=" + id +
                ", assigned=" + (assigned ? "Yes":"No") +
                ", todoItem=" + todoItem +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoItemTask)) return false;
        TodoItemTask that = (TodoItemTask) o;
        return getId() == that.getId() && isAssigned() == that.isAssigned() && getTodoItem().equals(that.getTodoItem());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), isAssigned(), getTodoItem());
    }
}
