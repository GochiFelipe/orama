package br.com.felipe.gochi.orama.modelo;

import com.google.gson.annotations.SerializedName;

public class FundoRiskProfile {

    @SerializedName("score_range_order")
    private Integer scoreRangeOrder;

    @SerializedName("name")
    private String nome;

    public Integer getScoreRangeOrder() {
        return scoreRangeOrder;
    }

    public void setScoreRangeOrder(Integer scoreRangeOrder) {
        this.scoreRangeOrder = scoreRangeOrder;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
