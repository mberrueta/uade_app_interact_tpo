package edu.uade.appl_interact.View;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Label;
import javax.swing.JList;
import java.awt.Button;

public class ListView extends JPanel {

	/**
	 * Create the panel.
	 * List view should be abstract, then show views for owners - non owners.
	 * 
	 */
	public ListView() {
		setLayout(null);
		
		JLabel listName = new JLabel("List name placeHolder");
		listName.setBounds(284, 12, 172, 38);
		add(listName);
		
		Label giftTarget = new Label("Gift is for: {placeholder}");
		giftTarget.setBounds(10, 58, 172, 21);
		add(giftTarget);
		
		Label owner = new Label("Owner: {placeHolder}");
		owner.setBounds(10, 85, 172, 21);
		add(owner);
		
		Label dueDate = new Label("dueDate:{placeHolder}");
		dueDate.setBounds(10, 112, 172, 21);
		add(dueDate);
		
		Label amount = new Label("Expexted amount :{placeHolder}");
		amount.setBounds(10, 139, 216, 21);
		add(amount);
		
		Button addParticipant = new Button("Add new participant");
		addParticipant.setBounds(22, 405, 160, 23);
		add(addParticipant);

	}
}
