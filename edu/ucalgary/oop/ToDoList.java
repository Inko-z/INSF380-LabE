package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class ToDoList implements IToDoList {
    private List<Task> tasks;
    private Stack<List<Task>> history;

    public ToDoList() {
        this.tasks = new ArrayList<>();
        this.history = new Stack<>();
    }

    private void saveState() {
        List<Task> tasksCopy = tasks.stream()
                                     .map(Task::copy)
                                     .collect(Collectors.toList());
        history.push(tasksCopy);
    }

    @Override
    public void addTask(Task task) {
        saveState();
        tasks.add(task);
    }

    @Override
    public void completeTask(String taskId) {
        saveState();
        tasks.stream()
             .filter(task -> task.getId().equals(taskId))
             .findFirst()
             .ifPresent(task -> task.setCompleted(true));
    }

    @Override
    public void deleteTask(String taskId) {
        saveState();
        tasks.removeIf(task -> task.getId().equals(taskId));
    }

    @Override
    public void editTask(String taskId, String newTitle, Boolean taskState) {
        saveState();
        tasks.stream()
         .filter(task -> task.getId().equals(taskId))
         .findFirst()
         .ifPresent(task -> {
             task.setTitle(newTitle);
             task.setCompleted(taskState);
         });
    }


    @Override
    public void undo() {
        if (!history.isEmpty()) {
            tasks = history.pop();
        }
    }

    @Override
    public List<Task> listTasks() {
        return tasks;
    }
}
