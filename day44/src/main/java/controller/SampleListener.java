package controller;

import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import model.BoardDAO;
import model.BoardVO;
import model.Crawling;

/**
 * Application Lifecycle Listener implementation class SampleListener
 *
 */
@WebListener
public class SampleListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public SampleListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
    	/*
    	ArrayList<BoardVO> datas=Crawling.sample();
    	BoardDAO bDAO=new BoardDAO();
    	for(BoardVO v:datas) {
    		v.setWriter("admin");
    		bDAO.insert(v);
    	}
    	*/
    	System.out.println(" 로그: 샘플데이터 리스너 동작함");
    }
	
}
