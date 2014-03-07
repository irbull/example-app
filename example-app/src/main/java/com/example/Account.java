package com.example;

import java.math.BigDecimal;

public class Account {
	
	private static final BigDecimal ZERO = new BigDecimal(0).setScale(2, BigDecimal.ROUND_HALF_UP);

	private BigDecimal balance;

	public Account(BigDecimal initialBalance) {
		balance = initialBalance;
	}

	public void deposit(BigDecimal amount) {
		if (balance.add(amount).compareTo(ZERO) < 0) {
			throw new IllegalStateException("Insufficient funds");
		}
		balance = balance.add(amount);
		balance = balance.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	public BigDecimal getBalance() {
		return balance;
	}

}
