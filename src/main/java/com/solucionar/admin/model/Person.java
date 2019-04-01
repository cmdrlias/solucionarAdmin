package com.solucionar.admin.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="person")
@NamedQuery(name="Person.findAll", query="SELECT p FROM Person p")
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name="per_code")
    private int perCode;

    @Column(name="per_name")
    private String perName;

    @Column(name="per_cpf")
    private String perCpf;

    @OneToOne
    @JoinTable(name="person_address",
            joinColumns={@JoinColumn(name="per_code")},
            inverseJoinColumns={@JoinColumn(name="add_code")})
    private Address address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="person_phone",
               joinColumns={@JoinColumn(name="per_code")},
               inverseJoinColumns={@JoinColumn(name="pho_code")})
    private List<Phone> phones;

    public Person() { }

    public int getPerCode() {
        return perCode;
    }

    public void setPerCode(int perCode) {
        this.perCode = perCode;
    }

    public String getPerName() {
        return perName;
    }

    public void setPerName(String perName) {
        this.perName = perName;
    }

    public String getPerCpf() {
        return perCpf;
    }

    public void setPerCpf(String perCpf) {
        this.perCpf = perCpf;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
