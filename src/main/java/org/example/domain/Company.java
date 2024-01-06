package org.example.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Author: Alexander Kuziv
 * Site: techmatrix18.com
 * Date: 2023-12-29
 */
@Entity
@Table(name = "companies", schema = "", catalog = "")
public class Company {
    private int id;
    private int channel_id;

    /*@ManyToOne(cascade = CascadeType.ALL) // fetch = FetchType.LAZY,
    //@JoinColumn(name="channel_id")
    @JoinTable(name = "channels")
    private ChannelEntity channel;
    public ChannelEntity getChannel() { return channel; }
    public void setChannel(ChannelEntity channel) { this.channel = channel; }*/

    private String title;
    private int count_views;
    private int speed_hour_from;
    private int speed_hour_to;
    private int count_last_posts;
    private int range_views_from;
    private int range_views_to;
    private int shift_start;
    private int count_days;
    private java.time.LocalDateTime start_from;
    private int only_subscribes; // 1 or 0
    private int have_break; // 1 or 0
    private String comments;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "channel_id", nullable = false, insertable = true, updatable = true)
    public int getChannelId() {
        return channel_id;
    }
    public void setChannelId(int channel_id) {
        this.channel_id = channel_id;
    }

    @Column(name = "title", nullable = false, insertable = true, updatable = true, length = 60)
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "count_views", nullable = false, insertable = true, updatable = true)
    public int getCountViews() { return count_views; }
    public void setCountViews(int count_views) { this.count_views = count_views; }

    @Column(name = "speed_hour_from", nullable = false, insertable = true, updatable = true)
    public int getSpeedHourFrom() {
        return speed_hour_from;
    }
    public void setSpeedHourFrom(int speed_hour_from) {
        this.speed_hour_from = speed_hour_from;
    }

    @Column(name = "speed_hour_to", nullable = false, insertable = true, updatable = true)
    public int getSpeedHourTo() {
        return speed_hour_to;
    }
    public void setSpeedHourTo(int speed_hour_to) {
        this.speed_hour_to = speed_hour_to;
    }

    @Column(name = "count_last_posts", nullable = false, insertable = true, updatable = true)
    public int getCountLastPosts() { return count_last_posts; }
    public void setCountLastPosts(int count_last_posts) { this.count_last_posts = count_last_posts; }

    @Column(name = "range_views_from", nullable = false, insertable = true, updatable = true)
    public int getRangeViewsFrom() { return range_views_from; }
    public void setRangeViewsFrom(int range_views_from) { this.range_views_from = range_views_from; }

    @Column(name = "range_views_to", nullable = false, insertable = true, updatable = true)
    public int getRangeViewsTo() { return range_views_to; }
    public void setRangeViewsTo(int range_views_to) { this.range_views_to = range_views_to; }

    @Column(name = "shift_start", nullable = true, insertable = true, updatable = true)
    public int getShiftStart() { return shift_start; }
    public void setShiftStart(int shift_start) { this.shift_start = shift_start; }

    @Column(name = "count_days", nullable = true, insertable = true, updatable = true)
    public int getCountDays() { return count_days; }
    public void setCountDays(int count_days) { this.count_days = count_days; }

    @Column(name = "start_from", nullable = false, insertable = true, updatable = true)
    public LocalDateTime getStartFrom() { return start_from; }
    public void setStartFrom(LocalDateTime start_from) { this.start_from = start_from; }

    @Column(name = "only_subscribes", nullable = false, insertable = true, updatable = true)
    public int getOnlySubscribes() { return only_subscribes; }
    public void setOnlySubscribes(int only_subscribes) { this.only_subscribes = only_subscribes; }

    @Column(name = "have_break", nullable = false, insertable = true, updatable = true)
    public int getHaveBreak() { return have_break; }
    public void setHaveBreak(int have_break) { this.have_break = have_break; }

    @Column(name = "comments", nullable = false, insertable = true, updatable = true, length = 500)
    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    java.time.LocalDate createdAt;
    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }
    public LocalDate getCreatedAt() {
        return createdAt;
    }

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false, columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    java.time.LocalDateTime updatedAt;
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Company that)) return false;
        return getId() == that.getId() && channel_id == that.channel_id && getCountViews() == that.getCountViews() && speed_hour_from == that.speed_hour_from && speed_hour_to == that.speed_hour_to && count_last_posts == that.count_last_posts && range_views_from == that.range_views_from && range_views_to == that.range_views_to && shift_start == that.shift_start && count_days == that.count_days && only_subscribes == that.only_subscribes && have_break == that.have_break && Objects.equals(getTitle(), that.getTitle()) && Objects.equals(start_from, that.start_from) && Objects.equals(getComments(), that.getComments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), channel_id, getTitle(), getCountViews(), speed_hour_from, speed_hour_to, count_last_posts, range_views_from, range_views_to, shift_start, count_days, start_from, only_subscribes, have_break, getComments());
    }

    @Override
    public String toString() {
        return "CompanyEntity {" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", channel_id='" + channel_id +
            ", count_views='" + count_views +
            ", speed_hour_from='" + speed_hour_from +
            ", speed_hour_to='" + speed_hour_to +
            ", count_last_posts='" + count_last_posts +
            ", range_views_from='" + range_views_from +
            ", range_views_to='" + range_views_to +
            ", shift_start='" + shift_start +
            ", count_days='" + count_days +
            ", start_from='" + start_from +
            ", only_subscribes='" + only_subscribes +
            ", have_break='" + have_break +
            ", comments='" + comments +
        '}';
    }
}

