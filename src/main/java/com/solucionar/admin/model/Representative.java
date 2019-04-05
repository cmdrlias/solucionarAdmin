package com.solucionar.admin.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="representative")
public class Representative implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name="rep_code")
    private int repCode;

    @Column(name="rep_name")
    private String repName;

    @Column(name="rep_email")
    private String repEmail;

    public Representative() { }

    public int getRepCode() {
        return repCode;
    }

    public void setRepCode(int repCode) {
        this.repCode = repCode;
    }

    public String getRepName() {
        return repName;
    }

    public void setRepName(String cprName) {
        this.repName = repName;
    }

    public String getRepEmail() {
        return repEmail;
    }

    public void setRepEmail(String repEmail) {
        this.repEmail = repEmail;
    }
}
