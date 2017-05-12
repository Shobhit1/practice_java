package HackerRank;

/**
 * Created by shobhitagarwal on 5/10/17.
 * Input Format

     A single string containing a time in -hour clock format (i.e.:  or ), where  and .

     Output Format

     Convert and print the given time in -hour format, where .
 */
public class TimeConversion {
	private String getZoneOfDay(String secondsPart) {
		return secondsPart.replaceAll("\\d+", "");
	}

	private String getSeconds(String secondsPart) {
		return secondsPart.replaceAll("\\D+", "");
	}

	private String convertHours(String hours, String dayZone) {
		int newHours = Integer.parseInt(hours);
		if ((dayZone.equalsIgnoreCase("PM") && !hours.equalsIgnoreCase("12")) || (dayZone.equalsIgnoreCase("AM") && hours.equalsIgnoreCase("12"))) {
			newHours += 12;
		}

		int actualHours;
		if (newHours == 24) {
			return "00";
		} else if (newHours > 24) {
			actualHours = 24 - newHours;
			return String.valueOf(actualHours);
		}
		String returnValue = String.valueOf(newHours);
		return (returnValue.length() == 1 ? "0" + returnValue : returnValue);
	}

	private String convert(String input) {
		String[] inputArray = input.split(":");
		String seconds = getSeconds(inputArray[2]);
		String dayZone = getZoneOfDay(inputArray[2]);
		String hours = inputArray[0];
		String minutes = inputArray[1];

		String actualHours = convertHours(hours, dayZone);

		return actualHours + ":" + minutes + ":" + seconds;
	}

	public static void main(String[] args) {
		String input = "12:45:54PM";
		TimeConversion tc = new TimeConversion();
		System.out.println(tc.convert(input));
	}
}
