package com.genio.engenio.taskmanager;

import java.util.ArrayList;

import com.genio.engenio.task.MessageTask;
import com.genio.engenio.task.Task;
import com.genio.engenio.taskhandler.TaskHandler;

/**
 * The Class TaskManagerImpl.
 */
public class TaskManagerImpl extends TaskManager{

	
	
	/* (non-Javadoc)
	 * @see com.genio.engenio.taskmanager.TaskManager#notifyObservers(com.genio.engenio.task.Task)
	 * 
	 * this method just notify to the observers, each task has the own observers assigned  
	 * 
	 */
	@Override
	public void notifyObservers(Task task) {
		
		ArrayList<TaskHandler> observers = task.observers;		
		MessageTask messageTask = new MessageTask();
		messageTask.body.put(MessageTask.SUCCESS, "notified");
		observers.forEach(observer->observer.update(messageTask));
		
	}

}
