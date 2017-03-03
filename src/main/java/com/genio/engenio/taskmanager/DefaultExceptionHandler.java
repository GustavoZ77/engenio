package com.genio.engenio.taskmanager;


import com.genio.engenio.task.MessageTask;
import com.genio.engenio.taskhandler.TaskHandler;

public class DefaultExceptionHandler extends TaskHandler {
	
	
	@Override
	public synchronized void update(MessageTask messageTask){
		System.out.println("Updating the observers error" + messageTask);
	}
}
