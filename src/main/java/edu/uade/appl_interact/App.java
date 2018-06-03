package edu.uade.appl_interact;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import edu.uade.appl_interact.model.entities.GiftList;
import edu.uade.appl_interact.model.factories.EntityManager;

public class App
{
    static Logger log = Logger.getLogger(App.class.getName());

    public static void main( String[] args ) throws Exception {
        System.out.println( "Hello World!" );
        log.debug("Hello this is a debug message");
        log.info("Hello this is an info message");
        testCreate();
    }

    public static void testCreate() throws Exception {
//        try {
          GiftList giftList = new GiftList();
          giftList.setListName("qwerty");
          EntityManager.getInstance().create(giftList);
//        } catch (Exception e) {
//          e.printStackTrace();
//        }
      }  
    
}
