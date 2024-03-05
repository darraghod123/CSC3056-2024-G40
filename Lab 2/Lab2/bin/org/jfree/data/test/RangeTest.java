package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class RangeTest extends TestCase{
	private Range rangeObjectUnderTest;
	
//	public static void assertEquals(java.lang.String message, 
//			double expected,
//            double actual,
//            double delta) {
//		
//	}
	 
	

	@Before
	public void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-1, 1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCentralValueShouldBeZero() { 
		assertEquals("The central value of -1 and 1 should be 0",
			0, rangeObjectUnderTest.getCentralValue(), 0.000000001d);
			
	}
	
	@Test
	public void testGetLengthBothPositiveAndEqual() {
		Range r1 = new Range(2, 2); 
		assertEquals("getLength: Did not return the expected output", 0.0, r1.getLength()); 
		
	}
	
	@Test
	public void testGetLengthBothPositiveAndNotEqual() { 
		Range r2 = new Range(4, 9); 
		
	}
	
	@Test
	public void testGetLengthBothNegativeAndEqual() { 
		Range r3 = new Range(-99, -99); 
		assertEquals("getLength: Did not return the expected output", 0.0, r3.getLength()); 
		
	}
	
	@Test
	public void testGetLengthBothNegativeAndNotEqual() { 
		Range r4 = new Range(-11, -4); 
		assertEquals("getLength: Did not return the expected output", 7.0, r4.getLength()); 
		
	}
	
	@Test
	public void testGetLengthOnePositiveOneNegative() { 
		Range r5 = new Range(-5, 3); 
		assertEquals("getLength: Did not return the expected output", 8.0, r5.getLength()); 
		
		
		
	}
	
	 @Test
	    public void testConstrainWithPositiveDoubleValues() {
		 try {
	        Range range = new Range(5, 7);
	        assertEquals("Constraining a value within positive bounds should return the value itself", 6, range.constrain(6), 0.0000001d);
		 } catch (Exception e) {
	            fail("The digits should both be positive with no exception thrown.");
	        }
	    }


	    @Test
	    public void testConstrainWithNegativeDoubleValues() {
	    	try { 
	        Range range = new Range(-7, -5);
	        assertEquals("Constraining a value within negative bounds should return the value itself", -6, range.constrain(-6), 0.0000001d);
	    	} catch (Exception e) {
	    		fail("The digits should both be negative with no exceptions thrown.");
	    	}
	    }

	    @Test(expected = IllegalArgumentException.class)
	    public void testRangeCreationWithIncorrectBounds() {
	        new Range(9, 3); 
	    }

	    @Test
	    public void testConstrainWithMixedSignValues() {
	    	try {
	        Range range = new Range(-3, 5);
	        assertEquals("Constraining a negative value in a range that crosses zero should return the lower bound", -3, range.constrain(-4), 0.0000001d);
	        assertEquals("Constraining a positive value in a range that crosses zero should return the value itself", 3, range.constrain(3), 0.0000001d);
	    	 } catch (Exception e) {
	             fail("The digits should be positive and negative.");
	         }
	     }
	 }