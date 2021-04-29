package com.readysoft.personalwallet.model;


import javax.persistence.*;

@Entity
@Table(name = "odeme_kategori")
public class PaymentCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "aciklama")
    private String description;

    public PaymentCategory() {
    }

    public PaymentCategory(int id, String description) {
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
