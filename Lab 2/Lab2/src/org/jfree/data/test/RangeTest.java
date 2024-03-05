package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class RangeTest extends TestCase {
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
		assertEquals("The central value of -1 and 1 should be 0", 0, rangeObjectUnderTest.getCentralValue(),
				0.000000001d);

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
			assertEquals("Constraining a value within positive bounds should return the value itself", 6,
					range.constrain(6), 0.0000001d);
		} catch (Exception e) {
			fail("The digits should both be positive with no exception thrown.");
		}
	}

	@Test
	public void testConstrainWithNegativeDoubleValues() {
		try {
			Range range = new Range(-7, -5);
			assertEquals("Constraining a value within negative bounds should return the value itself", -6,
					range.constrain(-6), 0.0000001d);
		} catch (Exception e) {
			fail("The digits should both be negative with no exceptions thrown.");
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRangeCreationWithIncorrectBounds() {
		new Range(9, 3); // This will throw an illegal exception due to the range being invalid.
	}

	@Test
	public void testConstrainWithMixedSignValues() {
		try {
			Range range = new Range(-3, 5);
			assertEquals("Constraining a negative value in a range that crosses zero", -3, range.constrain(-3),
					0.0000001d);
			assertEquals("Constraining a positive value in a range that crosses zero", 5, range.constrain(5),
					0.0000001d);
		} catch (Exception e) {
			fail("The digits should be positive and negative.");
		}
	}

	public void testExpandToIncludeValueInsideRange() {
		try {
			Range range = new Range(1, 10);
			Range result = Range.expandToInclude(range, 5);
			assertEquals("Expanding to include a value inside the range should not change the range", range, result);
		} catch (Exception e) {
			fail("No exception should be thrown for including a value inside the range");
		}
	}

	@Test
	public void testExpandToIncludeValueBelowRange() {
		try {
			Range range = new Range(1, 10);
			Range result = Range.expandToInclude(range, 0);
			assertEquals("Expanding to include a value below the range should not change the range", range, result);
		} catch (Exception e) {
			fail("No exception should be thrown for including a value below the range");
		}
	}

	@Test
	public void testExpandToIncludeValueAboveRange() {
		try {
			Range range = new Range(1, 10);
			Range result = Range.expandToInclude(range, 11);
			assertEquals("Expanding to include a value above the range should not change the range", range, result);
		} catch (Exception e) {
			fail("No exception should be thrown for including a value above the range");
		}
	}

	@Test
	public void testExpandToIncludeWithNullRange() {
		Range result = Range.expandToInclude(null, 5);
		assertNotNull("Expanding a null range should create a new range", result);
		assertEquals("A new range created from a null range should have the lower and upper bounds equal to the value",
				5, result.getLowerBound(), 0.0000001d);
		assertEquals("A new range created from a null range should have the lower and upper bounds equal to the value",
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
	public void testShiftingCausesZeroCrossing() {
		try {
			Range baseRange = new Range(-5, -1);
			double delta = 10;
			Range.shift(baseRange, delta);
		} catch (IllegalArgumentException e) {
			fail("Unexpected IllegalArgumentException: zero crossing should be handled without exception.");
		} catch (Exception e) {
			fail("Unexpected exception during shift operation.");
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void testPassingNullRange() {
		Range.shift(null, 1); // this will throw an exception on purpose due to being invalid
	}

	@Test
	public void testRangesIntersect() {
		Range range = new Range(1, 5);
		assertTrue("Ranges should intersect with eachother", range.intersects(3, 7));
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
}