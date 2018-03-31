package edu.uade.appl_interact;

import java.sql.SQLException;

import org.apache.log4j.Logger;

public class App
{
    static Logger log = Logger.getLogger(App.class.getName());

    public static void main( String[] args ) throws ClassNotFoundException, SQLException
    {
        System.out.println( "Hello World!" );
        log.debug("Hello this is a debug message");
        log.info("Hello this is an info message");
    }
}
