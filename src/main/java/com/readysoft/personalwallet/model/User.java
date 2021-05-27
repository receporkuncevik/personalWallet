package com.readysoft.personalwallet.model;

import com.readysoft.personalwallet.utilities.mail.EmailService;
import com.readysoft.personalwallet.utilities.observer.Observer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "kullanicilar")
public class User implements Observer{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "adi")
    private String firstName;
    @Column(name = "soyadi")
    private String lastName;
    @Column(name = "kullanici_adi")
    private String userName;
    @Column(name = "sifre")
    private String password;
    @Column(name = "aktif")
    private boolean state = true;

    public User() {
    }

    public User(int id, String firstName, String lastName, String userName, String password, boolean state) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public void update() {
        Logger logger = LoggerFactory.getLogger(User.class);
        logger.warn("Yaklaşan Ödemeleriniz Var.");
    }
}
