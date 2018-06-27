package edu.uade.appl_interact.workers;

import edu.uade.appl_interact.services.PaymentService;
import edu.uade.lib.Helper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PaymentWorkerTest {
    private PaymentService paymentService;
    private PaymentWorker paymentWorker;
    private static final String filename = "resources/payments.csv";

    @Before
    public void setUp() {
        paymentService = mock(PaymentService.class);
        paymentWorker = PaymentWorker.getInstance();
        paymentWorker.setPaymentService(paymentService);
    }

    @Test
    public void run() throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("1,12.22,2012-12-31\n");
        sb.append("2,23.45,2012-01-01\n");
        sb.append("3,432.21,2014-02-17\n");
        Helper.saveToFile(sb, filename);

        String result = paymentWorker.run();
        assertEquals(sb.toString(), result);

        verify(paymentService).processPayment(1, 12.22f, Helper.fromString("2012-12-31"));
        verify(paymentService).processPayment(2, 23.45f, Helper.fromString("2012-01-01"));
        verify(paymentService).processPayment(3, 432.21f, Helper.fromString("2014-02-17"));

        Boolean exists = Files.exists(Paths.get(filename));
        Assert.assertFalse(exists);
    }

    @Test
    public void check_invalid_payments() throws Exception {
        StringBuilder errors = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        errors.append("1,12.22,2012-13-x\n"); // invalid date
        errors.append("2,aa,2012-01-01\n"); // invalid amount
        errors.append("aa,432.21,2014-02-17\n"); // invalid id

        sb.append(errors);
        sb.append("3,432.21,2014-02-17\n"); // valid
        Helper.saveToFile(sb, filename);


        String result = paymentWorker.run();

        // ok
        assertEquals("3,432.21,2014-02-17\n", result);
        verify(paymentService).processPayment(3, 432.21f, Helper.fromString("2014-02-17"));

        // failed
        List<String> error_result = Helper.readFile(String.format("resources/error_payments_%s.csv", Helper.fromDate(new Date())));
        List<String> e = Arrays.asList(errors.toString().split("\\n"));
        assertEquals(e, error_result);
    }
}