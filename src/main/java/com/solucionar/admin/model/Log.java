package com.solucionar.admin.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@NamedQuery(name="Log.findAll", query="SELECT l FROM Log l")
public class Log implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    @Column(name="log_code")
    private int logCode;

    @Column(name="log_description")
    private String logDescription;

    @Column(name="CREATED_AT")
    private Date logCreatedAt;

    public Log() { }

    public int getLogCode() {
        return logCode;
    }

    public void setLogCode(int logCode) {
        this.logCode = logCode;
    }

    public String getLogDescription() {
        return logDescription;
    }

    public void setLogDescription(String logDescription) {
        this.logDescription = logDescription;
    }

    public Date getLogCreatedAt() {
        return logCreatedAt;
    }

    public void setLogCreatedAt(Date logCreatedAt) {
        this.logCreatedAt = logCreatedAt;
    }

    public String getLogString() {
        return logDescription + " - " + logCreatedAt;
    }
}
