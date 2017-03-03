package com.genio.engenio.task;

import java.util.ArrayList;

import com.genio.engenio.taskhandler.TaskHandler;

/**
 * The Class Task. is used for define a task object into the task engine
 * This class can be extended for define a task 
 */
public class Task implements Runnable{
		
	
	/** The observers. 
	 * We are using a concurrentHashMap here in order to have different 
	 * task managers instances  trying to run the tasks into the queue
	 * */
	public ArrayList<TaskHandler> observers;
	
	/** The default exception handler. 
	 * Used for put a defaultExceptionHandler and to know 
	 * how to process if the task fail
	 * */
	public TaskHandler defaultExceptionHandler;
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.println("Executing task ");		
	}
	
	

}
