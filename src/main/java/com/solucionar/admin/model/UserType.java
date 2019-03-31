package com.solucionar.admin.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user_type")
@NamedQuery(name="UserType.findAll", query="SELECT u FROM UserType u")
public class UserType implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="ust_code")
    private int ustCode;

    @Column(name="ust_description")
    private String ustDescription;

    public UserType() { }

    public int getUstCode() {
        return ustCode;
    }

    public void setUstCode(int ustCode) {
        this.ustCode = ustCode;
    }

    public String getUstDescription() {
        return ustDescription;
    }

    public void setUstDescription(String ustDescription) {
        this.ustDescription = ustDescription;
    }
}
