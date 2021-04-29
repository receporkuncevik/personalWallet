package com.readysoft.personalwallet.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "odemeler")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="kategori_id")
    private PaymentCategory category;

    @ManyToOne
    @JoinColumn(name="kullanici_id")
    private User user;

    @Column(name="aciklama")
    private String description;
    @Column(name="tarih")
    private Date buyingDate;
    @Column(name="odeme_tipi")
    private String paymentType;
    @Column(name="miktar")
    private int amount;
    @Column(name="sonlanma_tarihi")
    private Date endingDate;

    public Payment() {
    }

    public Payment(int id, PaymentCategory category, User user, String description, Date buyingDate, String paymentType, int amount, Date endingDate) {
        this.id = id;
        this.category = category;
        this.user = user;
        this.description = description;
        this.buyingDate = buyingDate;
        this.paymentType = paymentType;
        this.amount = amount;
        this.endingDate = endingDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PaymentCategory getCategory() {
        return category;
    }

    public void setCategory(PaymentCategory category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getBuyingDate() {
        return buyingDate;
    }

    public void setBuyingDate(Date buyingDate) {
        this.buyingDate = buyingDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }
}
