package com.techm.mvc.service;

import com.techm.mvc.model.Account;
import com.techm.mvc.model.User;
import com.techm.mvc.repository.AccountRepository;
import com.techm.mvc.repository.UserRepository;

import jakarta.transaction.Transactional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    public void deposit(User user, double amount) {
        // Retrieve user's account information
        Account account = accountRepository.findByUser_Id(user.getId());

        // Update the account balance using BigDecimal operations
        double currentBalance = account.getBalance();
        double newBalance = currentBalance + amount;
        account.setBalance(newBalance);

        // Save the updated account information
        accountRepository.save(account);

        // You might want to add transaction logging or other logic here
    }


    @Transactional
    public void withdraw(User user, double withdrawalAmount) throws Exception {
        double currentBalance = user.getAccount().getBalance();

        if (currentBalance >= withdrawalAmount) {
            // Sufficient balance for withdrawal
            double updatedBalance = currentBalance - withdrawalAmount;
            user.getAccount().setBalance(updatedBalance);

            // Save the updated user (assuming you have a method in the repository to save/update users)
            userRepository.save(user);
        } else {
            // Insufficient balance for withdrawal
            throw new Exception("Insufficient balance for withdrawal");
        }
    }

}
