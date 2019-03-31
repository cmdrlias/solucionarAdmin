package com.solucionar.admin.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="phone_type")
@NamedQuery(name="PhoneType.findAll", query="SELECT p FROM PhoneType p")
public class PhoneType  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="pht_code")
    private int phtCode;

    @Column(name="pht_description")
    private String phtDescription;

    public PhoneType() { }

    public int getPhtCode() {
        return phtCode;
    }

    public void setPhtCode(int phtCode) {
        this.phtCode = phtCode;
    }

    public String getPhtDescription() {
        return phtDescription;
    }

    public void setPhtDescription(String phtDescription) {
        this.phtDescription = phtDescription;
    }
}
