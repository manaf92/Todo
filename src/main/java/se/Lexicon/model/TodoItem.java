package se.Lexicon.model;

import java.time.*;
import java.util.Objects;

public class TodoItem {
    private static int total;
    private int id;
    private String title;
    private String taskDescription;
    private LocalDate  deadLine;
    private boolean done;
    private Person creator;

    public TodoItem(String title, String taskDescription, LocalDate deadLine, boolean done, Person creator) {
        // increment the id and set it automatically
        total++;
        this.id = total;

        setTitle(title);
        setTaskDescription(taskDescription);
        setDeadLine(deadLine);
        setDone(done);
        setCreator(creator);
    }

    public TodoItem() {
            this(null,null,null,false,null);
    }

    public void setTitle(String title) {
        if (title==null)
            throw new IllegalArgumentException("Parameter: String title was null");
        if (title.trim().isEmpty())
            throw new IllegalArgumentException("Parameter: String title was empty");
        this.title = title.trim();
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setDeadLine(LocalDate deadLine) {
        if (deadLine==null)
            throw new IllegalArgumentException("Parameter: String deadLine was null");
        this.deadLine = deadLine;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public boolean isDone() {
        return done;
    }

    public Person getCreator() {
        return creator;
    }

    public boolean isOverdue() {
        return deadLine.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                ", deadLine=" + deadLine +
                ", done=" +  (done?"Yes" : "No")+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoItem)) return false;
        TodoItem todoItem = (TodoItem) o;
        return getId() == todoItem.getId() && isDone() == todoItem.isDone()
                && getTitle().equals(todoItem.getTitle())
                && getTaskDescription().equals(todoItem.getTaskDescription())
                && getDeadLine().equals(todoItem.getDeadLine());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getTaskDescription(), getDeadLine(), isDone());
    }
}
