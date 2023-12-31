package org.example.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Author: Alexander Kuziv
 * Site: techmatrix18.com
 * Date: 2023-12-29
 */
@Entity
@Table(name = "`channels`")
public class ChannelEntity {
    @Id
    //@GeneratedValue(strategy = IDENTITY)
    @GeneratedValue(strategy=GenerationType.AUTO)
    //@Column(name = "`id`", unique = true, nullable = false, insertable = true, updatable = true)
    private int id;

    @Column(name = "`title`", nullable = false, insertable = true, updatable = true, length = 255)
    private String title;

    @Column(name = "`descr`", nullable = true, insertable = true, updatable = true, length = 255)
    private String descr;

    // Если аннотация отсутствует, то в базе будет тип TIMESTAMP - старый способ
    //@Column(name = "created_at", nullable = false, insertable = false, updatable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    //Date dateAsTimestamp;

    //@Temporal(TemporalType.DATE) // будет замаплен на тип DATE - старый способ
    @Column(name = "created_at", nullable = false, insertable = false, updatable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    java.time.LocalDate createdAt;

    //@Temporal(TemporalType.TIME) // будет замаплен на тип TIME - старый способ
    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP") // columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP"
    java.time.LocalDateTime updatedAt; // java.time.LocalDateTime - новый способ

    /*@OneToMany(mappedBy="channels", cascade = CascadeType.ALL) // fetch = FetchType.LAZY,
    private Set<CompanyEntity> companies;
    public Set<CompanyEntity> getCompanies() { return companies; }
    public void setCompanies(Set<CompanyEntity> companies) { this.companies = companies; }*/

    public ChannelEntity(String title, String descr) {
        this.title = title;
        this.descr = descr;
    }

    public ChannelEntity(String title) {
        this.title = title;
    }

    public ChannelEntity() {
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    // for insert datetime from annotation
    /*public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }*/

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    // for insert and update datetime from annotation
    /*public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }*/

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescr() { return descr; }
    public void setDescr(String descr) { this.descr = descr; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChannelEntity that = (ChannelEntity) o;
        if (id != that.id) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (descr != null ? !descr.equals(that.descr) : that.descr != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
       // result = 31 * result + (descr != null ? descr.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ChannelEntity {" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", descr='" + descr +
        '}';
    }
}

