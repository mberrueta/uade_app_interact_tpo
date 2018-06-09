package edu.uade.controller;

import edu.uade.appl_interact.Main;

abstract public class Controller {

    protected Main main;

    abstract public void updateView();

    public void setMain(Main main) {
        this.main = main;
    }

}
