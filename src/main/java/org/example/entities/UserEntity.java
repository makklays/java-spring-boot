package org.example.entities;

import org.hibernate.Session;
import org.hibernate.mapping.List;
import java.util.Objects;
import javax.persistence.*;
//import java.util.Date;

/**
 * Author: Alexander Kuziv
 * Site: techmatrix18.com
 * Date: 2023-12-29
 */
@Entity
@Table(name="users", schema = "", catalog = "demo-spring-boot")
public class UserEntity {
    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    private int id;
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    @Basic
    @Column(name = "login", nullable = false, insertable = true, updatable = true, length = 60)
    private String login;
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    @Basic
    @Column(name = "firstname", nullable = false, insertable = true, updatable = true, length = 60)
    private String firstname;
    public String getFirstname() { return firstname; }
    public void setFirstname(String firstname) { this.firstname = firstname; }

    @Basic
    @Column(name = "lastname", nullable = false, insertable = true, updatable = true, length = 60)
    private String lastname;
    public String getLastname() { return lastname; }
    public void setLastname(String lastname) { this.lastname = lastname; }

    @Basic
    @Column(name = "password", nullable = false, insertable = true, updatable = true, length = 60)
    private String password;
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    @Basic
    @Column(name = "gender", nullable = false, insertable = true, updatable = true, length = 60)
    private String gender;
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    @Basic
    @Column(name = "phone", nullable = false, insertable = true, updatable = true, length = 60)
    private String phone;
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    @Basic
    @Column(name = "email", nullable = false, insertable = true, updatable = true, length = 60)
    private String email;
    public String getEmail() { return email; }
    public void setEmail(String email) { this.city = email; }

    @Basic
    @Column(name = "city", nullable = false, insertable = true, updatable = true, length = 60)
    private String city;
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    @Basic
    @Column(name = "auth_at", nullable = false, insertable = true, updatable = true, length = 60)
    private String auth_at;
    public String getAuthAt() { return auth_at; }
    public void setAuthAt(String auth_at) { this.auth_at = auth_at; }

    @Basic
    @Column(name = "code", nullable = true, insertable = true, updatable = true, length = 25)
    private String code;
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    @Basic
    @Column(name = "created_at", nullable = false, insertable = true, updatable = true, length = 20)
    private String created_at;
    public String getCreatedAt() { return created_at; }
    public void setCreatedAt(String created_at) { this.created_at = created_at; }

    @Basic
    @Column(name = "updated_at", nullable = false, insertable = true, updatable = true, length = 20)
    private String updated_at;
    public String getUpdatedAt() { return updated_at; }
    public void setUpdatedAt(String updated_at) { this.updated_at = updated_at; };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        //UsersEntity that = (UsersEntity) o;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
       // result = 31 * result + (id > 0 ? id.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (auth_at != null ? auth_at.hashCode() : 0);
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (created_at != null ? created_at.hashCode() : 0);
        result = 31 * result + (updated_at != null ? updated_at.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "UserEntity {" +
            "id=" + id +
            ", login='" + login + '\'' +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            ", password='" + password + '\'' +
            ", gender='" + gender + '\'' +
            ", phone='" + phone + '\'' +
            ", email='" + email + '\'' +
            ", city='" + city + '\'' +
            ", auth_at='" + auth_at + '\'' +
            ", code='" + code + '\'' +
            ", created_at='" + created_at + '\'' +
            ", updated_at=" + updated_at +
        '}';
    }
}

