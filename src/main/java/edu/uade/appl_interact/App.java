package edu.uade.appl_interact;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import edu.uade.appl_interact.model.dao.User;
import edu.uade.appl_interact.model.factories.EntityManager;

public class App
{
    static Logger log = Logger.getLogger(App.class.getName());

    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
        System.out.println( "Hello World!" );
        log.debug("Hello this is a debug message");
        log.info("Hello this is an info message");


        EntityManager em = EntityManager.getInstance();
        em.getTransaction().begin();

        for (int i = 0; i < 4; i++) {
            User u = new User();
            u.setName(Integer.toString(i));
            em.persist(u);
            System.out.println(u);
        }
        em.getTransaction().commit();
        em.close();
    }
}
