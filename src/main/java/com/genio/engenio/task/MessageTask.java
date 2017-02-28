package com.genio.engenio.task;

import org.json.JSONObject;

// TODO: Auto-generated Javadoc
/**
 * The Class MessageTask.
 */
public class MessageTask {
	
	public static final String ERROR = "error";
	public static final String SUCCESS = "success";
	public static final String TASK_ID = "taskId";
	
	/** The body. */
	public JSONObject body;
	
	public MessageTask(long idTask){
		body = new JSONObject().put(MessageTask.TASK_ID, idTask);
	}

}
