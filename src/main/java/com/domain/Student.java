package com.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Andu on 12.05.2017.
 */
@Entity
@Table(name = "student")
public class Student {
    @Id

    private Integer numarMatricol;

    @Column(name = "numeStudent")
    private String numeStudent;

    @Column(name = "prenumeStudent")
    private String prenumeStudent;

    @Column(name = "usernameStudent")
    private String usernameStudent;

    @Column(name = "parolaStudent")
    private String parolaStudent;

    public Student(Integer numarMatricol, String numeStudent, String prenumeStudent, String usernameStudent, String parolaStudent) {
        this.numarMatricol = numarMatricol;
        this.numeStudent = numeStudent;
        this.prenumeStudent = prenumeStudent;
        this.usernameStudent = usernameStudent;
        this.parolaStudent = parolaStudent;
    }

    public Student() {
    }

    public Integer getNumarMatricol() {
        return numarMatricol;
    }

    public void setNumarMatricol(Integer numarMatricol) {
        this.numarMatricol = numarMatricol;
    }

    public String getNumeStudent() {
        return numeStudent;
    }

    public void setNumeStudent(String numeStudent) {
        this.numeStudent = numeStudent;
    }

    public String getPrenumeStudent() {
        return prenumeStudent;
    }

    public void setPrenumeStudent(String prenumeStudent) {
        this.prenumeStudent = prenumeStudent;
    }

    public String getUsernameStudent() {
        return usernameStudent;
    }

    public void setUsernameStudent(String usernameStudent) {
        this.usernameStudent = usernameStudent;
    }

    public String getParolaStudent() {
        return parolaStudent;
    }

    public void setParolaStudent(String parolaStudent) {
        this.parolaStudent = parolaStudent;
    }
}
