package edu.ucalgary.oop;

public interface IToDoList {
    public void addTask(Task givenTask);
    public void deleteTask(String taskNumString);
    public void editTask(String taskNum, String description, Boolean taskState);
    public void completingTask(String taskNum);
    public void listTasks();
}