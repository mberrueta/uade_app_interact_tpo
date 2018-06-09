package edu.uade.appl_interact.View;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
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
	private TextField userField;
    private final Button loginButton;

    /**
	 * Create the panel.
	 */
	public Login() {
		setLayout(null);
		
		userField = new TextField();
        userField.setBounds(242, 41, 123, 21);
		add(userField);
		
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

        loginButton = new Button("Login");
		loginButton.setBounds(109, 168, 86, 21);
		add(loginButton);

		
		JLabel lblCreateNewAccount = new JLabel("Create new account ");
		lblCreateNewAccount.setBounds(170, 220, 146, 15);
		add(lblCreateNewAccount);

		setForeground(Color.GRAY);
		JButton Lgoin = new JButton("");
		add(Lgoin, "1, 2, fill, default");
	}

	public String[] getLoginContent() {
	    String[] loginContent = {userField.getText(), passwordField.getText()};
        return loginContent;
    }


	public void showEmptyFieldLabel() {
        Label emptyField = new Label("User or Password cannot be empty");
        emptyField.setBounds(109, 120, 250, 15);
        add(emptyField);
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public void showWrongUserOrPassword() {
        Label emptyField = new Label("User or Password does not match");
        emptyField.setBounds(109, 120, 250, 15);
        add(emptyField);
    }
}
