package test;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.tomcat.util.net.ApplicationBufferHandler;

/**
 * Application Lifecycle Listener implementation class TestListner
 *
 */
@WebListener
public class TestListner implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public TestListner() { // 필수
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { // 소멸
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { // 생성
    	
    }
	
}
