package com.jorgealvarez.myboda.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "attendant")
@AllArgsConstructor
@NoArgsConstructor
public class Attendant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String surname;
    private String dob;
    private String ph;

    private Status attendingStatus;

    private String specialRequirement;

    private String specialRequirementStatus;

    private String loggedUser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }

    public Status getAttendingStatus() {
        return attendingStatus;
    }

    public void setAttendingStatus(Status attendingStatus) {
        this.attendingStatus = attendingStatus;
    }

    public String getSpecialRequirement() {
        return specialRequirement;
    }

    public void setSpecialRequirement(String specialRequirement) {
        this.specialRequirement = specialRequirement;
    }

    public String getSpecialRequirementStatus() {
        return specialRequirementStatus;
    }

    public void setSpecialRequirementStatus(String specialRequirementStatus) {
        this.specialRequirementStatus = specialRequirementStatus;
    }

    public String getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(String loggedUser) {
        this.loggedUser = loggedUser;
    }
}