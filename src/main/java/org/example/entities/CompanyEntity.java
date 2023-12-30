package org.example.entities;

import javax.persistence.*;
import java.util.Objects;

/**
 * Author: Alexander Kuziv
 * Site: techmatrix18.com
 * Date: 2023-12-29
 */
@Entity
@Table(name = "companies", schema = "", catalog = "demo-spring-boot")
public class CompanyEntity {
    private Long id;
    private Long channel_id;

    /*@ManyToOne(cascade = CascadeType.ALL) // fetch = FetchType.LAZY,
    //@JoinColumn(name="channel_id")
    @JoinTable(name = "channels")
    private ChannelEntity channel;
    public ChannelEntity getChannel() { return channel; }
    public void setChannel(ChannelEntity channel) { this.channel = channel; }*/

    private String title;
    private int count_subscribe;
    private int speed_hour_from;
    private int speed_hour_to;
    private int is_views;
    private int procent_off;
    private String start_from;
    private String comments;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "channel_id", nullable = false, insertable = true, updatable = true)
    public Long getChannelId() {
        return channel_id;
    }
    public void setChannelId(Long channel_id) {
        this.channel_id = channel_id;
    }

    @Basic
    @Column(name = "title", nullable = false, insertable = true, updatable = true, length = 60)
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "count_subscribe", nullable = false, insertable = true, updatable = true)
    public int getCountSubscribe() {
        return count_subscribe;
    }
    public void setCountSubscribe(int count_subscribe) {
        this.count_subscribe = count_subscribe;
    }

    @Basic
    @Column(name = "speed_hour_from", nullable = false, insertable = true, updatable = true)
    public int getSpeedHourFrom() {
        return speed_hour_from;
    }
    public void setSpeedHourFrom(int speed_hour_from) {
        this.speed_hour_from = speed_hour_from;
    }

    @Basic
    @Column(name = "speed_hour_to", nullable = false, insertable = true, updatable = true)
    public int getSpeedHourTo() {
        return speed_hour_to;
    }
    public void setSpeedHourTo(int speed_hour_to) {
        this.speed_hour_to = speed_hour_to;
    }

    @Basic
    @Column(name = "is_views", nullable = false, insertable = true, updatable = true)
    public int getIsViews() {
        return is_views;
    }
    public void setIsViews(int is_views) {
        this.is_views = is_views;
    }

    @Basic
    @Column(name = "procent_off", nullable = false, insertable = true, updatable = true)
    public int getProcentOff() {
        return procent_off;
    }
    public void setProcentOff(int procent_off) {
        this.procent_off = procent_off;
    }

    @Basic
    @Column(name = "start_from", nullable = false, insertable = true, updatable = true, length = 25)
    public String getStartFrom() {
        return start_from;
    }
    public void setStartFrom(String start_from) {
        this.start_from = start_from;
    }

    @Basic
    @Column(name = "comments", nullable = false, insertable = true, updatable = true, length = 500)
    public String getComments() {
        return comments;
    }
    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyEntity that = (CompanyEntity) o;
        if (id != that.id) return false;
        if (channel_id != that.channel_id) return false;
        if (!Objects.equals(title, that.title)) return false;
        if (count_subscribe != that.count_subscribe) return false;
        if (speed_hour_from != that.speed_hour_from) return false;
        if (speed_hour_to != that.speed_hour_to) return false;
        if (is_views != that.is_views) return false;
        if (procent_off != that.procent_off) return false;
        if (start_from != null ? !start_from.equals(that.start_from) : that.start_from != null) return false;
        if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (channel_id > 0 ? channel_id.hashCode() : 0);
       // result = 31 * result + (count_subscribe > 0 ? count_subscribe.hashCode() : 0);
       // result = 31 * result + (speed_hour_from > 0 ? speed_hour_from.hashCode() : 0);
       // result = 31 * result + (speed_hour_to > 0 ? speed_hour_to.hashCode() : 0);
       // result = 31 * result + (is_views > 0 ? is_views.hashCode() : 0);
       // result = 31 * result + (procent_off > 0 ? procent_off.hashCode() : 0);
        result = 31 * result + (start_from != null ? start_from.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CompanyEntity {" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", channel_id='" + channel_id +
            ", count_subscribe='" + count_subscribe +
            ", speed_hour_from='" + speed_hour_from +
            ", speed_hour_to='" + speed_hour_to +
            ", is_views='" + is_views +
            ", procent_off='" + procent_off +
            ", start_from='" + start_from +
            ", comments='" + comments +
        '}';
    }
}

