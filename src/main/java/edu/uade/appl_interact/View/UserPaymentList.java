package edu.uade.appl_interact.View;

import javax.swing.*;

public class UserPaymentList extends JPanel {

    public UserPaymentList() {

    }

    public void addItem(String amount, String date, String subscriptionId) {
        JPanel itemPanel  = new JPanel();
        JLabel idLbl = new JLabel("Subscription id: " + subscriptionId);
        JLabel amountLbl = new JLabel("Ammount: " + amount);
        JLabel dateLlbl = new JLabel("Date: " + date);
        itemPanel.add(idLbl);
        itemPanel.add(amountLbl);
        itemPanel.add(dateLlbl);
        this.add(itemPanel);
    }

}
