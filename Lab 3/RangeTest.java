package org.jfree.data;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class RangeTest extends TestCase {
	private Range rangeObjectUnderTest;

	//public static void assertEquals(java.lang.String message, 
	//		double expected,
     //       double actual,
      //      double delta) {
		
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
		assertEquals("The central value should be 0", 0, rangeObjectUnderTest.getCentralValue(),
				0.000000001d);

	}

	@Test
	public void testGetLengthBothPositiveAndEqual() {
		Range r1 = new Range(2, 2);
		assertEquals("get Length Did not return the expected output", 0.0, r1.getLength());

	}

	@Test
	public void testGetLengthBothPositiveAndNotEqual() {
		Range r2 = new Range(4, 9);

	}

	@Test
	public void testGetLengthBothNegativeAndEqual() {
		Range r3 = new Range(-99, -99);
		assertEquals("get Length Did not return the expected output", 0.0, r3.getLength());

	}

	@Test
	public void testGetLengthBothNegativeAndNotEqual() {
		Range r4 = new Range(-11, -4);
		assertEquals("get Length Did not return the expected output", 7.0, r4.getLength());

	}

	@Test
	public void testGetLengthOnePositiveOneNegative() {
		Range r5 = new Range(-5, 3);
		assertEquals("get Length did not return the expected output", 8.0, r5.getLength());

	}

	
	@Test
	public void testRangeCreationWithIncorrectBounds() {
	    assertThrows(IllegalArgumentException.class, () -> {
	        new Range(9, 3);
	    });
	}

	
	@Test
	public void testExpand() {
	    Range range = new Range(10, 20);
	    Range expandedRange = Range.expand(range, 0.1, 0.1);
	    Range expectedRange = new Range(9, 21);
	    assertEquals("Range should work as expected", expectedRange, expandedRange);
	}
	
	

	public void testExpandToIncludeValueInsideRange() {
		try {
			Range range = new Range(1, 10);
			Range result = Range.expandToInclude(range, 5);
			assertEquals("Expanding to include a value should not change the range", range, result);
		} catch (Exception e) {
			fail("No exception should be thrown for including a value inside the range");
		}
	}

	@Test
	public void testExpandToIncludeValueBelowRange() {
	    Range range = new Range(2, 10);
	    Range result = Range.expandToInclude(range, 1);
	    assertEquals("Expanding to include a value should change the ranges lower bound", 
	                 1, result.getLowerBound(), 0.0000001d);
	    assertEquals("The upper bound should remain unchanged", 
	                 range.getUpperBound(), result.getUpperBound(), 0.0000001d);
	}

	@Test
	public void testExpandToIncludeValueAboveRange() {
		try {
			Range range = new Range(1, 10);
			Range result = Range.expandToInclude(range, 11);
			assertEquals("Expanding to include a value  should not change the range", range, result);
		} catch (Exception e) {
			fail("No exception should be thrown for including a value ");
		}
	}

	@Test
	public void testExpandToIncludeWithNullRange() {
		Range result = Range.expandToInclude(null, 5);
		assertNotNull("Expanding a null range should create a new range", result);
		assertEquals("A new range created from a null range should have the lower and upper bounds equal",
				5, result.getLowerBound(), 0.0000001d);
		assertEquals("A new range created from a null range should have the lower and upper bounds equal",
				5, result.getUpperBound(), 0.0000001d);
	}

	@Test
	public void testExpandToIncludeValueAtRangeBoundary() {
		Range range = new Range(1, 10);
		Range result = Range.expandToInclude(range, 10);
		assertEquals("Expanding to include a value at the range's upper boundary should not change the range", range,
				result);
		result = Range.expandToInclude(range, 1);
		assertEquals("Expanding to include a value at the range's lower boundary should not change the range", range,
				result);
	}

	@Test
	public void testShiftRightByPositiveDelta() {
		Range baseRange = new Range(1, 5);
		double delta = 2;
		Range expectedRange = new Range(3, 7);
		Range resultRange = Range.shift(baseRange, delta);
		assertEquals("Shifting a range to the right should increase both bounds by delta", expectedRange, resultRange);
	}

	@Test
	public void testShiftLeftByNegativeDelta() {
		Range baseRange = new Range(3, 7);
		double delta = -2;
		Range expectedRange = new Range(1, 5);
		Range resultRange = Range.shift(baseRange, delta);
		assertEquals("Shifting a range to the left should decrease both bounds by delta", expectedRange, resultRange);
	}

	@Test
	public void testShiftWithDeltaZero() {
		Range baseRange = new Range(1, 5);
		double delta = 0;
		Range resultRange = Range.shift(baseRange, delta);
		assertEquals("Shifting a range by zero should return the same range", baseRange, resultRange);
	}

	@Test
	public void testShiftingAllowsZeroCrossing() {
	    try {
	        Range baseRange = new Range(-5, -1);
	        double delta = 10;
	        Range resultRange = Range.shift(baseRange, delta, true); 
	        assertEquals("Shifting should not throw an exception and the range should be shifted by delta",
	                     new Range(baseRange.getLowerBound() + delta, baseRange.getUpperBound() + delta), resultRange);
	    } catch (Exception e) {
	        fail("No exception should be thrown when shifting with zero crossing allowed.");
	    }
	}

	
	@Test
	public void testRangesIntersect() {
		Range range = new Range(1, 5);
		assertTrue("Ranges should intersect with eachother", range.intersects(1, 7));
		assertFalse("Ranges shouldnt intersect", range.intersects(11, 20));
		
	}

	@Test
	public void testRangesDoNotIntersect() {
		Range range = new Range(1, 5);
		assertFalse("Ranges should not intersect with eachother", range.intersects(6, 10));
	}

	@Test
	public void testAdjacentRangesDoNotIntersect() {
		Range range = new Range(1, 5);
		assertFalse("Adjacent ranges should not intersect with eachother", range.intersects(5, 10));
	}

	@Test
	public void testSameRangesIntersect() {
		Range range = new Range(1, 5);
		assertTrue("Identical ranges should intersect with eachother", range.intersects(1, 5));
	}

	@Test
	public void testGetCentralValueWithPositiveRange() {
		Range range = new Range(2, 8);
		assertEquals("The central value of a positive range will be correct", 5, range.getCentralValue(), 0.0000001d);
	}

	@Test
	public void testGetCentralValueWithNegativeRange() {
		Range range = new Range(-8, -2);
		assertEquals("The central value of a negative range will be correct", -5, range.getCentralValue(), 0.0000001d);
	}

	@Test
	public void testGetCentralValueWithZeroSpanRange() {
		Range range = new Range(-3, 3);
		assertEquals("The central value of a range spanning zero will be 0", 0, range.getCentralValue(), 0.0000001d);
	}

	@Test
	public void testGetCentralValueWithSinglePoint() {
		Range range = new Range(4, 4);
		assertEquals("The central value of a single point range will be the point given", 4, range.getCentralValue(),
				0.0000001d);
	}

	@Test
	public void testGetCentralValueWithLargeRange() {
		Range range = new Range(1, 100);
		assertEquals("The central value of a large range should be the midpoint of the range", 50.5,
				range.getCentralValue(), 0.0000001d);
	}


