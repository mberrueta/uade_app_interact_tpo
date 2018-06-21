package edu.uade.appl_interact.View;

import edu.uade.controller.MainController;

import javax.swing.*;
import java.awt.*;

public class UserListsView extends JPanel {
	private MainController controller;

	public UserListsView(MainController controller) {
		this.controller = controller;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	}

	public void setController(MainController controller) {
		this.controller = controller;
	}

	public void addItem(int id, String listName, String currentAmount) {
		GiftListResultItem item  = new GiftListResultItem(id, listName, "due date", currentAmount);
		item.setController(controller);
		this.add(item);
	}

}
