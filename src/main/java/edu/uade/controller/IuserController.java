package edu.uade.controller;

public interface  IuserController extends Controller {

    public boolean saveNewUser(String name,  String userEmail, String password);

    public boolean saveUser(String name, String userEmail, String password, int id);

    public boolean userNameInUse();

}
