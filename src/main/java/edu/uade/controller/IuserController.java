package edu.uade.controller;

public interface  IuserController {

    public boolean saveNewUser(String name,  String userEmail, String birhtDay,String password);

    public boolean saveUser(String name, String userEmail, String password, String birthDay, int id);


}
