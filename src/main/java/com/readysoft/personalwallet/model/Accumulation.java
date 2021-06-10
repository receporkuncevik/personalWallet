package com.readysoft.personalwallet.model;

import javax.persistence.*;

@Entity
@Table(name="birikimler")
public class Accumulation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="kullanici_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="kategori_id")
    private AccumulationCategory accumulationCategory;

    @Column(name="aciklama")
    private String descripion;

    @Column(name="miktar")
    private int amount;

    public Accumulation() {
    }

    public Accumulation(int id, User user, AccumulationCategory accumulationCategory, String descripion, int amount) {
        this.id = id;
        this.user = user;
        this.accumulationCategory = accumulationCategory;
        this.descripion = descripion;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AccumulationCategory getAccumulationCategory() {
        return accumulationCategory;
    }

    public void setAccumulationCategory(AccumulationCategory accumulationCategory) {
        this.accumulationCategory = accumulationCategory;
    }

    public String getDescripion() {
        return descripion;
    }

    public void setDescripion(String descripion) {
        this.descripion = descripion;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
