package com.learn.RestApi.RestApiAdvance.versioning;

public class Address {
    private String locality;
    private String city;
    private String country;

    public Address(String locality, String city, String country) {
        super();
        this.locality = locality;
        this.city = city;
        this.country = country;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
