package com.genio.engenio;

import java.util.ArrayList;

import com.genio.engenio.task.Task;
import com.genio.engenio.taskhandler.TaskHandler;
import com.genio.engenio.taskhandler.TaskHandlerImpl;
import com.genio.engenio.taskmanager.DefaultExceptionHandler;
import com.genio.engenio.taskmanager.TaskManager;
import com.genio.engenio.taskmanager.TaskManagerImpl;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		
		/*Defining the task manager and task handler*/
		TaskManager taskManager = new TaskManagerImpl();
		TaskHandler taskHandler = new TaskHandlerImpl();

		/* Defining observers*/	
		ArrayList<TaskHandler> observers = new ArrayList<>();
		ArrayList<Task> tasks = new ArrayList<>();
		observers.add(taskHandler);
		
		/*****Creating the tasks*****/
		Task task1 = new Task();
		Task task2 = new Task();
		Task task3 = new Task();
		Task task4 = new Task();
		Task task5 = new Task();
		Task task6 = new Task();
		Task task7 = new Task();
		
		/*Adding exception handler, (this can be improved for handle the exceptions also )*/
		task1.defaultExceptionHandler = new DefaultExceptionHandler(); 
		/**Assigning observers (the same for all the tasks)***/
		task1.observers = observers;
		
		task2.defaultExceptionHandler = new DefaultExceptionHandler(); 
		task2.observers = observers;

		task3.defaultExceptionHandler = new DefaultExceptionHandler(); 
		task3.observers = observers;

		task4.defaultExceptionHandler = new DefaultExceptionHandler(); 
		task4.observers = observers;
		
		task5.defaultExceptionHandler = new DefaultExceptionHandler(); 
		task5.observers = observers;
		
		task6.defaultExceptionHandler = new DefaultExceptionHandler(); 
		task6.observers = observers;
		
		task7.defaultExceptionHandler = new DefaultExceptionHandler(); 
		task7.observers = observers;
		
		/*Creating the task queue*/
		tasks.add(task1);
		tasks.add(task2);
		tasks.add(task3);
		tasks.add(task4);
		tasks.add(task5);
		tasks.add(task6);
		tasks.add(task7);
		
		/*Assigning and starting the tasks*/
		taskManager.taskQueue = tasks;
		taskManager.startAll();
	}
}
