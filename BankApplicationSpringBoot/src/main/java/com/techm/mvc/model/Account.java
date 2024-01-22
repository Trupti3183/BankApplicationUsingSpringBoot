package com.techm.mvc.model;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.Random;
import java.util.UUID;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Bidirectional One-to-One relationship with User
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "account_number", unique = true)
    private String accountNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "statement")
    private Date statement;

    public Account() {
        super();
   
    }

    

    public Account(Double balance, String accountType) {
		super();
		this.balance = balance;
		this.accountType = accountType;
		
	}



	public Account(Long id, String accountType, Double balance, Date statement, User user) {
        super();
        this.id = id;
        this.accountType = accountType;
        this.balance = balance;
        this.statement = statement;
        this.user = user;
    }

   

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Date getStatement() {
		return statement;
	}

	public void setStatement(Date statement) {
		this.statement = statement;
	}

	public User getUser() {
        return user;
    }

	  public void setUser(User user) {
	        // Ensure bidirectional relationship is managed from the Account side
	        if (this.user != null) {
	            this.user.getAccount().setUser(null);
	        }

	        this.user = user;

	        if (user != null) {
	            user.setAccount(this);
	        }
	    }



    public String generateRandomAccountNumber() {
        // Length of the desired account number
        int accountNumberLength = 16;

        // StringBuilder to store the generated account number
        StringBuilder accountNumber = new StringBuilder();

        // Random number generator
        Random random = new Random();

        // Generate each digit of the account number
        for (int i = 0; i < accountNumberLength; i++) {
            // Generate a random digit (0-9)
            int digit = random.nextInt(10);

            // Append the digit to the account number
            accountNumber.append(digit);
        }

        return accountNumber.toString();
    }
}
