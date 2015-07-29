package com.outsourcemib.homepagemib.sms;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twilio.sdk.TwilioRestException;


public class SMSServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(TwilioGateway.class.getName());
	
	public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
		
		String body = request.getParameter("body");
		String to = request.getParameter("to");
		 
		TwilioGateway tg = new TwilioGateway();
		try{
			tg.send(body,to);
			log.info("sms successfully enqueue through twilio");
			log.info("sms enqueue: to: "+ to + "\n body" + body );
		}catch(TwilioRestException ex){
			log.log( Level.SEVERE, "SMSGateway Failure, message: ", ex.getMessage() );
			log.log( Level.SEVERE, "SMSGateway Failure, cause: ", ex.getCause() );
			throw new ServletException(ex);
		}
	}
}