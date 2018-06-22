package edu.uade.appl_interact;

import edu.uade.appl_interact.workers.EndingListWorker;
import edu.uade.appl_interact.workers.PaymentWorker;
import edu.uade.lib.threads.TaskExecutor;
import org.apache.log4j.Logger;

class App {
    static final Logger log = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {
        System.out.println("starting app!");
        log.info("starting app!");
        new TaskExecutor(PaymentWorker.getInstance(), 5).startExecution();
        new TaskExecutor(EndingListWorker.getInstance(), 10).startExecution();
        Main main = new Main();
        main.run();
        System.out.println("workers running!");
    }
}
