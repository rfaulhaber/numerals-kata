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

	@Test
	public void testNumberToNumeralComplexity() {
		assertEquals("MMMMMMDCCCXL", Converter.numberToNumeral(6840));
	}
}