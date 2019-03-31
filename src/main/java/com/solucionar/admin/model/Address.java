package com.solucionar.admin.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="address")
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name="add_code")
    private int addCode;

    @Column(name="add_street")
    private String addStreet;

    @Column(name="add_number")
    private String addNumber;

    @Column(name="add_complement")
    private String addComplement;

    @Column(name="add_neighborhood")
    private String addNeighborhood;

    @Column(name="add_city")
    private String addCity;

    @Column(name="add_state")
    private String addState;

    @Column(name="add_country")
    private String addCountry;

    @Column(name="add_zip_code")
    private String addZipCode;

    public Address() { }

    public int getAddCode() {
        return addCode;
    }

    public void setAddCode(int addCode) {
        this.addCode = addCode;
    }

    public String getAddStreet() {
        return addStreet;
    }

    public void setAddStreet(String addStreet) {
        this.addStreet = addStreet;
    }

    public String getAddNumber() {
        return addNumber;
    }

    public void setAddNumber(String addNumber) {
        this.addNumber = addNumber;
    }

    public String getAddComplement() {
        return addComplement;
    }

    public void setAddComplement(String addComplement) {
        this.addComplement = addComplement;
    }

    public String getAddNeighborhood() {
        return addNeighborhood;
    }

    public void setAddNeighborhood(String addNeighborhood) {
        this.addNeighborhood = addNeighborhood;
    }

    public String getAddCity() {
        return addCity;
    }

    public void setAddCity(String addCity) {
        this.addCity = addCity;
    }

    public String getAddState() {
        return addState;
    }

    public void setAddState(String addState) {
        this.addState = addState;
    }

    public String getAddCountry() {
        return addCountry;
    }

    public void setAddCountry(String addCountry) {
        this.addCountry = addCountry;
    }

    public String getAddZipCode() {
        return addZipCode;
    }

    public void setAddZipCode(String addZipCode) {
        this.addZipCode = addZipCode;
    }
}
