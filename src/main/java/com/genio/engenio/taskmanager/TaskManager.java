package com.genio.engenio.taskmanager;

import java.util.concurrent.ConcurrentHashMap;

import org.json.JSONObject;

import com.genio.engenio.task.MessageTask;
import com.genio.engenio.task.Task;
import com.genio.engenio.taskexception.TaskException;

// TODO: Auto-generated Javadoc
/**
 * The Class TaskManager. manage all the task defined into the taskQueue
 */
public abstract class TaskManager {

	/** The task queue. */
	private ConcurrentHashMap<Long, Task> taskQueue;

	/**
	 * Notify observers.
	 *
	 * @param task the task
	 */
	public abstract void notifyObservers(Task task);

	/**
	 * Start all.
	 */
	public void startAll() {
		taskQueue.values().forEach(task -> processTask(task));
	}

	/**
	 * Start by id.
	 *
	 * @param id the id
	 */
	public void startById(Long id) {
		Task task = this.taskQueue.get(id);
		processTask(task);
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
			MessageTask messageTask = new MessageTask(task.idTask);
			messageTask.body = new JSONObject().put(MessageTask.ERROR, e.getMessage());
			task.defaultExceptionHandler.update(messageTask);
		}
	}

}
