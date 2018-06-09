package edu.uade.appl_interact.model.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import edu.uade.appl_interact.model.entities.GiftList;
import edu.uade.appl_interact.model.entities.Payment;
import edu.uade.appl_interact.model.entities.User;
import edu.uade.appl_interact.observers.PaymentObservable;

public class PaymentManager extends PaymentObservable {

    private GiftList list;
    private User user;
    private Payment payment;

    // TODO: implent cron each 1 min
    // id, amount, listname
    // 123,12.22,list_pepe
    public void check_payments() {
        try {
            File f = new File("resources/payments.cvs");
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine = "";
            while ((readLine = b.readLine()) != null) {
                System.out.println(readLine);
                // pay(readLine[0], readLine[1], readLine[2]);
                pay(1, 1f, "asd");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void pay(Integer user_id, Float amount, String list_name) {
        list = getListByName(list_name);
        user = getUserById(user_id);
        payment = new Payment();
        payment.setPayer(user);
        notifyAllObservers();
    }

    private User getUserById(Integer user_id) {
        return null;
    }

    private GiftList getListByName(String name) {
        GiftList list = new GiftList();
        list.setListName(name);
        return list;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public GiftList getList() {
        return list;
    }

    public void setList(GiftList list) {
        this.list = list;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }


}
