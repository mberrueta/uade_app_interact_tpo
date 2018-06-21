package edu.uade.appl_interact.View;

import edu.uade.controller.MainController;

import javax.swing.JPanel;
import javax.swing.BoxLayout;

public class UserListsView extends JPanel {
	private MainController controller;

	public UserListsView(MainController controller) {
		this.controller = controller;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}


	public void setItems() {
		for(int i = 1 ; i< 10; i++) {
			GiftListResultItem item = new GiftListResultItem(1, "test", "test", "test");
			this.add(item);
		}
	}

	public void setController(MainController controller) {
		this.controller = controller;
	}

	public void addItem(int id, String listName, String currentAmount) {
		GiftListResultItem item  = new GiftListResultItem(1, listName, "due date", currentAmount);
		item.setController(controller);
		this.add(item);
	}


}
