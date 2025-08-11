package com.pavan.github.estatemanagementsystem.modals;

public class User {
    private String id;           
    private String name;         
    private String email;        
    private String phoneNumber;  
    private Address address;
    private String password;     

    // Constructors
    public User() {}

    public User(String id, String name, String email, String phoneNumber, String password, Address address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.address = address;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Address getAddress() {
		return this.address;
	}
    
    public void setAddress(Address address) {
		this.address = address;
	}

    // Optional: toString() for debugging
    @Override
    public String toString() {
        return "User{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", email='" + email + '\'' +
               ", phoneNumber='" + phoneNumber + '\'' +
               ", password='" + password + '\'' +
               ", address= '" + address +
               '}';
    }
}