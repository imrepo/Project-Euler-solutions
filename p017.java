public class p017 {
	
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 1000; i++){
			System.out.println(i+" "+toEnglish(i));
			sum += toEnglish(i).length();}
		System.out.println(sum);
	}
	
	
	private static String toEnglish(int n) {
		if (n < 0)
			throw new IllegalArgumentException();
		return thousands(n);
	}
	
	
	private static String thousands(int n) {
		if (n < 0 || n >= 10000)
			throw new IllegalArgumentException();
		
		if (n / 1000 == 0)
			return hundreds(n);
		else {
			if (n % 1000 == 0)
				return ones(n / 1000) + "thousand";
			else
				return ones(n / 1000) + "thousand" + hundreds(n % 1000);
		}
	}
	
	
	private static String hundreds(int n) {
		if (n < 0 || n >= 1000)
			throw new IllegalArgumentException();
		
		if (n / 100 == 0)
			return tens(n);
		else {
			if (n % 100 == 0)
				return ones(n / 100) + "hundred";
			else
				return ones(n / 100) + "hundred" + "and" + tens(n % 100);
		}
	}
	
	
	private static String tens(int n) {
		if (n < 0)
			throw new IllegalArgumentException();
		
		if (n / 10 == 0)
			return ones(n);
		else if (n / 10 == 1)
			return teens(n);
		else {
			String tens;
			switch (n / 10) {
				case 2:  tens = "twenty";   break;
				case 3:  tens = "thirty";   break;
				case 4:  tens = "forty";    break;
				case 5:  tens = "fifty";    break;
				case 6:  tens = "sixty";    break;
				case 7:  tens = "seventy";  break;
				case 8:  tens = "eighty";   break;
				case 9:  tens = "ninety";   break;
				default:  throw new IllegalArgumentException();
			}
			if (n % 10 == 0)
				return tens;
			else
				return tens + ones(n % 10);
		}
	}
	
	
	private static String teens(int n) {
		switch (n) {
			case 10:  return "ten";
			case 11:  return "eleven";
			case 12:  return "twelve";
			case 13:  return "thirteen";
			case 14:  return "fourteen";
			case 15:  return "fifteen";
			case 16:  return "sixteen";
			case 17:  return "seventeen";
			case 18:  return "eighteen";
			case 19:  return "nineteen";
			default:  throw new IllegalArgumentException();
		}
	}
	
	
	private static String ones(int n) {
		switch (n) {
			case 0:  return "zero";
			case 1:  return "one";
			case 2:  return "two";
			case 3:  return "three";
			case 4:  return "four";
			case 5:  return "five";
			case 6:  return "six";
			case 7:  return "seven";
			case 8:  return "eight";
			case 9:  return "nine";
			default:  throw new IllegalArgumentException();
		}
	}
	
}