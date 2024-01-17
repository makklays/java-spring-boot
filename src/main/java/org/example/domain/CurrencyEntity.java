package org.example.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Class: CurrencyEntity
 * Description: `This class is entity and use for have rate entre something currency and UAH.`
 *
 * Author: Alexander Kuziv
 *   Site: techmatrix18.com
 *   Date: 2023-01-05
 */
@Entity
@Table(name = "`currencies`")
public class CurrencyEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name = "`r030`", nullable = true, insertable = true, updatable = true, length = 255)
    private String r030;

    @Column(name = "`txt`", nullable = false, insertable = true, updatable = true, length = 255)
    private String txt;

    @Column(name = "`rate`", nullable = true, insertable = true, updatable = true, length = 255)
    private String rate;

    @Column(name = "`cc`", nullable = false, insertable = true, updatable = true, length = 10)
    private String cc;

    @Column(name = "exchangedate", nullable = false, insertable = true, updatable = true, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP") // columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP"
    java.time.LocalDate exchangedate;

    @Column(name = "`ip`", nullable = true, insertable = true, updatable = true, length = 21)
    private String ip;

    public int getId() { return id; }
    public void setId(int id) {
        this.id = id;
    }

    public String getR030() {
        return r030;
    }
    public void setR030(String r030) {
        this.r030 = r030;
    }

    public String getTxt() {
        return txt;
    }
    public void setTxt(String txt) {
        this.txt = txt;
    }

    public String getRate() {
        return rate;
    }
    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getCc() {
        return cc;
    }
    public void setCc(String cc) {
        this.cc = cc;
    }

    public LocalDate getExchangedate() {
        return exchangedate;
    }
    // for insert and update datetime from annotation
    public void setExchangedate(LocalDate exchangedate) {
        this.exchangedate = exchangedate;
    }

    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CurrencyEntity that)) return false;
        return getId() == that.getId() && getR030().equals(that.getR030()) && getTxt().equals(that.getTxt()) && getRate().equals(that.getRate()) && getCc().equals(that.getCc()) && getExchangedate().equals(that.getExchangedate()) && getIp().equals(that.getIp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getR030(), getTxt(), getRate(), getCc(), getExchangedate(), getIp());
    }

    @Override
    public String toString() {
        return "CurrencyEntity {" +
                "id=" + id +
                ", r030='" + r030 + "'" +
                ", txt='" + txt + "'" +
                ", rate='" + rate + "'" +
                ", cc='" + cc + "'" +
                ", exchangedate='" + exchangedate +
                ", ip='" + ip +
                "'}";
    }
}

