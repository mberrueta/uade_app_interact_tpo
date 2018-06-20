package edu.uade.appl_interact.View;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JButton;

public class GiftListResultItem extends JPanel implements ActionListener {

	private int listId;
	
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
		add(editButton);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
