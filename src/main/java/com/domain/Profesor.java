package com.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Andu on 12.05.2017.
 */
@Entity
@Table(name = "profesor")
public class Profesor {
    @Id
    private Integer idProfesor;

    @Column(name = "numeProfesor")
    private String numeProfesor;

    @Column(name = "prenumeProfesor")
    private String prenumeProfesor;

    @Column(name = "materie")
    private String materie;

    @Column(name = "usernameProfesor")
    private String usernameProfesor;

    @Column(name = "parolaProfesor")
    private String parolaProfesor;

    public Profesor() {
    }

    public Profesor(Integer idProfesor, String numeProfesor, String prenumeProfesor, String materie, String usernameProfesor, String parolaProfesor) {
        this.idProfesor = idProfesor;
        this.numeProfesor = numeProfesor;
        this.prenumeProfesor = prenumeProfesor;
        this.materie = materie;
        this.usernameProfesor = usernameProfesor;
        this.parolaProfesor = parolaProfesor;
    }

    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNumeProfesor() {
        return numeProfesor;
    }

    public void setNumeProfesor(String numeProfesor) {
        this.numeProfesor = numeProfesor;
    }

    public String getPrenumeProfesor() {
        return prenumeProfesor;
    }

    public void setPrenumeProfesor(String prenumeProfesor) {
        this.prenumeProfesor = prenumeProfesor;
    }

    public String getMaterie() {
        return materie;
    }

    public void setMaterie(String materie) {
        this.materie = materie;
    }

    public String getUsernameProfesor() {
        return usernameProfesor;
    }

    public void setUsernameProfesor(String usernameProfesor) {
        this.usernameProfesor = usernameProfesor;
    }

    public String getParolaProfesor() {
        return parolaProfesor;
    }

    public void setParolaProfesor(String parolaProfesor) {
        this.parolaProfesor = parolaProfesor;
    }
}
