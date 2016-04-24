import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * The requirements specify that the converter must:
 * 		- follow the conventions of Roman numerals
 * 			- number set, subtraction rules,
 * 		- properly convert from arabic to roman
 * 		- properly convert from roman to arabic
 *
 * 	Therefore the test suite must test that the conversion rules hold
 */
public class ConverterTest {
	@Before
	public void initialize() {
		Converter.getInstance();
	}

	// test method isValidNumeral()
	@Test
	public void testIsValidNumeralSimpleValidNumeral() {
		assertTrue(Converter.isValidNumeral("VI"));
	}

	@Test
	public void testIsValidNumeralComplexValidNumeral() {
		assertTrue(Converter.isValidNumeral("MCMLXXXIX"));
	}

	@Test
	public void testIsValidNumeralSimpleInvalidNumeral() {
		assertFalse(Converter.isValidNumeral("XM"));
	}

	@Test
	public void testIsValidNumeralComplexInvalidNumeral() {
		assertFalse(Converter.isValidNumeral("CMMXIC"));
	}

	// test the method numberToNumeral()
	@Test
	public void testNumberToNumeralMapping() {
		assertEquals("I", Converter.numberToNumeral(1));
	}

	@Test
	public void testNumberToNumeralSubtraction() {
		assertEquals("IX", Converter.numberToNumeral(9));
	}

	@Test
	public void testNumberToNumeralProperOrder() {
		assertEquals("MLXVI", Converter.numberToNumeral(1066));
	}

	@Test
	public void testNumberToNumeralProperSubtraction() {
		assertEquals("LXXX", Converter.numberToNumeral(80));
	}

	@Test
	public void testNumberToNumeralThreeAtMost() {
		assertEquals("XXXIX", Converter.numberToNumeral(39));
	}

	@Test
	public void testNumberToNumeralNoMoreThanThree() {
		assertEquals("III", Converter.numberToNumeral(3));
		assertEquals("IV", Converter.numberToNumeral(4));
	}

	/**
	 * We're assuming that the highest number representable in Roman numerals is 4999. This is an arbitrary distinction
	 */
	@Test
	public void testNumberToNumeralFourMs() {
		assertEquals("MMMM", Converter.numberToNumeral(4000));
	}

	@Test
	public void testNumberToNumeralEdge() {
		assertEquals("MMMMCMXCIX", Converter.numberToNumeral(4999));
	}

	@Test
	public void testNumberToNumeralComplexity() {
		assertEquals("MMMMDCCCXL", Converter.numberToNumeral(4840));
	}

	// test method numeralToNumber()
	@Test
	public void testNumeralToNumberMapping() {
		assertEquals(1, Converter.numeralToNumber("I"));
	}

	@Test
	public void testNumeralToNumberSubtraction() {
		assertEquals(4, Converter.numeralToNumber("IV"));
	}

	@Test
	public void testNumeralToNumberProperOrder() {
		assertEquals(1066, Converter.numeralToNumber("MLXVI"));
	}

	@Test
	public void testNumeralToNumberProperSubtraction() {
		assertEquals(40, Converter.numeralToNumber("XL"));

	}

	@Test
	public void testNumeralToNumberThreeAtMost() {
		assertEquals(99, Converter.numeralToNumber("XCIX"));
	}

	@Test
	public void testNumeralToNumberNoMoreThanThree() {
		assertEquals(3, Converter.numeralToNumber("III"));
	}

	@Test
	public void testNumeralToNumberComplexity() {
		assertEquals(3694, Converter.numeralToNumber("MMMDCXCIV"));
	}

	@Test
	public void testNumeralToNumberEdge() {
		assertEquals(4999, Converter.numeralToNumber("MMMMCMXCIX"));
	}
}