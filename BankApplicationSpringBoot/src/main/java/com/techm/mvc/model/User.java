package com.techm.mvc.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "mobileNumber")
    private String mobileNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "govtId")
    private String govtId;

    // Bidirectional One-to-One relationship with Account
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Account account;
   
   
    public User() {
        super();
        this.account = new Account(1000.00,"saving");
        this.account.setUser(this);
        this.account.setAccountNumber(account.generateRandomAccountNumber());
        this.account.setStatement(new java.sql.Date(System.currentTimeMillis()));
    }

    public User(Long id, String name, String email, String password, String mobileNumber, String address, String govtId,
			Account account) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.govtId = govtId;
		this.account = account;
	}
    
    

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGovtId() {
		return govtId;
	}

	public void setGovtId(String govtId) {
		this.govtId = govtId;
	}

	public Account getAccount() {
        return account;
    }

	public void setAccount(Account account) {
        this.account = account;
        
    }
	
}