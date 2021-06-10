package com.readysoft.personalwallet.model;

import javax.persistence.*;

@Entity
@Table(name="banka_hesaplar")
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="kullanici_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="banka_id")
    private Bank bank;

    @Column(name = "iban_numarasi")
    private String ibanNo;

    @Column(name = "musteri_numarasi")
    private String customerNumber;

    public BankAccount() {
    }

    public BankAccount(int id, User user, Bank bank, String ibanNo, String customerNumber) {
        this.id = id;
        this.user = user;
        this.bank = bank;
        this.ibanNo = ibanNo;
        this.customerNumber = customerNumber;
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

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public String getIbanNo() {
        return ibanNo;
    }

    public void setIbanNo(String ibanNo) {
        this.ibanNo = ibanNo;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }
}
