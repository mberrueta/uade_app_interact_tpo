package edu.uade.appl_interact.model.entities;

import java.util.List;

public class ListAdmin extends Role {
    private List<Gifter> invited;
    private List<Gifter> accepted;

    public List<Gifter> getInvited() {
        return invited;
    }

    public void setInvited(List<Gifter> invited) {
        this.invited = invited;
    }

    public List<Gifter> getAccepted() {
        return accepted;
    }

    public void setAccepted(List<Gifter> accepted) {
        this.accepted = accepted;
    }
}