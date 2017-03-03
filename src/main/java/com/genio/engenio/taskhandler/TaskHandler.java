package com.genio.engenio.taskhandler;

import com.genio.engenio.task.MessageTask;

/**
 * The Interface TaskHandler. 
 * Abstract class for implement different observers for the class
 * The instances of TaskHandler know how to process the task if it 
 * does not have any failure at the end of the execution
 */
public abstract class TaskHandler {
	
	/**
	 * Update.
	 * Developer needs override this method,
	 * This is synchronized for to lock the Observer update execution 
	 * in order to warranty guarantee just the observer is working over one task, 
	 * @param messageTask the message task
	 */
	public synchronized void update(MessageTask messageTask){
		 throw new UnsupportedOperationException("The update method needs to be override");
	}

}
