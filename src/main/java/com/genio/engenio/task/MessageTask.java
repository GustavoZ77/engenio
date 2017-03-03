package com.genio.engenio.task;

import org.json.JSONObject;

/**
 * The Class MessageTask.
 */
public class MessageTask {
	
	public static final String ERROR = "error";
	public static final String SUCCESS = "success";
	public static final String TASK_ID = "taskId";
	
	/** The body. */
	public JSONObject body;
	
	public MessageTask(){
		body = new JSONObject().put(MessageTask.TASK_ID,"");
	}
	
	@Override
	public String toString(){
		return body.toString();
	}

}
