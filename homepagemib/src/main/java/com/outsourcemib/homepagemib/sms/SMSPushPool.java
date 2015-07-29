package com.outsourcemib.homepagemib.sms;

import java.util.logging.Logger;

import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;
import com.google.appengine.api.taskqueue.TaskOptions.Method;

public class SMSPushPool {
	
	private static final Logger log = Logger.getLogger(SMSPushPool.class.getName());

	public void send(String body, String to, String from) {
		Queue queue = QueueFactory.getDefaultQueue();
		queue.add(TaskOptions.Builder.withUrl("/smsServlet")
				.param("body", body).param("to", to).method(Method.GET));
		
		log.info("sms successfully enqueue through google cloud");
	}
}
