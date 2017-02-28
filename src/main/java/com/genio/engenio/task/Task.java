package com.genio.engenio.task;

import java.util.concurrent.ConcurrentHashMap;

import com.genio.engenio.taskhandler.TaskHandler;

// TODO: Auto-generated Javadoc
/**
 * The Class Task. is used for define a task object into the task engine
 */
public class Task implements Runnable{
		
	/** The id task. */
	public Long idTask; 
	
	/** The observers. 
	 * We are using a concurrentHashMap here in order to have different 
	 * task managers instances  trying to run the tasks into the queue
	 * */
	public ConcurrentHashMap<Long,TaskHandler> observers;
	
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
		System.out.println("Executing task "+idTask );		
	}
	
	

}
