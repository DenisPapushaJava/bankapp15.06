package com.example.bankapp.models;

import javax.persistence.*;

@Entity
@Table(name = "category")
public enum Category {
    TRANSFER,
    BALANCE,
    HISTORY;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
