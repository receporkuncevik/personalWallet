package com.readysoft.personalwallet.repository;

import com.readysoft.personalwallet.model.Budget;
import com.readysoft.personalwallet.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class BudgetRepositoryTest {

    @Autowired
    private BudgetRepository budgetRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreateBudget() throws ParseException {
        User registeredUser = userRepository.findByUserName("receporkun");

        String startingDate = "2021-05-06";
        String endingDate = "2021-06-07";

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date startDateInDateType = formatter.parse(startingDate);
        Date endDateInDateType = formatter.parse(endingDate);


        Budget budget = new Budget();
        budget.setUser(registeredUser);
        budget.setStartingDate(startDateInDateType);
        budget.setExpirationDate(endDateInDateType);
        budget.setAmount(100);

        Budget savedBudget = budgetRepository.save(budget);
        assertNotNull(savedBudget);
    }

    @Test
    public void testUpdateBudget(){
        int newAmount = 7500;
        Budget budget = budgetRepository.getOne(24);
        budget.setAmount(newAmount);

        Budget updatedBudget = budgetRepository.save(budget);
        assertNotNull(updatedBudget);
    }

    @Test
    public void testListBudgets(){
        User registeredUser = userRepository.findByUserName("receporkun");
        List<Budget> budgetList = budgetRepository.getAllBudgetFromId(registeredUser.getId());

        for (Budget budget: budgetList){
            System.out.println("Kullanıcı: " + budget.getUser().getFirstName() + " Başlangıç Tarihi: " + budget.getStartingDate() + " Bitiş Tarihi: " + budget.getExpirationDate() + " Bütçe: " + budget.getAmount());
        }

        assertThat(budgetList).size().isGreaterThan(0);
    }

    @Test
    public void testDeleteBudget(){
        Integer deletedBudget = 24;
        boolean isExistBeforeDelete = budgetRepository.findById(deletedBudget).isPresent();
        budgetRepository.deleteById(deletedBudget);
        boolean notExistAfterDelete = budgetRepository.findById(deletedBudget).isPresent();

        assertTrue(isExistBeforeDelete);
        assertFalse(notExistAfterDelete);


    }

}