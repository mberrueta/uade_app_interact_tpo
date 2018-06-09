package edu.uade.controller;

import edu.uade.appl_interact.Main;
import edu.uade.appl_interact.View.UserDashboard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class MainController extends Controller implements ActionListener {
    private JFrame frame;

    public MainController(JFrame frame) {
        this.frame = frame;
    }

    // TODO Add action permformed Events.
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void updateView() {
        frame.setContentPane(new UserDashboard());
        frame.revalidate();
        frame.repaint();
    }
}
