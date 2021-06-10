package com.readysoft.personalwallet.repository;


import com.readysoft.personalwallet.model.Budget;
import com.readysoft.personalwallet.model.Payment;
import com.readysoft.personalwallet.model.PaymentCategory;
import com.readysoft.personalwallet.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class PaymentRepositoryTest {

    private PaymentRepository paymentRepository;
    private UserRepository userRepository;
    private PaymentCategoryRepository paymentCategoryRepository;

    @Autowired
    public PaymentRepositoryTest(PaymentRepository paymentRepository, UserRepository userRepository, PaymentCategoryRepository paymentCategoryRepository) {
        this.paymentRepository = paymentRepository;
        this.userRepository = userRepository;
        this.paymentCategoryRepository = paymentCategoryRepository;
    }

    @Test
    public void testCreatePayment() throws ParseException {
        User registeredUser = userRepository.findByUserName("receporkun");
        PaymentCategory paymentCategory = paymentCategoryRepository.findById(5).get();

        String startingDate = "2021-05-28";

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date startDateInDateType = formatter.parse(startingDate);

        Payment payment = new Payment();
        payment.setUser(registeredUser);
        payment.setCategory(paymentCategory);
        payment.setAmount(37);
        payment.setPaymentType("Nakit");
        payment.setDescription("Netflix Ödemesi");
        payment.setBuyingDate(startDateInDateType);
        payment.setPlannedPayment(true);
        Payment savedPayment = paymentRepository.save(payment);
        assertNotNull(savedPayment);
    }

    @Test
    public void testUpdatePayment(){
        int newAmount = 93;
        Payment payment = paymentRepository.findById(39).get();
        payment.setAmount(newAmount);

        Payment updatedPayment = paymentRepository.save(payment);
        assertNotNull(updatedPayment);
    }

    @Test
    public void testListPayment(){
        User registeredUser = userRepository.findByUserName("receporkun");
        List<Payment> paymentList = paymentRepository.getAllPaymentWithUserId(registeredUser.getId());

        for (Payment payment: paymentList){
            System.out.println(payment.getDescription() + " " + payment.getPaymentType() + " " + payment.getCategory().getDescription() + " " + payment.getBuyingDate() + " tarihinde  " + payment.getAmount() + " fiyata satın alındı.");
        }

        assertThat(paymentList).size().isGreaterThan(0);
    }

    @Test
    public void testPlannedPaymentList(){
        User registeredUser = userRepository.findByUserName("receporkun");
        List<Payment> paymentList = paymentRepository.getAllPlannedPaymentWihtUserId(registeredUser.getId());

        for (Payment payment: paymentList){
            System.out.println(payment.isPlannedPayment());
        }

        assertThat(paymentList).size().isGreaterThan(0);
    }


    @Test
    public void testDeletePayment(){
        Integer deletedBudget = 39;
        boolean isExistBeforeDelete = paymentRepository.findById(deletedBudget).isPresent();
        paymentRepository.deleteById(deletedBudget);
        boolean notExistAfterDelete = paymentRepository.findById(deletedBudget).isPresent();

        assertTrue(isExistBeforeDelete);
        assertFalse(notExistAfterDelete);

    }

    @Test
    public void testGetByCategory(){

        int sum=0;
        for (Payment payment: paymentRepository.getByCategory(2)){
            sum += payment.getAmount();
            System.out.println(payment.getCategory().getDescription() + " " + payment.getDescription());
        }
        System.out.println("Bu Kategorideki Alışveriş Toplam Tutarı: "+ sum);


    }

}
