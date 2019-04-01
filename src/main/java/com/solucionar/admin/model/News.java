package com.solucionar.admin.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="news")
@NamedQuery(name="News.findAll", query="SELECT n FROM News n")
public class News implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name="nws_code")
    private int nwsCode;

    @Column(name="nws_description")
    private String nwsDescription;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATED_AT")
    private Date nwsCreatedAt;

    @OneToOne
    @JoinColumn(name="usr_code")
    private User user;

    public News() { }

    public int getNwsCode() {
        return nwsCode;
    }

    public void setNwsCode(int nwsCode) {
        this.nwsCode = nwsCode;
    }

    public String getNwsDescription() {
        return nwsDescription;
    }

    public void setNwsDescription(String nwsDescription) {
        this.nwsDescription = nwsDescription;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getNwsCreatedAt() {
        return nwsCreatedAt;
    }

    public void setNwsCreatedAt(Date nwsCreatedAt) {
        this.nwsCreatedAt = nwsCreatedAt;
    }
}
