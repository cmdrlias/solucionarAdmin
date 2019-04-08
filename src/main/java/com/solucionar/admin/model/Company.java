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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="company_representative",
            joinColumns={@JoinColumn(name="cmp_code")},
            inverseJoinColumns={@JoinColumn(name="rep_code")})
    private List<Representative> representatives;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="company_phone",
            joinColumns={@JoinColumn(name="cmp_code")},
            inverseJoinColumns={@JoinColumn(name="pho_code")})
    private List<Phone> phones;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="company_address",
            joinColumns={@JoinColumn(name="cmp_code")},
            inverseJoinColumns={@JoinColumn(name="add_code")})
    private List<Address> addresses;

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

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public List<Representative> getRepresentatives() {
        return representatives;
    }

    public void setRepresentatives(List<Representative> representatives) {
        this.representatives = representatives;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
