package br.com.felipe.gochi.orama.modelo;


import com.google.gson.annotations.SerializedName;

public class Specification {

    @SerializedName("fund_risk_profile")
    private FundoRiskProfile fundoRiskProfile;

    @SerializedName("fund_type")
    private String fundType;

    @SerializedName("fund_macro_strategy")
    private FundoMacroStrategy fundoMacroStrategy;

    @SerializedName("is_qualified")
    private Boolean isQualified;

    public Boolean getQualified() {
        return isQualified;
    }

    public void setQualified(Boolean qualified) {
        isQualified = qualified;
    }



    public FundoRiskProfile getFundoRiskProfile() {
        return fundoRiskProfile;
    }

    public void setFundoRiskProfile(FundoRiskProfile fundoRiskProfile) {
        this.fundoRiskProfile = fundoRiskProfile;
    }

    public String getFundType() {
        return fundType;
    }

    public void setFundType(String fundType) {
        this.fundType = fundType;
    }

    public FundoMacroStrategy getFundoMacroStrategy() {
        return fundoMacroStrategy;
    }

    public void setFundoMacroStrategy(FundoMacroStrategy fundoMacroStrategy) {
        this.fundoMacroStrategy = fundoMacroStrategy;
    }
}
