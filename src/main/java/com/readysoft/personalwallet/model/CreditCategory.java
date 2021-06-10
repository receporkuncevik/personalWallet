package com.readysoft.personalwallet.model;

import javax.persistence.*;

@Entity
@Table(name="kredi_kategori")
public class CreditCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="aciklama")
    private String description;

    public CreditCategory() {
    }

    public CreditCategory(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
