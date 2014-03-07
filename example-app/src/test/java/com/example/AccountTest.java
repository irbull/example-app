package com.example;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class AccountTest {

	@Test
	public void testInitialBalance() {
		Account account = new Account(createBigDecimal(200.21));

		assertEquals(createBigDecimal(200.21), account.getBalance());
	}

	@Test
	public void testAddFundsToAccount() {
		Account account = new Account(createBigDecimal(200.21));

		account.deposit(createBigDecimal(0.79));

		assertEquals(createBigDecimal(201.00), account.getBalance());
	}

	@Test(expected = IllegalStateException.class)
	public void testOverdraftProtectionOf200Dollars() {
		Account account = new Account(createBigDecimal(200.1));

		account.deposit(createBigDecimal(-400.00));
	}

	private BigDecimal createBigDecimal(Double val) {
		BigDecimal result = new BigDecimal(val);
		return result.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
}
