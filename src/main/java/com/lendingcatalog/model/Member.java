package com.lendingcatalog.model;

public class Member {

    private String firstName;
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}


    private String lastName;
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}


    public Member(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        return firstName + " " + lastName;
    }


}
