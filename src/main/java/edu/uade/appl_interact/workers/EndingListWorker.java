package edu.uade.appl_interact.workers;

import edu.uade.appl_interact.model.entities.GiftList;
import edu.uade.lib.threads.Task;
import org.apache.log4j.Logger;

public class EndingListWorker implements Task {
    private GiftList list;
    private final StringBuilder errors = new StringBuilder();
    private static final Logger log = Logger.getLogger("EndingListWorker");
    private static EndingListWorker instance;

    private EndingListWorker() {
    }

    public static EndingListWorker getInstance() {
        if (instance == null) {
            instance = new EndingListWorker();
        }
        return instance;
    }
    public String run(){
        return "WIP";
    }
}
