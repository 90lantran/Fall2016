import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Square {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = in.readLine()) != null) {
			try {
				// The input may be too big, overflow may show up
				long number = Long.parseLong(s);
				long result = number * number;

				// Check to see if overflow occurs
				// If not, print result
				// If yes, using BigInteger. BigInteger operations are
				// substantially slower than built-in integer types.
				// BigInteger should only be used if it is absolutely necessary
				if (result > 0) {
					System.out.println(result);
				} else {
					BigInteger bigInteger = BigInteger.valueOf(number);
					BigInteger bigResult = bigInteger.multiply(bigInteger);
					System.out.println(bigResult);
				}

			} catch (NumberFormatException e) {
				// Handle input is not numeric value
				System.out.println("Your input is not an integer.");
			}
		}
	}
}
