package com.example.bossnotes;

import androidx.annotation.NonNull;

public class BossData {
    String Name, email, password, birth,gender;
    int id, number;
    public String getName() {
        return Name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getBirth() {
        return birth;
    }
    public String getGender() {
        return gender;
    }
    public int getId() {
        return id;
    }
    public int getNumber() {
        return number;
    }


    public void setName(String name) {
        Name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setBirth(String birth) {
        this.birth = birth;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNumber(int number) {
        this.number = number;
    }

    public BossData(String name, String email, String password, String birth, String gender, int id, int number) {
        Name = name;
        this.email = email;
        this.password = password;
        this.birth = birth;
        this.gender = gender;
        this.id = id;
        this.number = number;
    }

    @NonNull
    @Override
    public String toString() {
        return  ""+id+"-"+Name+"-"+email+"-"+password+"-"+birth+"-"+gender+"-"+number ;
    }
}
