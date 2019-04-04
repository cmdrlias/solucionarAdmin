package com.solucionar.admin.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class Representative implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name="cpr_code")
    private int cprCode;

    @Column(name="cpr_name")
    private String cprName;

    @Column(name="cpr_email")
    private String cprEmail;

    public Representative() { }

    public int getCprCode() {
        return cprCode;
    }

    public void setCprCode(int cprCode) {
        this.cprCode = cprCode;
    }

    public String getCprName() {
        return cprName;
    }

    public void setCprName(String cprName) {
        this.cprName = cprName;
    }

    public String getCprEmail() {
        return cprEmail;
    }

    public void setCprEmail(String cprEmail) {
        this.cprEmail = cprEmail;
    }
}
