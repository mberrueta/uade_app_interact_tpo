package edu.uade.appl_interact.model.services;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.*;

public class PaymentManagerTest {

    @Test
    public void check_payments() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("1,12.22,pp gift\n");
        sb.append("2,23.45,pp gift\n");
        sb.append("3,432.21,pp gift\n");
        saveToFile(sb);

    }

    private void saveToFile(StringBuilder sb) throws IOException {
        File file = new File("resources/payments.cvs");
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(sb.toString());
        } finally {
            if (writer != null) writer.close();
        }
    }
}