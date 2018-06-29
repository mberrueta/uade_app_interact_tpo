package edu.uade.controller;

import edu.uade.appl_interact.Main;
import edu.uade.appl_interact.View.Login;
import edu.uade.appl_interact.View.UserForm;
import edu.uade.appl_interact.model.entities.User;
import edu.uade.appl_interact.services.UserService;

import javax.swing.*;
import java.text.SimpleDateFormat;


public class LoginController  implements  IuserController {

    private JFrame frame;
    private Login login;
    private UserForm userForm;
    private JPanel currentView;
    private Main main;

    public LoginController(JFrame frame) {
        this.frame = frame;
        login = new Login();
        userForm = new UserForm();
    }

    public void updateView() {
        frame.setContentPane(this.getCurrentView());
        frame.repaint();
        frame.setVisible(true);
    }

    @Override
    public void setMain(Main main) {
        this.main = main;
    }

    @Override
    public void renderMain() {
        renderLoginForm();
    }

    @Override
    public void setMainMenu(Main main) {
        this.main = main;
    }

    @Override
    public void deleteAccount() {
        return;
    }

    private JPanel getCurrentView() {
        if (currentView == null) {
            renderLoginForm();
        }
        return currentView;
    }

    public void renderLoginForm() {
        currentView = login;
        login.setLoginController(this);
        this.updateView();
    }

    public void renderUserForm() {
        currentView = userForm;
        userForm.setUserController(this);
        this.updateView();
    }

    public void doLogin(String userEmail, String password) {
        UserService us = UserService.getInstance();
        if ( us.login(userEmail, password)) {
            User user = us.getUserFromEmail(userEmail);
            if (user != null) {
                main.OnUserLogin(user);
            }
            login.showWrongUserOrPassword();
            frame.repaint();
        }
        login.showWrongUserOrPassword();
        frame.repaint();
    }

    @Override
    public boolean saveNewUser(String name,String userEmail, String birthDay, String password) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        User user  = new User();
        user.setName(name);
        user.setEmail(userEmail);
        user.setPassword(password);
        UserService manager = UserService.getInstance();
        try {
            user.setBirthDate(format.parse(birthDay));
            manager.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean saveUser(String name,  String userEmail, String password, String birthDay, int id) {
        return false;
    }

    @Override
    public boolean userNameInUse() {
        return false;
    }
}
