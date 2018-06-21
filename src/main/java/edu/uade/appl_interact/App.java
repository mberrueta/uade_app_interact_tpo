package edu.uade.appl_interact;

import edu.uade.appl_interact.workers.EndingListWorker;
import edu.uade.appl_interact.workers.PaymentWorker;
import edu.uade.lib.threads.TaskExecutor;
import org.apache.log4j.Logger;

class App {
    static final Logger log = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        System.out.println("starting app!");
        log.debug("Hello this is a debug message");
        log.info("Hello this is an info message");
        new TaskExecutor(PaymentWorker.getInstance(), 5).startExecution();
        new TaskExecutor(EndingListWorker.getInstance(), 10).startExecution();

        System.out.println("workers running!");

    }
}
