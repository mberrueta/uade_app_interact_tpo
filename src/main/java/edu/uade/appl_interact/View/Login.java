package edu.uade.appl_interact.View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import java.awt.TextField;
import java.awt.Button;
import javax.swing.JPasswordField;
import java.awt.Label;
import javax.swing.JLabel;

public class Login extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public Login() {
		setLayout(null);
		
		TextField User = new TextField();
		User.setBounds(242, 41, 123, 21);
		add(User);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(242, 91, 123, 21);
		add(passwordField);
		
		Label userNameLabel = new Label("User");
		userNameLabel.setBounds(109, 41, 68, 21);
		add(userNameLabel);
		
		Label PasswordLabel = new Label("Password");
		PasswordLabel.setBounds(109, 91, 68, 21);
		add(PasswordLabel);
		
		Button forgotPassword = new Button("Forgot password?");
		forgotPassword.setBounds(248, 168, 117, 21);
		add(forgotPassword);
		
		Button LoginButton = new Button("Login");
		LoginButton.setBounds(109, 168, 86, 21);
		add(LoginButton);
		
		JLabel lblCreateNewAccount = new JLabel("Create new account ");
		lblCreateNewAccount.setBounds(170, 220, 146, 15);
		add(lblCreateNewAccount);
		setForeground(Color.GRAY);
		JButton Lgoin = new JButton("");
		add(Lgoin, "1, 2, fill, default");

	}
}
