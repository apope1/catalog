package com.domain;

import javax.persistence.*;

/**
 * Created by Andu on 12.05.2017.
 */
@Entity
@Table(name = "notare")
public class Notare {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idNota;

    @Column(name = "numarMatricol")
    private Integer numarMatricol;

    @Column(name = "idProfesor")
    private Integer idProfesor;

    @Column(name = "valoareNota")
    private Integer valoareNota;

    @Column(name = "comentariu")
    private String comentariu;

    public Notare() {
    }

    public Integer getIdNota() {
        return idNota;
    }

    public void setIdNota(Integer idNota) {
        this.idNota = idNota;
    }

    public Integer getNumarMatricol() {
        return numarMatricol;
    }

    public void setNumarMatricol(Integer numarMatricol) {
        this.numarMatricol = numarMatricol;
    }

    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Integer getValoareNota() {
        return valoareNota;
    }

    public void setValoareNota(Integer valoareNota) {
        this.valoareNota = valoareNota;
    }

    public String getComentariu() {
        return comentariu;
    }

    public void setComentariu(String comentariu) {
        this.comentariu = comentariu;
    }
}
