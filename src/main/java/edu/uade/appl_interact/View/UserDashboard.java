package edu.uade.appl_interact.View;

import edu.uade.controller.MainController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.CardLayout;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.UIManager;
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
    	setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
    	setBackground(UIManager.getColor("InternalFrame.borderDarkShadow"));
		setForeground(Color.DARK_GRAY);
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
		defaultPanel.setBackground(UIManager.getColor("Button.shadow"));
		mainPanel.add(defaultPanel, "default");

		Button listsIOwn = new Button("Lists I own");
		listsIOwn.setBackground(Color.LIGHT_GRAY);
		listsIOwn.addActionListener(this);
		listsIOwn.setBounds(10, 87, 99, 23);
		add(listsIOwn);
		
		Button subscriptions = new Button("Subscriptions");
		subscriptions.setBackground(Color.LIGHT_GRAY);
		subscriptions.addActionListener(this);
		subscriptions.setBounds(10, 118, 99, 23);
		add(subscriptions);
		
		Button myPayments = new Button("My payments");
		myPayments.setBackground(Color.LIGHT_GRAY);
		myPayments.addActionListener(this);
		myPayments.setBounds(10, 147, 99, 23);
		add(myPayments);
		
		Button createNewList = new Button("Create new");
		createNewList.setBackground(Color.LIGHT_GRAY);
		createNewList.setBounds(10, 59, 99, 23);
		createNewList.addActionListener(this);
		add(createNewList);
		
		Label welcomeMsg = new Label("Hello  " + userName);
		welcomeMsg.setFont(new Font("Dialog", Font.BOLD, 19));
		welcomeMsg.setAlignment(Label.CENTER);
		welcomeMsg.setBounds(461, 26, 219, 21);
		add(welcomeMsg);
		
		Button editUser = new Button("Edit account");
		editUser.setBackground(Color.LIGHT_GRAY);
		editUser.setBounds(10, 176, 99, 23);
		editUser.addActionListener(this);
		add(editUser);

		Button logout = new Button("Log out");
		logout.setBackground(Color.LIGHT_GRAY);
		logout.setBounds(10, 205, 99, 23);
		logout.addActionListener(this);
		add(logout);


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
                this.controller.redirectToListCreation();
                break;
			case "Lists I own":
				System.out.println("User lists");
				this.controller.redirectToLoggedUserLists();
				break;
			case "Subscriptions":
				this.controller.redirectToUserSubscriptions();
				break;
			case "Log out":
				this.controller.logout();
				break;
			case "My payments" :
				this.controller.redirectToUserPaymentList();
				break;
            default:
                System.out.println(e.getActionCommand());
                this.controller.preFillUserForm();
                cardLayout.show(mainPanel, "editUser");
                break;
        }
    }

    public void  showDefault() {
		cardLayout.show(mainPanel, "default");
	}

	public void showPanel(String panelName) {
    	cardLayout.show(mainPanel, panelName);
	}
}
