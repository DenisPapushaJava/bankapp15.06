package com.example.bankapp.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "operation")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Operation() {
    }

    public Operation(User userFrom, Category category) {
        this.userFrom = userFrom;
        this.category = category;
        this.date = LocalDateTime.now();
    }

    public Operation(User userFrom, Double cash, Category category) {
        this.userFrom = userFrom;
        this.cash = cash;
        this.category = category;
        this.date = LocalDateTime.now();
    }

    public Operation(User userFrom, User userTo, Double cash, Category category) {
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.cash = cash;
        this.category = category;
        this.date = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(User userFrom) {
        this.userFrom = userFrom;
    }

    public User getUserTo() {
        return userTo;
    }

    public void setUserTo(User userTo) {
        this.userTo = userTo;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @OneToOne
    private User userFrom;
    @OneToOne
    private User userTo;

    private Double cash;
    private LocalDateTime date;
    @Enumerated(value = EnumType.STRING)
    @OneToOne
    private Category category;
}