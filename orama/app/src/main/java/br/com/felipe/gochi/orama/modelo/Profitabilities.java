package br.com.felipe.gochi.orama.modelo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Profitabilities{

    private String month;

    private String m12;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getM12() {
        return m12;
    }

    public void setM12(String m12) {
        this.m12 = m12;
    }

}
