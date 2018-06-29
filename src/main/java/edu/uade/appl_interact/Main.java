package edu.uade.appl_interact;

import edu.uade.appl_interact.model.entities.User;
import edu.uade.controller.Controller;
import edu.uade.controller.LoginController;
import edu.uade.controller.MainController;

import javax.swing.*;


public class Main  {

    private Controller controller;
    private JFrame frame;
    private User loggedUser;

    public Main () {
        frame  = new JFrame("Regalitos");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1024, 768);
        frame.setLocationRelativeTo(null);
        controller = new LoginController(frame);
        controller.setMain(this);
    }


    public void run() {
        controller.updateView();
    }

    public void OnUserLogout() {
        loggedUser = null;
        controller = new LoginController(frame);
        controller.setMain(this);
        run();
    }

    public void OnUserLogin(User user) {
        loggedUser = user;
        controller = new MainController(frame, user);
        controller.setMainMenu(this);
        run();
    }
}
