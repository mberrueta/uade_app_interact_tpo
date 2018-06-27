package edu.uade.appl_interact.View;

import edu.uade.controller.MainController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserDashboard extends JPanel implements ActionListener {
	private JPanel mainPanel;
    private CardLayout cardLayout;
    private MainController controller;
    private JPanel defaultPanel;

    public void addToCardLayout(JPanel panel, String identifier) {
        mainPanel.add(panel, identifier);
    }

    public void setController(MainController controller) {
        this.controller = controller;
    }

    public UserDashboard(String userName) {
		setForeground(Color.LIGHT_GRAY);
		setLayout(null);
		//** TODO GENERATE ABSTRACT CLASS FROM JPANEL TO SHOW CONTENT
        //** EMPTY first time
		mainPanel = new JPanel();
		mainPanel.setBounds(125, 59, 887, 697);
		add(mainPanel);
		cardLayout = new CardLayout(0, 0);
		JPanel cardLayout2 = new ListCreationForm();
		mainPanel.setLayout(cardLayout);
		defaultPanel = new JPanel();
		mainPanel.add(defaultPanel, "default");

		Button listsIOwn = new Button("Lists I own");
		listsIOwn.addActionListener(this);
		listsIOwn.setBounds(10, 87, 99, 23);
		add(listsIOwn);
		
		Button subscriptions = new Button("Subscriptions");
		subscriptions.addActionListener(this);
		subscriptions.setBounds(10, 118, 99, 23);
		add(subscriptions);
		
		Button myPayments = new Button("My payments");
		myPayments.addActionListener(this);
		myPayments.setBounds(10, 147, 99, 23);
		add(myPayments);
		
		Button createNewList = new Button("Create new");
		createNewList.setBounds(10, 59, 99, 23);
		createNewList.addActionListener(this);
		add(createNewList);
		
		Label welcomeMsg = new Label("Hello  " + userName);
		welcomeMsg.setBounds(461, 26, 219, 21);
		add(welcomeMsg);
		
		Button editUser = new Button("editUser");
		editUser.setBounds(10, 176, 99, 23);
		editUser.addActionListener(this);
		add(editUser);
	}

	public void setMainPanel(JPanel mainPanel) {
        mainPanel = new ListCreationForm();
        mainPanel.setBounds(118, 65, 704, 466);
        add(mainPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        switch (e.getActionCommand()) {
            case "Create new":
                System.out.println("show list form");
                this.controller.cleanValues();
                cardLayout.show(mainPanel, "CreateNew");
                break;
			case "Lists I own":
				System.out.println("User lists");
				this.controller.redirectToLoggedUserLists();
				break;

            default:
                System.out.println(e.getActionCommand());
                this.controller.preFillUserForm();
                cardLayout.show(mainPanel, "editUser");
        }
    }

    public void  showDefault() {
		cardLayout.show(mainPanel, "default");
	}

	public void showPanel(String panelName) {
    	cardLayout.show(mainPanel, panelName);
	}
}
