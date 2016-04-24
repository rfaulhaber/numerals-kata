import java.util.Scanner;

/**
 * Created by ryan on 4/24/16.
 */
public class Main {
    public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		Converter.getInstance(); // make sure it's initialized
		System.out.println("Enter a number less than 5000, a numeral, or \"exit\" to exit the program");
		while (true) {
			System.out.print(">> ");
			String line = reader.nextLine();
			if (line.equals("exit")) System.exit(0);
			else {
				if (Converter.isValidNumeral(line)) System.out.println(Converter.numeralToNumber(line));
				else if (line.matches("[0-9]") && Integer.valueOf(line) < 5000) System.out.println(Converter.numberToNumeral(Integer.valueOf(line)));
				else System.out.println("I don't understand the input!");
			}
		}
    }
}
