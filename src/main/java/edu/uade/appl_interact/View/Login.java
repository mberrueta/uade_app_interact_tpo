package edu.uade.appl_interact.View;

import edu.uade.controller.LoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private TextField userField;
    private final JButton loginButton;
    private JButton createAccountButton;
    private LoginController loginController;

    /**
	 * Create the panel.
	 */

	public Login() {
    	setBackground(UIManager.getColor("Button.shadow"));
		setLayout(null);
		
		userField = new TextField();
        userField.setBounds(502, 212, 263, 21);
		add(userField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(502, 302, 263, 21);
		add(passwordField);
		
		Label userNameLabel = new Label("User");
		userNameLabel.setForeground(UIManager.getColor("Button.foreground"));
		userNameLabel.setBounds(257, 212, 68, 21);
		add(userNameLabel);
		
		Label PasswordLabel = new Label("Password");
		PasswordLabel.setForeground(UIManager.getColor("Button.foreground"));
		PasswordLabel.setBounds(257, 302, 68, 21);
		add(PasswordLabel);

        loginButton = new JButton("Login");
		loginButton.setBounds(287, 507, 86, 21);
		add(loginButton);


		this.createAccountButton = new JButton("Create new account");
		createAccountButton.setBorderPainted(false);
		createAccountButton.setBounds(506, 510, 193, 15);
		add(createAccountButton);

		setForeground(Color.GRAY);
		getLoginButton().addActionListener(this);
		getCreateAccountButton().addActionListener(this);
	}

	public void setLoginController(LoginController controller) {
		loginController = controller;
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

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getCreateAccountButton(){
		return createAccountButton;
	}

    public void showWrongUserOrPassword() {
        Label emptyField = new Label("User or Password does not match");
        emptyField.setBounds(109, 120, 250, 15);
        add(emptyField);
    }

	public void showLoginError() {
		Label emptyField = new Label("Couldn't login: check email or password");
		emptyField.setBounds(109, 120, 250, 15);
		add(emptyField);
	}

	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "Login":
				String[] loginInfo = this.getLoginContent();
				if (loginInfo[0].isEmpty() || loginInfo[1].isEmpty()) {
					this.showEmptyFieldLabel();
				} else  {
					this.loginController.doLogin(loginInfo[0], loginInfo[1]);
				}
				break;
			case "Forgot password?":
				System.out.println("Forgot password");
				break;
			case "Create new account":
				this.loginController.renderUserForm();
			default:
				System.out.println(e.getActionCommand());
				break;
		}
	}
}
