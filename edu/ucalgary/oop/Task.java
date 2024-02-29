package edu.ucalgary.oop;

import java.util.Objects;

public class Task {

    private String id;
    private String title;
    private boolean isCompleted;

    public Task(String id, String title, boolean isCompleted) {
        this.id = id;
        this.title = title;
        this.isCompleted = isCompleted;
    }

    // Getters

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    // Deep copy method
    public Task copy() {
        return new Task(id, title, isCompleted);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Task task = (Task) obj;
        return Objects.equals(id, task.id) &&
                Objects.equals(title, task.title) &&
                isCompleted == task.isCompleted;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, isCompleted);
    }
}
