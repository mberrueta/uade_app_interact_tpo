package edu.uade.appl_interact.View;

import edu.uade.controller.MainController;

import javax.swing.*;

public class UserSubscriptionsView extends JPanel {
    private MainController controller;

    public UserSubscriptionsView(MainController controller) {
        setBackground(UIManager.getColor("Button.shadow"));
        this.controller = controller;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public void setController(MainController controller) {
        this.controller = controller;
    }

    public void addItem(int id, String listName) {
        SubscriptionItem item  = new SubscriptionItem(id, listName);
        item.setController(controller);
        this.add(item);
    }
}