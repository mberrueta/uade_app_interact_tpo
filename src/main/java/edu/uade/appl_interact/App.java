package edu.uade.appl_interact;

import org.apache.log4j.Logger;

class App {
    static final Logger log = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        System.out.println("Hello World!");
        log.debug("Hello this is a debug message");
        log.info("Hello this is an info message");
    }
}
