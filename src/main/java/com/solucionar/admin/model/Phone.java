package com.solucionar.admin.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="phone")
@NamedQuery(name="Phone.findAll", query="SELECT p FROM Phone p")
public class Phone implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name="pho_code")
    private int phoCode;

    @Column(name="pho_area_code")
    private short phoAreaCode;

    @Column(name="pho_number")
    private int phoNumber;

    @OneToOne
    @JoinColumn(name="pht_code")
    private PhoneType phoneType;

    public int getPhoCode() {
        return phoCode;
    }

    public void setPhoCode(int phoCode) {
        this.phoCode = phoCode;
    }

    public short getPhoAreaCode() {
        return phoAreaCode;
    }

    public void setPhoAreaCode(short phoAreaCode) {
        this.phoAreaCode = phoAreaCode;
    }

    public int getPhoNumber() {
        return phoNumber;
    }

    public void setPhoNumber(int phoNumber) {
        this.phoNumber = phoNumber;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }
}
