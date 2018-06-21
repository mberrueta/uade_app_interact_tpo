package edu.uade.appl_interact.View;

import edu.uade.controller.MainController;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;

public class GiftListResultItem extends JPanel implements ActionListener {

	private int listId;
	private MainController controller;
	
	public GiftListResultItem(int listId, String listName, String dueDate, String currentAmmount) {
		
		this.listId = listId;
		setForeground(Color.LIGHT_GRAY);
		
		JLabel lblNewLabel_1 = new JLabel(listName);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel(dueDate);
		add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel(currentAmmount);
		add(lblNewLabel_2);
		
		JButton editButton = new JButton("Edit");
		editButton.addActionListener(this);
		add(editButton);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
        System.out.println("action");
		this.controller.redirectToListEdition(listId);
		
	}

	public void setController(MainController controller) {
		this.controller = controller;
	}
}
