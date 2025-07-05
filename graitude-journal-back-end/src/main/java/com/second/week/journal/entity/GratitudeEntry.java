package com.second.week.journal.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "entry")
public class GratitudeEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length =1000)
    private String content;

    @Column(name = "created_at",updatable = false)
    private LocalDateTime createdAt =  LocalDateTime.now();

    public GratitudeEntry(Long id, String content, LocalDateTime createdAt) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
    }

    public GratitudeEntry() {
    }

    public GratitudeEntry(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "GratitudeEntry{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

}
