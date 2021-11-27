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
public class UnivStat {

    String code;
    LocalDate Date_Res;
    int count;

    public UnivStat(String code, LocalDate Date_Res, int count) {
        this.code = code;
        this.Date_Res = Date_Res;
        this.count = count;
    }

    public UnivStat() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getDate_Res() {
        return Date_Res;
    }

    public void setDate_Res(LocalDate Date_Res) {
        this.Date_Res = Date_Res;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
