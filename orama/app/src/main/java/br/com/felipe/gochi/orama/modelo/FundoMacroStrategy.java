package br.com.felipe.gochi.orama.modelo;

import com.google.gson.annotations.SerializedName;

public class FundoMacroStrategy {

    @SerializedName("explanation")
    private String explanation;

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
