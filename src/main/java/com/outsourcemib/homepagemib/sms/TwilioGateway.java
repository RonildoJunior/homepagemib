package com.outsourcemib.homepagemib.sms;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.outsourcemib.homepagemib.HomePageConfiguration;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;

public class TwilioGateway {
	
	private static final Logger log = Logger.getLogger(TwilioGateway.class.getName());
	

	protected void send(String body, String to) throws TwilioRestException{
		log.info(" TwilioGateway sending message to " + to);
		TwilioRestClient client = new TwilioRestClient(HomePageConfiguration.ACCOUNT_SID, HomePageConfiguration.AUTH_TOKEN);
		 
	    List<NameValuePair> params = new ArrayList<NameValuePair>();
	    params.add(new BasicNameValuePair("Body", body));
	    params.add(new BasicNameValuePair("To", to));
	    params.add(new BasicNameValuePair("From", HomePageConfiguration.SMS_FROM));
	 
	    MessageFactory messageFactory = client.getAccount().getMessageFactory();
		Message message = messageFactory.create(params);
		log.info(message.getSid());   
	}
}