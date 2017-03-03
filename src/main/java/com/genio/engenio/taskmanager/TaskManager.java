package com.genio.engenio.taskmanager;

import java.util.ArrayList;

import org.json.JSONObject;

import com.genio.engenio.task.MessageTask;
import com.genio.engenio.task.Task;
import com.genio.engenio.taskexception.TaskException;

/**
 * The Class TaskManager. manage all the task defined into the taskQueue
 */
public abstract class TaskManager {

	/** The task queue. */
	public ArrayList<Task> taskQueue;

	/**
	 * Notify observers.
	 * The developer needs override the method
	 * and add a custom MessageTask dto 
	 * @param task the task
	 */
	public abstract void notifyObservers(Task task);

	/**
	 * Start all.
	 */
	public void startAll() {
		taskQueue.forEach(task -> processTask(task));
	}

	/**
	 * Run task. and throws a TaskException is this fail
	 *
	 * @param task the task
	 * @throws TaskException the task exception
	 */
	private void runTask(Task task) throws TaskException {
		task.run();
	}

	/**
	 * Process task. if this fail (task Exception) the  
	 * defaultExceptionHandler is notified, 
	 * either way all the observers defined on the task object will be notified
	 * the developer needs override the notifyObservers method to send 
	 * a custom MessageTask 
	 *
	 * @param task the task
	 */
	private void processTask(Task task) {
		try {
			runTask(task);
			notifyObservers(task);
		} catch (TaskException e) {
			e.printStackTrace();
			MessageTask messageTask = new MessageTask();
			messageTask.body = new JSONObject().put(MessageTask.ERROR, e.getMessage());
			task.defaultExceptionHandler.update(messageTask);
		}
	}

}
