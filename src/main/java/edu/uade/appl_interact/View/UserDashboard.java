package edu.uade.appl_interact.View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.Button;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserDashboard extends JPanel {

	/**
	 * Create the panel.
	 */
	public UserDashboard() {
		setForeground(Color.LIGHT_GRAY);
		setLayout(null);
		//** TODO GENERATE ABSTRACT CLASS FROM JPANEL TO SHOW CONTENT
		JPanel panel = new JPanel();
		panel.setBounds(118, 0, 736, 438);
		add(panel);
		
		Button listsIOwn = new Button("Lists I own");
		listsIOwn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		listsIOwn.setBounds(0, 60, 99, 23);
		add(listsIOwn);
		
		Button subscriptions = new Button("Subscriptions");
		subscriptions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		subscriptions.setBounds(0, 88, 99, 23);
		add(subscriptions);
		
		Button myPayments = new Button("My payments");
		myPayments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		myPayments.setBounds(0, 117, 99, 23);
		add(myPayments);
		
		Button createNewList = new Button("Create new ");
		createNewList.setBounds(0, 31, 99, 23);
		add(createNewList);

	}
}
