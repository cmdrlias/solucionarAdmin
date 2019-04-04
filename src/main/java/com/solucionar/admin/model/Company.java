package com.solucionar.admin.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="company")
@NamedQuery(name="Company.findAll()", query="SELECT c FROM Company c")
public class Company  implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name="cmp_code")
    private int cmpCode;

    @Column(name="cmp_name")
    private String cmpName;

    @Column(name="cmp_social_name")
    private String cmpSocialName;

    @Column(name="cmp_insc_estadual")
    private String cmpInscricaoEstadual;

    @Column(name="cmp_insc_municipal")
    private String cmpInscricaoMunicipal;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name="set_company_representative",
            joinColumns={@JoinColumn(name="cmp_code")},
            inverseJoinColumns={@JoinColumn(name="cpr_code")})
    private Person person;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="company_phone",
            joinColumns={@JoinColumn(name="cmp_code")},
            inverseJoinColumns={@JoinColumn(name="pho_code")})
    private List<Phone> phones;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name="company_address",
            joinColumns={@JoinColumn(name="cmp_code")},
            inverseJoinColumns={@JoinColumn(name="add_code")})
    private Address address;

    public Company() { }

    public int getCmpCode() {
        return cmpCode;
    }

    public void setCmpCode(int cmpCode) {
        this.cmpCode = cmpCode;
    }

    public String getCmpName() {
        return cmpName;
    }

    public void setCmpName(String cmpName) {
        this.cmpName = cmpName;
    }

    public String getCmpSocialName() {
        return cmpSocialName;
    }

    public void setCmpSocialName(String cmpSocialName) {
        this.cmpSocialName = cmpSocialName;
    }

    public String getCmpInscricaoEstadual() {
        return cmpInscricaoEstadual;
    }

    public void setCmpInscricaoEstadual(String cmpInscricaoEstadual) {
        this.cmpInscricaoEstadual = cmpInscricaoEstadual;
    }

    public String getCmpInscricaoMunicipal() {
        return cmpInscricaoMunicipal;
    }

    public void setCmpInscricaoMunicipal(String cmpInscricaoMunicipal) {
        this.cmpInscricaoMunicipal = cmpInscricaoMunicipal;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
