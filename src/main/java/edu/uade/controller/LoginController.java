package edu.uade.controller;

import edu.uade.appl_interact.Main;
import edu.uade.appl_interact.View.Login;
import edu.uade.appl_interact.model.entities.User;
import edu.uade.appl_interact.services.UserService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginController extends Controller implements ActionListener {

    private JFrame frame;
    private Login login;

    public LoginController(JFrame frame) {
        this.frame = frame;
        login = new Login();
    }

    public void addMain(Main main) {
        this.main = main;
    }

    public void updateView() {
        login.getLoginButton().addActionListener(this);
        frame.setContentPane(login);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Login":
                String[] loginInfo = login.getLoginContent();
                if (loginInfo[0].isEmpty() || loginInfo[1].isEmpty()) {
                    login.showEmptyFieldLabel();
                } else  {
                    this.doLogin(loginInfo[0], loginInfo[1]);
                }
                break;
            case "Forgot password?":
                System.out.println("Forgot password");
                break;
            default:
                System.out.println(e.getActionCommand());
                break;
        }
    }

    private void doLogin(String username, String password) {
        UserService us = UserService.getInstance();
        User user = us.getUser(username, password);
        main.OnUserLogin(user);
    }
}
