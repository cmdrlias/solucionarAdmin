package com.solucionar.admin.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name="usr_code")
    private int usrCode;

    @Column(name="usr_name")
    private String usrName;

    @Column(name="usr_email")
    private String usrEmail;

    @Column(name="usr_password")
    private String usrPassword;

    @OneToOne
    @JoinColumn(name="ust_code")
    private UserType usrType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name="person_user",
            joinColumns={@JoinColumn(name="usr_code")},
            inverseJoinColumns={@JoinColumn(name="per_code")})
    private Person person;

    public User() { }

    public int getUsrCode() {
        return usrCode;
    }

    public void setUsrCode(int usrCode) {
        this.usrCode = usrCode;
    }

    public String getUsrEmail() {
        return usrEmail;
    }

    public void setUsrEmail(String usrEmail) {
        this.usrEmail = usrEmail;
    }

    public String getUsrPassword() {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }

    public UserType getUsrType() {
        return usrType;
    }

    public void setUsrType(UserType usrType) {
        this.usrType = usrType;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getUsrName() {
        return usrName;
    }

    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }
}
