package com.techm.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techm.mvc.model.Account;
import com.techm.mvc.model.TransactionDTO;
import com.techm.mvc.model.User;
import com.techm.mvc.repository.AccountRepository;
import com.techm.mvc.repository.UserRepository;
import com.techm.mvc.service.AccountService;
import com.techm.mvc.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountService accountService;

	/*
	 * @GetMapping("/dashboard") public String showAccountDashboard(Model model,
	 * HttpSession session) { // Retrieve user information from session using the
	 * UserService User user = userService.getCurrentUser(session);
	 * 
	 * // Null check if (user != null) { // Retrieve user's account information
	 * using the user_id Account account =
	 * accountRepository.findByUser_Id(user.getId());
	 * 
	 * // Add account details to the model model.addAttribute("account", account); }
	 * 
	 * return "user/dashboard"; }
	 */


    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        List<Account> accounts = accountRepository.findAll(); // Assuming you fetch accounts from a repository
        model.addAttribute("accounts", accounts);
        return "user/dashboard";
    }

    @GetMapping("/deposit")
    public String showDepositForm(Model model) {
        model.addAttribute("transactionType", "Deposit");
        model.addAttribute("transaction", new TransactionDTO());
        return "user/depositform";
    }
    @PostMapping("/deposit")
    public String deposit(@RequestParam("amount") Double amount, HttpServletRequest request) {
        HttpSession session = request.getSession();

        // Retrieve userId from the session
        Long userId = (Long) session.getAttribute("userId");

        if (userId != null) {
            // Fetch the user from the database using the userId
            User user = userRepository.findById(userId).orElse(null);

            if (user != null) {
                // Perform the deposit operation using the user object
                // For example, updating the user's account balance
                Account account = user.getAccount();

                if (account != null) {
                    // Update the account balance
                    accountService.deposit(user, amount);

                    // Save the updated account
                    accountRepository.save(account);

                    // Redirect to a success page
                    return "redirect:/cust/home?success=Successfull";
                } else {
                    // Handle the case where the user's account is not found
                    return "redirect:/cust/home?error=AccountNotFound";
                }
            } else {
                // Handle the case where the user is not found
                return "redirect:/cust/home?error=UserNotFound";
            }
        } else {
            // Handle the case where userId is not found in the session
            return "redirect:/cust/login";
        }
    }


	
    @GetMapping("/withdraw")
    public String showWithdrawForm(Model model) {
        model.addAttribute("transactionType", "Withdraw");
        model.addAttribute("transaction", new TransactionDTO());
        return "user/withdraw"; // Assuming "user/withdrawform" is the correct Thymeleaf template path
    }
    @PostMapping("/withdraw")
    public String withdraw(@ModelAttribute("transaction") TransactionDTO transaction,
                           Model model, HttpSession session) throws Exception {
        Long userId = (Long) session.getAttribute("userId");

        User user = userService.getUserById(userId);

        if (user != null) {
            double withdrawalAmount = transaction.getAmount();

            try {
                accountService.withdraw(user, withdrawalAmount);
                model.addAttribute("successMessage", "Withdrawal successful!");
                return "redirect:/cust/home?success=Successfull"; // Return the success view
            } catch (Exception e) {
                model.addAttribute("errorMessage", "Insufficient balance for withdrawal");
                return "error"; // Return the error view
            }
        } else {
            model.addAttribute("errorMessage", "User not found");
            return "error"; // Return the error view
        }
    }
    
    @GetMapping("/details")
    public String showDetail(Model model, HttpSession session) {
        // Retrieve userId from the session
        Long userId = (Long) session.getAttribute("userId");

        if (userId != null) {
            Account account = accountRepository.findByUser_Id(userId);

            if (account != null) {
                model.addAttribute("account", account);
                return "user/showDetails";
            } else {
                // Handle the case where the account is not found
                return "user/error";
            }
        } else {
            // Handle the case where userId is not found in the session
            return "redirect:/cust/login";
        }
    }

    @GetMapping("/balance")
    public String checkBalance(Model model, HttpSession session) {
        // Retrieve userId from the session
        Long userId = (Long) session.getAttribute("userId");

        if (userId != null) {
            Account account = accountRepository.findByUser_Id(userId);

            if (account != null) {
                model.addAttribute("account", account);
                return "user/dashboard";
            } else {
                // Handle the case where the account is not found
                return "user/error";
            }
        } else {
            // Handle the case where userId is not found in the session
            return "redirect:/cust/login";
        }
    }
   
}
