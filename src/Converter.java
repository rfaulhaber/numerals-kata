import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ryan on 4/24/16.
 */
public class Converter {
	private static Converter sInstance;
	private static Map<String, Integer> mNumeralMap;

	// this wonderful regex expression comes from here: http://stackoverflow.com/questions/267399/how-do-you-match-only-valid-roman-numerals-with-a-regular-expression
	private static final Pattern mProperNumeralPattern = Pattern.compile("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$");

	private Converter() {
		mNumeralMap = new HashMap<String, Integer>();
		mNumeralMap.put("I", 1);
		mNumeralMap.put("V", 5);
		mNumeralMap.put("X", 10);
		mNumeralMap.put("L", 50);
		mNumeralMap.put("C", 100);
		mNumeralMap.put("D", 500);
		mNumeralMap.put("M", 1000);
	}

	public static Converter getInstance() {
		if (sInstance == null) sInstance = new Converter();
		return sInstance;
	}

	public static String numberToNumeral(int number) {
		int thousands = number / 1000;
		int hundreds = (number - (thousands * 1000)) / 100;
		int tens = (number - (thousands * 1000) - (hundreds * 100)) / 10;
		int ones = ((number - (thousands * 1000) - (hundreds * 100) - (tens * 10)));

		String thousandsPlace = "", hundredsPlace = "", tensPlace = "", onesPlace = "";

		for (int i = 0; i < thousands; i++) {
			thousandsPlace += "M";
		}

		if (hundreds == 4) {
			hundredsPlace = "CD";
		} else if (hundreds == 9) {
			hundredsPlace = "CM";
		} else if (hundreds == 5) {
			hundredsPlace = "D";
		} else {
			if (hundreds > 5) {
				hundredsPlace = "D";
				hundreds -= 5;
			}
				for (int i = 0; i < hundreds; i++) {
					hundredsPlace += "C";
				}

		}

		if (tens == 4) {
			tensPlace = "XL";
		} else if (tens == 9) {
			tensPlace = "XC";
		} else if (tens == 5) {
			tensPlace = "L";
		} else {
			if (tens > 5) {
				tensPlace = "L";
				tens -= 5;
			}
				for (int i = 0; i < tens; i++) {
					tensPlace += "X";
				}

		}

		if (ones == 4) {
			onesPlace = "IV";
		} else if (ones == 9) {
			onesPlace = "IX";
		} else if (ones == 5) {
			onesPlace = "V";
		} else {
			if (ones > 5) {
				onesPlace = "V";
				ones -= 5;
			}
				for (int i = 0; i < ones; i++) {
					onesPlace += "I";
				}

		}

		return thousandsPlace + hundredsPlace + tensPlace + onesPlace;
	}



	public static String numeralToNumber(String numeral) {
		return "";
	}

	public static boolean isValidNumeral(String numeral) {
		Matcher matcher = mProperNumeralPattern.matcher(numeral);
		return matcher.matches();
	}
}
