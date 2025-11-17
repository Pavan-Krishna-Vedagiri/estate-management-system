package com.pavan.github.estatemanagementsystem.modals;

public class Address {
    private String id;         // Primary key
    private String doorNo;     // Not null
    private String street;     // Not null
    private String city;       // Not null
    private String country;    // Optional
    private String pincode;    // Optional

    // Constructors
    public Address() {}

    public Address(String id, String doorNo, String street, String city, String country, String pincode) {
        this.id = id;
        this.doorNo = doorNo;
        this.street = street;
        this.city = city;
        this.country = country;
        this.pincode = pincode;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    // Optional: toString() for debugging
    @Override
    public String toString() {
        return "Address{" +
               "id='" + id + '\'' +
               ", doorNo='" + doorNo + '\'' +
               ", street='" + street + '\'' +
               ", city='" + city + '\'' +
               ", country='" + country + '\'' +
               ", pincode='" + pincode + '\'' +
               '}';
    }
}