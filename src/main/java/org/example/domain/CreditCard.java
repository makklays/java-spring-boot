package org.example.domain;

import javax.persistence.*;
import java.util.Objects;
//import java.util.Date;

/**
 * Author: Alexander Kuziv
 * Site: techmatrix18.com
 * Date: 2023-12-29
 */
@Entity
@Table(name = "creditcards", schema = "", catalog = "")
public class CreditCard {
    private int id;
    private int account;
    private String bank;
    private String firstname;
    private String lastname;
    private Float amount;
    private String currency;
    private int fromaccount;
    private String phone;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "account", nullable = false, insertable = true, updatable = true)
    public int getAccount() {
        return account;
    }
    public void setAccount(int account) {
        this.account = account;
    }

    @Basic
    @Column(name = "bank", nullable = true, insertable = true, updatable = true, length = 60)
    public String getBank() {
        return bank;
    }
    public void setBank(String bank) {
        this.bank = bank;
    }

    @Basic
    @Column(name = "firstname", nullable = true, insertable = true, updatable = true, length = 25)
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname", nullable = true, insertable = true, updatable = true, length = 25)
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "amount", nullable = false, insertable = true, updatable = true)
    public Float getAmount() {
        return amount;
    }
    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "currency", nullable = false, insertable = true, updatable = true, length = 5)
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Basic
    @Column(name = "fromaccount", nullable = false, insertable = true, updatable = true)
    public int getFromaccount() {
        return fromaccount;
    }
    public void setFromaccount(int fromaccount) {
        this.fromaccount = fromaccount;
    }

    @Basic
    @Column(name = "phone", nullable = true, insertable = true, updatable = true, length = 12)
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard that = (CreditCard) o;
        if (!Objects.equals(id, that.id)) return false;
        if (account != that.account) return false;
        if (!Objects.equals(bank, that.bank)) return false;
        if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
        if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
        if (amount > 0 ? !amount.equals(that.amount) : that.amount != null) return false;
        if (currency != null ? !currency.equals(that.currency) : that.currency != null) return false;
        if (fromaccount != that.fromaccount) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
       // result = 31 * result + (account > 0 ? account.hashCode() : 0);
        result = 31 * result + (bank != null ? bank.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
       // result = 31 * result + (fromaccount > 0 ? fromaccount.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "CreditCardEntity {" +
            "id=" + id +
            ", account='" + account + '\'' +
            ", bank='" + bank +
            ", firstname='" + firstname +
            ", lastname='" + lastname +
            ", amount='" + amount +
            ", currency='" + currency +
            ", fromaccount='" + fromaccount +
            ", phone='" + phone +
        '}';
    }
}

