package com.app.firststore.Model;

public class UserData {
     int balance, numCourses;
     String email, username, profileImage, status;


     public UserData(int balance){
            this.balance = balance;
     }


    public UserData(int balance, String email, String username, String profileImage, String status, int numCourses) {
        this.balance = balance;
        this.email = email;
        this.username = username;
        this.profileImage = profileImage;
        this.status = status;
        this.numCourses = numCourses;
    }

    public int getNumCourses() {return numCourses;}

    public void setNumCourses(int numCourses) {this.numCourses = numCourses;}

    public String getStatus() {return status;}

    public void setStatus(String status) {this.status = status;}

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
}
