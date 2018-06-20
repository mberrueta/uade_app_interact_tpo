package edu.uade.appl_interact.View;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

public class UserListsView extends JPanel {

	public UserListsView() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}


	public void setItems() {
		for(int i = 1 ; i< 10; i++) {
			GiftListResultItem item = new GiftListResultItem(1, "test", "test", "test");
			this.add(item);
		}
	}

	public void addItem(int id, String listName,  String currentAmount) {
		this.add(new GiftListResultItem(1, listName, "due date", currentAmount));
	}
	
}