@Test
public void testConstrainWithinRange() {
    Range range = new Range(10, 20);
    assertEquals("Value within the range should not be constrained", 15, range.constrain(15), 0.000001d);
}

@Test
public void testConstrainAboveRange() {
    Range range = new Range(10, 20);
    assertEquals("Value above the range should be constrained to the upper bound", 20, range.constrain(25), 0.000001d);
}

@Test
public void testConstrainBelowRange() {
    Range range = new Range(10, 20);
    assertEquals("Value below the range should be constrained to the lower bound", 10, range.constrain(5), 0.000001d);
}
@Test
public void testCombineWithNonNullRanges() {
    Range range1 = new Range(1, 5);
    Range range2 = new Range(2, 6);
    Range expected = new Range(1, 6);
    Range result = Range.combine(range1, range2);
    assertEquals("Combining two non-null ranges should result in the encompassing range", expected, result);
}

@Test
public void testCombineFirstRangeNull() {
    Range range1 = null;
    Range range2 = new Range(2, 6);
    Range result = Range.combine(range1, range2);
    assertEquals("Combining a null range with a non-null range should return the non-null range", range2, result);
}

@Test
public void testCombineSecondRangeNull() {
    Range range1 = new Range(1, 5);
    Range range2 = null;
    Range result = Range.combine(range2, range1);
    assertEquals("Combining a non-null range with a null range should return the non-null range", range1, result);
}

@Test
public void testCombineBothRangesNull() {
    Range range1 = null;
    Range range2 = null;
    Range result = Range.combine(range1, range2);
    assertNull("Combining two null ranges should return null", result);
}
@Test
public void testHashCode() {
    Range range = new Range(5, 10);
    int hash = range.hashCode();
    assertNotNull("hashCode should return a non-null value", hash);
}


}


