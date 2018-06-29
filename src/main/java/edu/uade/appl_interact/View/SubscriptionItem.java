package edu.uade.appl_interact.View;

import edu.uade.controller.MainController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubscriptionItem extends JPanel implements ActionListener {
    private int listId;
    private MainController controller;

    public SubscriptionItem(int listId, String listName) {
        SpringLayout layout  = new SpringLayout();
        setLayout(layout);

        this.listId = listId;
        setForeground(Color.LIGHT_GRAY);

        JButton deleteButton = new JButton("unsubscribe");
        layout.putConstraint(SpringLayout.EAST, deleteButton, -110, SpringLayout.EAST, this);
        deleteButton.setSize(new Dimension(80,40));
        deleteButton.addActionListener(this);
        add(deleteButton);



        JLabel listNamelbl = new JLabel(listName);
        layout.putConstraint(SpringLayout.NORTH, deleteButton, -5, SpringLayout.NORTH, listNamelbl);
        layout.putConstraint(SpringLayout.WEST, listNamelbl, 15, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, listNamelbl, 15, SpringLayout.NORTH, this);
        add(listNamelbl);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "unsubscribe" :
                this.controller.unsubscribe(listId);
                break;
            default:
                System.out.println("trying to perform: " + e.getActionCommand());
        }
    }

    public void setController(MainController controller) {
        this.controller = controller;
    }



}
