package tests;

import app.TestUtils;
//import app.SimpleBankingApp;
import model.Account;
import java.util.Date;

public class AccountTest {
	
	public static void testConstructor() {
		
		String test_account_number = "123456";
		String test_username_of_account_holder = "mike";
		String test_account_type = "public";
		Date test_account_opening_date = new Date(2000, 11, 27);
		
		boolean passed = true;
		
		Account testAccount = new Account(test_account_number, test_username_of_account_holder,
				test_account_type, test_account_opening_date);
		
		if(testAccount.getAccount_number() == test_account_number) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestConstructor-TC1 passed" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TestConstructor-TC1 failed" + TestUtils.TEXT_COLOR_RESET);

		}
		
		if(testAccount.getUsername_of_account_holder() == test_username_of_account_holder) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestConstructor-TC2 passed" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TestConstructor-TC2 failed" + TestUtils.TEXT_COLOR_RESET);

		}
		
		if(testAccount.getAccount_type() == test_account_type) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestConstructor-TC3 passed" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TestConstructor-TC3 failed" + TestUtils.TEXT_COLOR_RESET);

		}
		
		if(testAccount.getAccount_opening_date() == test_account_opening_date) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestConstructor-TC4 passed" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TestConstructor-TC4 failed" + TestUtils.TEXT_COLOR_RESET);

		}
		

		if(passed) {
			System.out.println("All TC's passed.");
		}
		
		if(testAccount.getAccount_number() !=test_account_number) {
			System.out.println("TC1 failed: account_number did not match");
			passed = false;
			
		}
		
		if(testAccount.getUsername_of_account_holder() !=test_username_of_account_holder) {
			System.out.println("TC2 failed: username_of_account_holder did not match");
			passed = false;
			
		}
		
		if(testAccount.getAccount_type() !=test_account_type) {
			System.out.println("TC3 failed: account_type did not match");
			passed = false;
			
		}
		
		if(testAccount.getAccount_opening_date() != test_account_opening_date) {
			System.out.println("TC4 failed: account_opening_date did not match");
			passed = false;
			
		}
		assert testAccount.getAccount_number() == test_account_number;
		assert testAccount.getUsername_of_account_holder() == test_username_of_account_holder;
		assert testAccount.getAccount_type() == test_account_type;
		assert testAccount.getAccount_opening_date() == test_account_opening_date;
		//assert 1 == 2;
		
		System.out.println("All java assertions in the test suite passed(none failed)");
		
		
		
		
	}
	
	public static void testSetter() {
		String test_account_number = "12345";
		String test_username_of_holder = "Conor";
		String test_account_type = "public";
		Date test_account_opening_date = new Date(2024, 02, 07);
		
		
		Account testAccount = new Account(test_account_number, test_username_of_holder, test_account_type, test_account_opening_date);
		
		testAccount.setAccount_number(test_account_number);
			assert testAccount.getAccount_number().equals(test_account_number);
			
		testAccount.setUsername_of_account_holder(test_username_of_holder);
			assert testAccount.getUsername_of_account_holder().equals(test_username_of_holder);
			
		testAccount.setAccount_type(test_account_type);
			assert testAccount.getAccount_type().equals(test_account_type);
			
		testAccount.setAccount_opening_date(test_account_opening_date);
			assert testAccount.getAccount_opening_date().equals(test_account_opening_date);
			
		System.out.println("All insertions for the setters have passed none have failed");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testConstructor();
		testSetter();

	}

}
