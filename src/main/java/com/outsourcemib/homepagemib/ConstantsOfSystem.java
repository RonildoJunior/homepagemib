package com.outsourcemib.homepagemib;

import java.util.LinkedList;
import java.util.List;


/**
 * @author ronildo braga
 * @version 0.1
 * @since release 0.1
 */
public class ConstantsOfSystem {
    
    
    public static final String USER_SESSION_KEY = "user_session_key";
    public static final String USER_ACCOUNT_SESSION_KEY = "user_account_session_key";
    
    public static final String LOGIN_PAGE = "/login.html";
    public static List<String> pages = new LinkedList<String>();
    static{
    	pages.add("/login.html");
    	pages.add("/signup");
    	pages.add("/signin");
    	//pages.add("/smsServlet");
    }
}
