package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {
	public static void main(String[] args) {
		String total = getTextRegex("Showing 11 to 20 of (.*?) entries", "Showing 11 to 20 of 57 entries");
		System.out.println("Total = " + total);

	}

	public static String getTextRegex(String regex, String text) {
		String textRegex = "";
		Pattern patternRegex = Pattern.compile(regex);
		Matcher m = patternRegex.matcher(text);

		if (m.find()) {
			System.out.println("Group 0 = " + m.group(0));
			System.out.println("Group 1 = " + m.group(1));
			textRegex = m.group(1);
		}
		return textRegex;
	}
}
