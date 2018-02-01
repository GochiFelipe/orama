package br.com.felipe.gochi.orama.modelo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Operability{

    @SerializedName("minimum_initial_application_amount")
    private String minimumInitialAplicationAmount;

    public String getMinimumInitialAplicationAmount() {
        return minimumInitialAplicationAmount;
    }

    public void setMinimumInitialAplicationAmount(String minimumInitialAplicationAmount) {
        this.minimumInitialAplicationAmount = minimumInitialAplicationAmount;
    }

}
