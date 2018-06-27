package edu.uade.appl_interact.workers;

import edu.uade.appl_interact.data_access.dao.impl.GiftListDao;
import edu.uade.appl_interact.model.entities.GiftList;
import edu.uade.appl_interact.services.EmailService;
import edu.uade.lib.Helper;
import edu.uade.lib.threads.Task;
import org.apache.log4j.Logger;

import java.util.Iterator;
import java.util.List;

public class EndingListWorker implements Task {
    private EmailService emailService;

    private final StringBuilder errors = new StringBuilder();
    private static final Logger log = Logger.getLogger("EndingListWorker");
    private static EndingListWorker instance;


    private GiftListDao listDao = GiftListDao.getInstance();

    private EndingListWorker() {
    }

    public static EndingListWorker getInstance() {
        if (instance == null) {
            instance = new EndingListWorker();
            instance.emailService = EmailService.getInstance();
        }
        return instance;
    }

    public String run() {
        StringBuilder sb = new StringBuilder();

        try {
            List<GiftList> result = GiftListDao.getInstance().findManyBy("due_date", Helper.fromDate(Helper.tomorrow()));

            for (Iterator<GiftList> i = result.iterator(); i.hasNext(); ) {
                GiftList list = i.next();
                emailService.dueDateEmail(list);
            }
        } catch (Exception e) {
            e.printStackTrace();
            sb.append(e);
        }

        return sb.toString();
    }

    // Allow mock
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }
}
