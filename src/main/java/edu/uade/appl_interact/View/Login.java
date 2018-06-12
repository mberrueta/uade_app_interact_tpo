package edu.uade.appl_interact.View;

import edu.uade.controller.LoginController;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.TextField;
import java.awt.Button;
import javax.swing.JPasswordField;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

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

        loginButton = new JButton("Login");
		loginButton.setBounds(109, 168, 86, 21);
		add(loginButton);


		this.createAccountButton = new JButton("Create new account");
		createAccountButton.setBorderPainted(false);
		createAccountButton.setBounds(170, 220, 146, 15);
		add(createAccountButton);

		setForeground(Color.GRAY);
		JButton Lgoin = new JButton("");
		add(Lgoin, "1, 2, fill, default");
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
