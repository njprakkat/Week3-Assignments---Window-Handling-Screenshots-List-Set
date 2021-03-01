package week3.day2;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SortingUsingCollections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] input = {"HCL","Wipro","Aspire Systems","CTS"};
		
		Set<String> stringset = new LinkedHashSet<String>();
		Arrays.sort(input);
		
		for( int i=input.length-1; i >=0; i--)
		{
			stringset.add(input[i]);
		}
		
		for(String eachvalue : stringset)
			System.out.println(eachvalue);
	}

}
