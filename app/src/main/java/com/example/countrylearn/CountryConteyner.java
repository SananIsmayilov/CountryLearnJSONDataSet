package com.example.countrylearn;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CountryConteyner implements Serializable {
@SerializedName("name")
    String name;

    @SerializedName("capital")
    String capital;

    @SerializedName("region")
    String region;

    @SerializedName("currency")
    String currency;

    @SerializedName("flag")
    String flag;

    @SerializedName("language")
    String language;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
