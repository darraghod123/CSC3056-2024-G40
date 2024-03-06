package org.jfree.data.test;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.Range;
import org.jfree.data.Values2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;

import junit.framework.TestCase;

public class DataUtilitiesTest{
	
	private Values2D values2D;

//
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}

	//@Before
//	public void setUp() {
//		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
//		testValues.addValue(1, 2, 3);
//		testValues.addValue(4, 5, 6);
//		values2D = testValues;
//	}
	@Before
	public void setUp() {
	    DefaultKeyedValues2D testValues = new DefaultKeyedValues2D(); 
	    values2D = testValues;
	    testValues.addValue(1, 0, 0); // Add value 1 at row 0, column 0
	    testValues.addValue(4, 1, 0); // Add value 4 at row 1, column 0
	    testValues.addValue(2, 0, 1); // Add value 2 at row 0, column 1
	    testValues.addValue(5, 1, 1); // Add value 5 at row 1, column 1
	    testValues.addValue(3, 0, 2); // Add value 3 at row 0, column 2
	    testValues.addValue(6, 1, 2); // Add value 6 at row 1, column 2
	    	    
	}


	@After
	public void tearDown() {
		values2D = null;
	}
	
	//Calculate Column methods

	@Test
	public void testValidDataAndColumnColumnTotal() {
		assertEquals("Wrong sum returned. It should be 5.0",
				5.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);
	}
	@Test
	public void testValidDataAndColumnWithValidDataAndColumn() {
		//int column = 1;
		
		//System.out.println(DataUtilities.calculateColumnTotal(values2D,1));
		assertEquals("When 2D matrix given 7.0 should be the output", 7.0, DataUtilities.calculateColumnTotal(values2D,1), 0.0000001d);
	}
	
	@Test
	public void testDataWithInvalidColumn() {
	    try {
			assertEquals("When 2D matrix given 7.0 should be the output", 7.0, DataUtilities.calculateColumnTotal(values2D,-1), 0.0000001d);
			
	    } catch (IndexOutOfBoundsException e) {
	    	   fail("Unexpected exception thrown: " + e.getMessage());
	    }
	}
	@Test
	public void testDataWithInvalidColumnMoreThan() {
	    try {
			assertEquals("When 2D matrix given 7.0 should be the output", 7.0, DataUtilities.calculateColumnTotal(values2D,13), 0.0000001d);
			
	    } catch (IndexOutOfBoundsException e) {
	    	   fail("Unexpected exception thrown: " + e.getMessage());
	    }
	}
	@Test
	public void testDataEmptyColumnValidData() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();
		
		assertEquals("When 2D matrix given 7.0 should be the output", 0.0, DataUtilities.calculateColumnTotal(data,0), 0.0000001d);
		
	}
	@Test
	public void testDataEmptyColumnInvalidData() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();
		
	    try {
			assertEquals("When 2D matrix given 7.0 should be the output", 0.0, DataUtilities.calculateColumnTotal(data,-1), 0.0000001d);
			
	    } catch (IndexOutOfBoundsException e) {
	    	   fail("Unexpected exception thrown: " + e.getMessage());
	    }
	}
	@Test
	public void testDataEmptyColumnInvalidDataMoreThan() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();
		
	    try {
			assertEquals("When 2D matrix given 7.0 should be the output", 0.0, DataUtilities.calculateColumnTotal(data,15), 0.0000001d);
			
	    } catch (IndexOutOfBoundsException e) {
	    	assertTrue("Incorrect exception type thrown", 
					e.getClass().equals(IllegalArgumentException.class));
	    }
	}
	@Test
	public void testDataEmptyColumnValidDataCalculateRow() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();
		
		assertEquals("When 2D matrix given 7.0 should be the output", 0.0, DataUtilities.calculateRowTotal(data,0), 0.0000001d);
		
	}
	@Test
	public void testDataEmptyColumnInvalidDataCalculateRow() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();
		
	    try {
			assertEquals("When 2D matrix given 7.0 should be the output", 0.0, DataUtilities.calculateRowTotal(data,-1), 0.0000001d);
			
	    } catch (IndexOutOfBoundsException e) {
	    	   fail("Unexpected exception thrown: " + e.getMessage());
	    }
	}
	@Test
	public void testDataEmptyColumnInvalidDataMoreThanCalculateRow() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();
		
	    try {
			assertEquals("When 2D matrix given 7.0 should be the output", 0.0, DataUtilities.calculateRowTotal(data,15), 0.0000001d);
			
	    } catch (IndexOutOfBoundsException e) {
	    	   fail("Unexpected exception thrown: " + e.getMessage());
	    }
	}
	
	@Test
	public void testNullDataColumnTotal() {
		try {
			DataUtilities.calculateColumnTotal(null, 0);
			fail("No exception thrown.");
			
		}
		catch(Exception e) {
			assertTrue("Incorrect exception type thrown", 
					e.getClass().equals(IllegalArgumentException.class));
		}
		
	}
	
	
	//CalculateRowTotal method testcase's
	
	@Test
	public void testValidDataAndRowRowTotal() {
		assertEquals("Wrong sum returned. It should be 6.0",
				6.0, DataUtilities.calculateRowTotal(values2D, 0), 0.0000001d);
	}
	
	@Test
	public void testValidDataAndRowWithValidDataAndRow() {
		assertEquals("When 2D matrix given 15.0 should be the output", 
				15.0, DataUtilities.calculateRowTotal(values2D, 1), 0.0000001d);
	}
	

	@Test
	public void testDataWithInvalidRow() {
		try {
			DataUtilities.calculateRowTotal(values2D, -1);
		}
		catch(Exception e) {
			assertTrue("Incorrect exception type thrown", 
					e.getClass().equals(IndexOutOfBoundsException.class));
		}
		
	}
	
	@Test
	public void testDataWithInvalidRowMoreThan() {
		try {
			DataUtilities.calculateRowTotal(values2D, 15);
		}
		catch(Exception e) {
			assertTrue("Incorrect exception type thrown", 
					e.getClass().equals(IndexOutOfBoundsException.class));
		}

	}

	@Test
	public void testDataEmptyRowValidData() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();
		assertEquals("When 2D matrix given 0.0 should be the output", 
				0.0, DataUtilities.calculateRowTotal(data, 0), 0.0000001d);
	}

	@Test
	public void testDataEmptyRowInvalidData() {
		try {
			DefaultKeyedValues2D data = new DefaultKeyedValues2D();
			DataUtilities.calculateRowTotal(data, -1);
		}
		catch(Exception e) {
			assertTrue("Incorrect exception type thrown", 
					e.getClass().equals(IndexOutOfBoundsException.class));
		}
		
	}
	
	@Test
	public void testDataEmptyRowInvalidDataMoreThan() {
		try {
			DefaultKeyedValues2D data = new DefaultKeyedValues2D();
			DataUtilities.calculateRowTotal(data, 15);
		}
		catch(Exception e) {
			assertTrue("Incorrect exception type thrown", 
					e.getClass().equals(IndexOutOfBoundsException.class));
		}
		
	}
	
	@Test
	public void testNullDataRowTotal() {
		try {
			DataUtilities.calculateRowTotal(null, 0);
			fail("No exception thrown.");
			
		}
		catch(Exception e) {
			assertTrue("Incorrect exception type thrown", 
					e.getClass().equals(IndexOutOfBoundsException.class));
		}
		
	}
	
	//testing createNumberArray method
	
	@Test
	public void testArrayWithValidNumbers() {
		double[] numbers = {1.0, 2.0, 3.0};
		Number[] array = DataUtilities.createNumberArray(numbers);
		assertEquals("Array length should match", numbers.length, array.length);
	}
	
	@Test
	public void testEmptyArray() {
		double[] empty = {};
		Number[] Array = DataUtilities.createNumberArray(empty);
		assertEquals("Length is zero", 0, Array.length);
	}
	
	@Test
	public void testArrayWithNegativeNumbers() {
		double[] negative = {-1.5, -2.8, -3.1};
		Number[] Array = DataUtilities.createNumberArray(negative);
		 try {
		        assertEquals("Array length should be 3", 3, Array.length);
		        assertEquals("First number should be -1.5", -1.5, Array[0].doubleValue(), 0.00001);
		        assertEquals("Second number should be -2.8", -2.8, Array[1].doubleValue(), 0.00001);
		        assertEquals("Third number should be -3.1", -3.1, Array[2].doubleValue(), 0.00001);
		    } catch (Exception e) {
		        fail("Method has failed: " + e.getMessage());
		    }
	}
	@Test
	public void testArrayWithZero() {
		double[] zero = {0.0, 0.0, 0.0};
		Number[] Array_zero = DataUtilities.createNumberArray(zero);
		 try {
		        assertEquals("Array length should be 3", 3, Array_zero.length);
		        assertEquals("First number should be 0.0", 0.0, Array_zero[0].doubleValue(), 0.00001);
		        assertEquals("Second number should be 0.0", 0.0, Array_zero[1].doubleValue(), 0.00001);
		        assertEquals("Third number should be 0.0", 0.0, Array_zero[2].doubleValue(), 0.00001);
		    } catch (Exception e) {
		        fail("Method has failed: " + e.getMessage());
		    
		    }
	}
	
	//testing createNumberArray2D
	
	@Test
    public void testCreateNumberArray2DWithValidData() {
	    double[][] data = {{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}};
	    Number[][] array2D = DataUtilities.createNumberArray2D(data);
	    
	    assertEquals("Number of rows should match", 2, array2D.length);
	    assertEquals("Number of columns in first row should match", 3, array2D[0].length);
	    assertEquals("Number of columns in second row should match", 3, array2D[1].length);
	    
	    assertArrayEquals("Array should match here", array2D, data);
    }

	@Test
    public void testCreateNumberArray2DWithNullData() {
		try {
 
        DataUtilities.createNumberArray2D(null);
		}
		catch(Exception e) {
			assertTrue("Incorrect exception type has been thrown", 
					e.getClass().equals(IllegalArgumentException.class));
		}
    }
	
	@Test
    public void testCreateNumberArray2DWithEmptyData() {
		try {
			double[][] data = {};
	        DataUtilities.createNumberArray2D(data);
			
		}
		catch(Exception e) {
			assertTrue("Incorrect exception type has been thrown", 
					e.getClass().equals(IllegalArgumentException.class));
		}
    }
	
	
	//testing cumulative percentages
	@Test
	public void testCumulativePercentage() {
		DefaultKeyedValues data = new DefaultKeyedValues();
        data.addValue("0", 5.0);
        data.addValue("1", 9.0);
        data.addValue("2", 2.0);
        
        KeyedValues result = DataUtilities.getCumulativePercentages(data);
        
        assertEquals(1.0,(double) result.getValue(2),  0.00001);
	}

	@Test
	public void testGetCumulativePercentagesWithEmptyData() {
		try {
			DataUtilities.getCumulativePercentages(new DefaultKeyedValues());
		}
		catch(Exception e) {
			assertTrue("Incorrect exception type has been thrown", 
					e.getClass().equals(IllegalArgumentException.class));
		}
    }

	@Test
    public void testGetCumulativePercentagesWithNullData() {
		try {
			 DataUtilities.getCumulativePercentages(null);
		}
		catch(Exception e) {
			assertTrue("Incorrect exception type has been thrown", 
					e.getClass().equals(IllegalArgumentException.class));
		}
       
    }

}
