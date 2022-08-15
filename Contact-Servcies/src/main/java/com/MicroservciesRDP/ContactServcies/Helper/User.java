package com.MicroservciesRDP.ContactServcies.Helper;

public class User {
    private int userId;
    private String firstName;
    private String lastName;
    private int CID;
    public int getCID() {
        return CID;
    }
    public void setCID(int cID) {
        CID = cID;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
