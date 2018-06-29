package edu.uade.appl_interact.View;

import edu.uade.controller.IuserController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.UIManager;


public class UserForm extends JPanel implements ActionListener{
	private JTextField name;
	private JTextField userEmail;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private IuserController controller;
	private int usrId;
	private JTextField birthday;

	/**
	 * Create the panel.
	 */
	public UserForm() {
		setBackground(UIManager.getColor("Button.shadow"));
		usrId = -1;
		setLayout(null);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(189, 420, 117, 25);
		btnSave.addActionListener(this);
		add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(373, 420, 117, 25);
		btnCancel.addActionListener(this);
		add(btnCancel);
		
		name = new JTextField();
		name.setBounds(376, 85, 114, 19);
		add(name);
		name.setColumns(10);


		userEmail = new JTextField();
		userEmail.setColumns(10);
		userEmail.setBounds(376, 136, 114, 19);
		add(userEmail);
		
		JLabel Name = new JLabel("name:");
		Name.setBounds(189, 87, 70, 15);
		add(Name);

		JLabel lblEmail = new JLabel("email:");
		lblEmail.setBounds(189, 138, 70, 15);
		add(lblEmail);
		
		JLabel lblPassword = new JLabel("password:");
		lblPassword.setBounds(189, 251, 94, 15);
		add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(376, 249, 114, 19);
		add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(376, 307, 114, 19);
		add(passwordField_1);
		
		JLabel label = new JLabel("re-enter password:");
		label.setBounds(189, 309, 153, 15);
		add(label);
		
		JLabel lblBirthday = new JLabel("Birthday :");
		lblBirthday.setBounds(189, 193, 70, 15);
		add(lblBirthday);
		
		birthday = new JTextField();
		birthday.setColumns(10);
		birthday.setBounds(376, 191, 114, 19);
		add(birthday);

	}

	public void addNameInfo(String name) {
		this.name.setText(name);
	}

	public void addEmailInfo(String emailInfo) {
		this.userEmail.setText(emailInfo);
	}

	public void addPasswordInfo(String passwordInfo) {
		this.passwordField.setText(passwordInfo);
		this.passwordField_1.setText(passwordInfo);
	}

	public void setUserController(IuserController userController) {
		this.controller = userController;
	}

	public void setUsrId(int usrId) {
		this.usrId = usrId;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "Save" :
				boolean saved  = this.doSave();
				if (saved) {
					this.controller.renderMain();
				}
				break;
			case "Cancel":
				this.controller.renderMain();
		}
	}

	private boolean doSave() {
		String name = this.name.getText();
		String userEmail = this.userEmail.getText();
		String password = this.passwordField.getText();
		String repassword = this.passwordField_1.getText();
		if (!password.equals(repassword)) {
			showDifferentPasswordLabel();
			return  false;
		}
		if (!userEmail.contains("@") || !userEmail.contains(".com")) {
			this.showWrongEmailLabel();
			return false;
		}
		if (usrId == -1) {
			controller.saveNewUser(name, userEmail, password);
		} else {
			controller.saveUser(name, userEmail, password, usrId);
		}
		return true;
 	}

	private void showDifferentPasswordLabel() {

	}

	private void showWrongEmailLabel() {

	}
}
