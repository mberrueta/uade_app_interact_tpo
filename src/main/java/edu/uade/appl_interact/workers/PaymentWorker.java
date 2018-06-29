package edu.uade.appl_interact.workers;

import edu.uade.appl_interact.services.PaymentService;
import edu.uade.lib.Helper;
import edu.uade.lib.threads.Task;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class PaymentWorker implements Task {
    private PaymentService paymentService = PaymentService.getInstance();
    private final StringBuilder errors = new StringBuilder();
    private static final Logger log = Logger.getLogger("PaymentWorker");
    private static PaymentWorker instance;

    private PaymentWorker() {
    }

    public static PaymentWorker getInstance() {
        if (instance == null) {
            instance = new PaymentWorker();
        }
        return instance;
    }

    // TODO: implent cron each 1 min
    // subscription_id, amount, date
    // 123,12.22,2012-12-31
    public String run() {
        StringBuilder sb = new StringBuilder();
        Boolean ok;
        List<String> b = Helper.readFile("resources/payments.csv");
        for (String readLine : b) {
            ok = processLine(readLine);
            if (ok) {
                sb.append(readLine);
                sb.append("\n");
            }
        }

        if (errors.length() > 0) {
            try {
                Helper.saveToFile(errors, String.format("resources/error_payments_%s.csv", Helper.fromDate(new Date())));
            } catch (IOException e) {
                e.printStackTrace();
                log.error("fail to write error files", e);
            }
        }

        Helper.removeFile("resources/payments.csv");
        return sb.toString();
    }

    private Boolean processLine(String readLine) {
        String[] list = readLine.split(",");
        try {
            Integer id = Integer.parseInt(list[0]);
            Float amount = Float.parseFloat(list[1]);
            Date d = Helper.fromString(list[2]);
            paymentService.processPayment(id, amount, d);
            return true;
        } catch (Exception e) {
            log.error(readLine, e);
            errors.append(readLine);
            errors.append("\n");
            return false;
        }
    }

    // Allow mock
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
