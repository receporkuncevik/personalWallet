package com.readysoft.personalwallet.model;

import javax.persistence.*;
@Entity
@Table(name="krediler")
public class Credit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name="kategori_id")
    private CreditCategory creditCategory;

    /*@OneToOne
    @JoinColumn(name="banka_id")
    private Bank bank;*/

    @ManyToOne
    @JoinColumn(name="kullanici_id")
    private User user;

    @Column(name="aciklama")
    private String description;

    @Column(name="odeme_plani")
    private String paymentPlan;

    @Column(name="cekilen_miktar")
    private int amountReceived;

    public Credit() {
    }

    public Credit(int id, CreditCategory creditCategory /*Bank bank*/, User user, String description, String paymentPlan, int amountReceived) {
        this.id = id;
        this.creditCategory = creditCategory;
        /*this.bank = bank;*/
        this.user = user;
        this.description = description;
        this.paymentPlan = paymentPlan;
        this.amountReceived = amountReceived;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CreditCategory getCreditCategory() {
        return creditCategory;
    }

    public void setCreditCategory(CreditCategory creditCategory) {
        this.creditCategory = creditCategory;
    }

    /*public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }*/

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

    public String getPaymentPlan() {
        return paymentPlan;
    }

    public void setPaymentPlan(String paymentPlan) {
        this.paymentPlan = paymentPlan;
    }

    public int getAmountReceived() {
        return amountReceived;
    }

    public void setAmountReceived(int amountReceived) {
        this.amountReceived = amountReceived;
    }
}
