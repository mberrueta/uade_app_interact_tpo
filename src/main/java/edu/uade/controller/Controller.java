package edu.uade.controller;

import edu.uade.appl_interact.Main;

public interface Controller {


    public void updateView();

    public void setMain(Main main);

    public void renderMain();

    void setMainMenu(Main main);
}
