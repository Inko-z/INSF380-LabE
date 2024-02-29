package edu.ucalgary.oop;

import java.util.List;

public interface IToDoList {
    public void addTask(Task task);
    public void deleteTask(String taskId);
    public void editTask(String taskId, String newTitle, Boolean isComplete);
    public void completeTask(String taskId);
    public void undo();
    public List<Task> listTasks();
}
