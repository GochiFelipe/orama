package br.com.felipe.gochi.orama.modelo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FundoInvestimento {

    @SerializedName("simple_name")
    private String simpleName;

    @SerializedName("profitabilities")
    private Profitabilities profitabilities;

    @SerializedName("operability")
    private Operability operability;

    @SerializedName("specification")
    private Specification specification;

    public Specification getSpecification() {
        return specification;
    }

    public void setSpecification(Specification specification) {
        this.specification = specification;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public Profitabilities getProfitabilities() {
        return profitabilities;
    }

    public void setProfitabilities(Profitabilities profitabilities) {
        this.profitabilities = profitabilities;
    }

    public Operability getOperability() {
        return operability;
    }

    public void setOperability(Operability operability) {
        this.operability = operability;
    }

}
