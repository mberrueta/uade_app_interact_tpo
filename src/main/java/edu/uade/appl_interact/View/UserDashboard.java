package edu.uade.appl_interact.View;

import edu.uade.controller.MainController;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;
import java.awt.CardLayout;

public class UserDashboard extends JPanel implements ActionListener {
	private JPanel mainPanel;
    private CardLayout cardLayout;
    private MainController controller;

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
		mainPanel.setBounds(118, 65, 704, 466);
		add(mainPanel);
		cardLayout = new CardLayout(0, 0);
		JPanel cardLayout2 = new ListCreationForm();
		mainPanel.setLayout(cardLayout);


		Button listsIOwn = new Button("Lists I own");
		listsIOwn.addActionListener(this);
		listsIOwn.setBounds(13, 59, 99, 23);
		add(listsIOwn);
		
		Button subscriptions = new Button("Subscriptions");
		subscriptions.addActionListener(this);
		subscriptions.setBounds(13, 90, 99, 23);
		add(subscriptions);
		
		Button myPayments = new Button("My payments");
		myPayments.addActionListener(this);
		myPayments.setBounds(13, 119, 99, 23);
		add(myPayments);
		
		Button createNewList = new Button("Create new");
		createNewList.setBounds(13, 31, 99, 23);
		createNewList.addActionListener(this);
		add(createNewList);
		
		Label welcomeMsg = new Label("Hello  " + userName);
		welcomeMsg.setBounds(350, 31, 219, 21);
		add(welcomeMsg);
		
		Button editUser = new Button("editUser");
		editUser.setBounds(13, 148, 99, 23);
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
                cardLayout.show(mainPanel, "CreateNew");
                break;
            default:
                System.out.println("show user form");
                this.controller.preFillUserForm();
                cardLayout.show(mainPanel, "editUser");
        }
    }
}
