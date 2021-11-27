/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dt.project.javafx.rmi.server.utilities;

import java.time.LocalDate;

/**
 *
 * @author Bureau
 */
public class historiqueR {

    private int id;
    private int idUser;
    private String ip;
    private String trav;
    private LocalDate Dat_trav;

    public historiqueR(int id, int idUser, String ip, String trav, LocalDate Dat_trav) {
        this.id = id;
        this.idUser = idUser;
        this.ip = ip;
        this.trav = trav;
        this.Dat_trav = Dat_trav;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTrav() {
        return trav;
    }

    public void setTrav(String trav) {
        this.trav = trav;
    }

    public LocalDate getDat_trav() {
        return Dat_trav;
    }

    public void setDat_trav(LocalDate Dat_trav) {
        this.Dat_trav = Dat_trav;
    }

}
