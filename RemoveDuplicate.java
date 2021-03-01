package week3.day2;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "PayPal India";
		char[] charArray = str.toCharArray();
		int length = charArray.length;
		
		Set<Character> charSet = new LinkedHashSet<Character>();
		
		for( int i = 0; i < length; i++)
		{
			charSet.add(charArray[i]);
		}
		
		for(Character eachvalue : charSet)
		{
			if(eachvalue != ' ')
			System.out.print(eachvalue);
		}
	}

}
