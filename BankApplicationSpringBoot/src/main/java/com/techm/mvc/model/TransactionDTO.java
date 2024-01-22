package com.techm.mvc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "transactions") // Specify the table name
public class TransactionDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // You can customize the column definition, e.g., precision and scale for BigDecimal
    @Column(name = "amount")
    private double amount;

    // Specify the column name
    @Column(name = "recipient")
    private String recipient;

    public TransactionDTO() {
        super();
    }

    public TransactionDTO(double amount, String recipient) {
        this.amount = amount;
        this.recipient = recipient;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

   

}
