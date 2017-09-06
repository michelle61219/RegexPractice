
import java.util.regex.*;

public class Regex {

	public static void main(String[] args) {
		String longString = " Miche Fuuuu CO AK 12345 PA (123)156-5071 johnsmith@hotmail.com 125-280-1256 512 555-1234 ";
		String strangeString = " 1Z aaa **** *** {{{ {{ { ";
		
		System.out.println("HELLLOOOOOOOOOOOOO");

		/*
		 * [0-9] - Any characters you want [^A-G]- Not A-G 
		 * \\s Search for any white space 
		 * \\S Search for anything not white space 
		 * {n,m} Search for minimum and maximum time
		 * \\d Search for anything that is a digit 
		 * \\D Search for anything that is a non-digit
		 * \\w [A-Za-z0-9_] Search for any type of word in this range 
		 * \\W for negation
		 * \\w* shows the range for 0 or more times
		 * 
		 */
		
		/*
		 * Replace all the spaces with comma and space
		 */
		 	regexReplace(longString);
		
		/*
		 * Search for phone number
		 * 1-(123)156-5071 (123)156-5071 123-156-5071 123 156-5071
		 */	
		 	regexChecker("([0-9]( |-)?)?(\\(?[0-9]{3}\\)?|[0-9]{3})( |-)?([0-9]{3}( |-)?[0-9]{4}|[a-zA-z0-9]{7})", longString);
		
		/*
		 * Search for the email address
		 * johnsmith@gmail.com
		 */	
		 	regexChecker("[A-Za-z0-9._%-]+@[A-Za-z0-9._-]+\\.[A-Za-z]{2,4}", longString);
		
		
		regexChecker("\\s[A-Za-z}]{2,20}\\s", longString); 		// The word between 2-20 from A-Z and a-z
		regexChecker("\\s\\d{5}\\s", longString);				// 5 digit numbers
		
		// 2 characters that start with a C or A
		// A[KLRZ]  OR  C[AOT]
		regexChecker("A[KLRZ]|C[AOT]", longString);
		
		// {5,} Minimum is 5, no Maximum
		// + Whatever proceeds must occur one or more times
		// . ^ * + ? {} [] \| ()  (Always need to be backslashed)
		regexChecker("(\\{{1,})", strangeString);	// Search { that is >= 1
		regexChecker("(\\{+)", strangeString);		// Same result as above
		regexChecker(".{3}", strangeString); 		// Search 3 of anything
	}

	/*
	 * Word that is 2 to 20 characters in length
	 * [A-Za-z]{2,20} \\w{2,20}  --> word characters
	 */
	public static void regexChecker(String theRegex, String str2Check) {
		
		Pattern checkRegex = Pattern.compile(theRegex);      // The regex that you want to search 
		
		Matcher regexMatcher = checkRegex.matcher(str2Check); // The regex that you want check if it matches

		while (regexMatcher.find()) {
			if (regexMatcher.group().length() != 0) { 		  // The string has value and length
				System.out.println(regexMatcher.group().trim()); // Cut off the whitespace
			}
			
			System.out.println("Start index: " + regexMatcher.start()); // Get the starting index
			System.out.println("End Index: " + regexMatcher.end());		//Get the ending index
	
		}
	}
	
	public static void regexReplace(String str2Replace) {
		Pattern replace =Pattern.compile("\\s+");
		Matcher regexMatcher =replace.matcher(str2Replace.trim());
		
		System.out.println(regexMatcher.replaceAll(", ")); 		// Replace all the spaces with comma and spaces 
		
	}
}
