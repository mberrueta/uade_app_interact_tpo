package edu.uade.controller;

import edu.uade.appl_interact.Main;
import edu.uade.appl_interact.View.ListCreationForm;
import edu.uade.appl_interact.View.UserDashboard;
import edu.uade.appl_interact.View.UserForm;
import edu.uade.appl_interact.model.entities.User;
import edu.uade.appl_interact.services.UserService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController implements ActionListener, IuserController {
    private JFrame frame;
    private User loggedUser;
    private UserForm userForm;
    private ListCreationForm listCreationForm;

    public MainController(JFrame frame, User loggedUser) {
        this.frame = frame;
        this.loggedUser = loggedUser;
        this.listCreationForm = new ListCreationForm();
        this.userForm = new UserForm();
        userForm.setUserController(this);
    }

    // TODO Add action permformed Events.
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void updateView() {
        renderMain();
    }

    @Override
    public void setMain(Main main) {
        renderMain();
    }

    @Override
    public void renderMain() {
        UserDashboard dashboard = new UserDashboard(loggedUser.getName());
        dashboard.setController(this);
        dashboard.addToCardLayout(listCreationForm, "CreateNew");
        dashboard.addToCardLayout(userForm, "editUser");
        frame.setContentPane(dashboard);
        frame.revalidate();
        frame.repaint();
    }

    public void preFillUserForm() {
        this.userForm.setUsrId(loggedUser.getId());
        this.userForm.addNameInfo(loggedUser.getName());
        this.userForm.addPasswordInfo(loggedUser.getPassword());
        this.userForm.addEmailInfo(loggedUser.getEmail());
    }

    @Override
    public boolean saveNewUser(String name, String userEmail, String password) {
        return false;
    }

    @Override
    public boolean saveUser(String name, String userEmail, String password, int id) {
        User user  = new User();
        user.setName(name);
        user.setEmail(userEmail);
        user.setPassword(password);
        user.setId(id);
        UserService manager = UserService.getInstance();
        try {
            manager.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // UPDATE USER INFO
        this.loggedUser = user;
        this.renderMain();
        return false;
    }


    @Override
    public boolean userNameInUse() {
        return false;
    }
}
