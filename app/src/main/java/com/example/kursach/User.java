package com.example.kursach;

public class User {
    private String name, email, pass, phone;

    public User(String name, String email, String pass, String phone){
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.phone = phone;
    }

    public User() {

    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPass() {
        return pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {

        this.email = email.replaceAll(".", "");
        this.email = this.email.replaceAll("@", "");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
