package tests;

import app.TestUtils;
import model.User;

public class UserTest {

	public static void main(String[] args) {
//		User testUser = new User("mike", "my_passwd","Mike", "Smith", "07771234567" );
//		
//		System.out.print(testUserConstructor());
		
		testUserConstructor();

		
		
	}
	
	public static void testUserConstructor() {
		
		String test_username = "mike";
		String test_password = "my_passwd";
		String test_first_name = "Mike";
		String test_last_name = "Smith";
		String test_mobile_number = "07771234567";
		
		boolean passed = true;
		
		User testUser = new User(test_username, test_password, test_first_name, 
				test_last_name,test_mobile_number );
		
		if(testUser.getUsername() == test_username) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestConstructor-TC1 passed" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TestConstructor-TC1 failed" + TestUtils.TEXT_COLOR_RESET);

		}
		
		if(testUser.getPassword() == test_password) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestConstructor-TC2 passed" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TestConstructor-TC2 failed" + TestUtils.TEXT_COLOR_RESET);

		}
		
		if(testUser.getFirst_name() == test_first_name) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestConstructor-TC3 passed" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TestConstructor-TC3 failed" + TestUtils.TEXT_COLOR_RESET);

		}
		
		if(testUser.getLast_name() == test_last_name) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestConstructor-TC4 passed" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TestConstructor-TC4 failed" + TestUtils.TEXT_COLOR_RESET);

		}
		
		if(testUser.getMobile_number() == test_mobile_number) {
			System.out.println(TestUtils.TEXT_COLOR_GREEN + "TestConstructor-TC5 passed" + TestUtils.TEXT_COLOR_RESET);
		} else {
			System.out.println(TestUtils.TEXT_COLOR_RED + "TestConstructor-TC5 failed" + TestUtils.TEXT_COLOR_RESET);

		}
		
		if(passed) {
			System.out.println("All TC's passed.");
		}
		
		if(testUser.getFirst_name() !=test_first_name) {
			System.out.println("TC3 failed: first_name did not match");
			passed = false;
			
		}
		
		if(testUser.getLast_name() !=test_last_name) {
			System.out.println("TC4 failed: last_name did not match");
			passed = false;
			
		}
		
		if(testUser.getMobile_number() !=test_mobile_number) {
			System.out.println("TC5 failed: mobile_number did not match");
			passed = false;
			
		}
		assert testUser.getUsername() == test_username;
		assert testUser.getPassword() == test_password;
		assert testUser.getFirst_name() == test_first_name;
		assert testUser.getLast_name() == test_last_name;
		assert testUser.getMobile_number() == test_mobile_number;
		//assert 1 == 2;
		
		System.out.println("All java assertions in the test suite passed(none failed)");
	}
	

}
