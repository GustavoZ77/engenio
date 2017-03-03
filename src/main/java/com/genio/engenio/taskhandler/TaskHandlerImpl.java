package com.genio.engenio.taskhandler;

import com.genio.engenio.task.MessageTask;

/**
 * The Class TaskHandlerImpl.
 */
public class TaskHandlerImpl extends TaskHandler{
	
	/* (non-Javadoc)
	 * @see com.genio.engenio.taskhandler.TaskHandler#update(com.genio.engenio.task.MessageTask)
	 * 
	 * The idea with this method is to notify to all observers into the tasks, each task
	 * has different observers and this can be shared (same instance ) with another tasks 
	 * we are implemented the synchronized in order to be able just for one thread at the time 
	 * 
	 */
	@Override
	public synchronized void update(MessageTask messageTask){
		System.out.println("Updating the observers" + messageTask);
		notify();
	}

}
