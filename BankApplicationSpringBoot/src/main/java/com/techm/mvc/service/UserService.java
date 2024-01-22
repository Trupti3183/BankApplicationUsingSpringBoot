package com.techm.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techm.mvc.model.Account;
import com.techm.mvc.model.User;
import com.techm.mvc.repository.AccountRepository;
import com.techm.mvc.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    public User createUser(User user) {
      
        // Save the user, including the associated account
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) throws Exception {
        // Check if the provided ID is null
        if (userId == null) {
            throw new IllegalArgumentException("User ID must not be null");
        }

        // Rest of your existing logic to retrieve the user
        Optional<User> optionalUser = userRepository.findById(userId);

        // Check if the user is present in the optional, otherwise throw an exception
        return optionalUser.orElseThrow(() -> new Exception("User not found with ID: " + userId));
    }
    public User updateUser(Long userId, User updatedUser) {
        User existingUser = userRepository.findById(userId).orElse(null);

        if (existingUser != null) {
            existingUser.setName(updatedUser.getName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setPassword(updatedUser.getPassword());
            existingUser.setMobileNumber(updatedUser.getMobileNumber());
            existingUser.setAddress(updatedUser.getAddress());
            existingUser.setGovtId(updatedUser.getGovtId());

            return userRepository.save(existingUser);
        }

        return null;
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

   
    public User getCurrentUser(HttpSession session) {
        if (session != null) {
            // Assume you have stored the user in the session during login
            return (User) session.getAttribute("loginUser");
        }

        return null;
    }
	public void saveUser(User user) {
        // Save the User
        User savedUser = userRepository.save(user);

        // Check if the User has an associated Account
        if (savedUser.getAccount() != null) {
            // Set the User for the associated Account
            savedUser.getAccount().setUser(savedUser);

            // Save the associated Account using AccountRepository
            accountRepository.save(savedUser.getAccount());
        }
    }

	 public User getAccountByUserId(Long userId) throws Exception {
	        // Add a null check before calling findById
	        if (userId != null) {
	            Optional<User> userOptional = userRepository.findById(userId);
	            if (userOptional.isPresent()) {
	                return userOptional.get();
	            } else {
	                // Handle the case where the user is not found
	                throw new Exception("User not found with ID: " + userId);
	            }
	        } else {
	            // Handle the case where the user ID is null
	            throw new IllegalArgumentException("User ID must not be null");
	        }
	    }
}
