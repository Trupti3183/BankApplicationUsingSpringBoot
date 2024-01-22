package com.techm.mvc.controller;

import com.techm.mvc.model.Account;
import com.techm.mvc.model.Contact;
import com.techm.mvc.model.User;
import com.techm.mvc.repository.AccountRepository;
import com.techm.mvc.repository.ContactRepository;
import com.techm.mvc.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//UserController.java
@Controller
@RequestMapping("/cust")
public class UserController {

 @Autowired
 private UserRepository userRepository;

 @Autowired
 private AccountRepository accountRepository;
 
 private ContactRepository contactRepository;
 
 
 @GetMapping
 public String showMainPage() {
     return "user/MainPage";
 }
 @GetMapping("/register")
 public String createUserForm(Model model) {
     model.addAttribute("user", new User());
     model.addAttribute("account", new Account());
     return "user/register";
 }

 @PostMapping("/register")
 public String createUser(@ModelAttribute User user, @ModelAttribute Account account) {
     userRepository.save(user);
     accountRepository.save(account);
     return "redirect:/cust/login";
 }

 @GetMapping("/login")
 public String showLoginForm(Model model, HttpServletRequest request) {
     User user = new User();
     model.addAttribute("user", user);
     return "user/login";
 }

 @PostMapping("/login")
 public String loginForm(@ModelAttribute User loginUser, HttpServletRequest request) {
     User user = userRepository.findByEmailAndPassword(loginUser.getEmail(), loginUser.getPassword());

     if (user != null) {
         // Store only the user ID in the session
         request.getSession().setAttribute("userId", user.getId());
         return "user/home";
     } else {
         // Handle login failure
         return "redirect:/cust/login?error";
     }
 }
 @GetMapping("/logout")
 public String logout(HttpServletRequest request, HttpServletResponse response) {
     // Perform logout actions
     HttpSession session = request.getSession(false);
     if (session != null) {
         session.invalidate();
     }

     // Redirect to the login page or any other page after logout
     return "redirect:/cust/login";
 }
 @PostMapping("/contact")
 public String submitContactForm(@ModelAttribute Contact contact) {
     // Save the contact details to the database
     contactRepository.save(contact);
     return "user/home"; // Redirect to a success page or any other desired page
 }
 
 @GetMapping("/home")
 public String backHome(){
	 return "user/home";
 }
}


