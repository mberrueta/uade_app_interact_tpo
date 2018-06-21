package edu.uade.appl_interact.View;

import edu.uade.controller.MainController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GiftListResultItem extends JPanel implements ActionListener {

	private int listId;
	private MainController controller;
	
	public GiftListResultItem(int listId, String listName, String dueDate, String currentAmmount) {
        SpringLayout layout  = new SpringLayout();
	    setLayout(layout);

        this.listId = listId;
		setForeground(Color.LIGHT_GRAY);

        JButton deleteButton = new JButton("Delete");
        layout.putConstraint(SpringLayout.NORTH, deleteButton, 10, SpringLayout.NORTH, this);
        deleteButton.setSize(new Dimension(80,40));
        deleteButton.addActionListener(this);
        add(deleteButton);

        JButton editButton = new JButton("Edit");
        layout.putConstraint(SpringLayout.NORTH, editButton, 10, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.WEST, deleteButton, 45, SpringLayout.EAST, editButton);
        editButton.setSize(new Dimension(80,40));
        editButton.addActionListener(this);
        add(editButton);


        JLabel currentAmount = new JLabel("current ammount: " + currentAmmount);
        layout.putConstraint(SpringLayout.WEST, editButton, 45, SpringLayout.EAST, currentAmount);
        layout.putConstraint(SpringLayout.NORTH, currentAmount, 15, SpringLayout.NORTH, this);
        add(currentAmount);

        JLabel dueDatelbl = new JLabel("due date: " + dueDate);
        layout.putConstraint(SpringLayout.WEST, currentAmount, 45, SpringLayout.EAST, dueDatelbl);
        layout.putConstraint(SpringLayout.NORTH, dueDatelbl, 15, SpringLayout.NORTH, this);
        add(dueDatelbl);
		
		
        JLabel listNamelbl = new JLabel(listName);
        layout.putConstraint(SpringLayout.WEST, listNamelbl, 15, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.WEST, dueDatelbl, 45, SpringLayout.EAST, listNamelbl);
        layout.putConstraint(SpringLayout.NORTH, listNamelbl, 15, SpringLayout.NORTH, this);
        add(listNamelbl);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Delete" :
                this.controller.onListDelete(listId);
                break;
            case "Edit":
                this.controller.redirectToListEdition(listId);
                break;
            default:
                System.out.println("trying to perform: " + e.getActionCommand());
        }

		
	}

	public void setController(MainController controller) {
		this.controller = controller;
	}
}
