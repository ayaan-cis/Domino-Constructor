package dominoes;

import java.util.Set;
import java.util.HashSet;
import java.util.Collections;


public class DominoHighLowSetImpl_Syed implements Domino {
    private Set<Integer> highLowSet;

    public DominoHighLowSetImpl_Syed(int highPipCount, int lowPipCount) {
        highLowSet = new HashSet<Integer>();
        highLowSet.add(highPipCount);
        highLowSet.add(lowPipCount);
    }

    public static final char SUM_DIFFERENCE_DELIMITER = ',';
    public static boolean isSumDifferenceString(String str) {
    	boolean sumDifferenceBool = true;
    	char commaPlaceholder = str.charAt(1);

    	// Check if the input string is in the correct format
    	if (commaPlaceholder != SUM_DIFFERENCE_DELIMITER || str.length() != 3) {
    		sumDifferenceBool = false;
    	}
    	
    	else {
    		char firstIntChar = str.charAt(0);
    		char secondIntChar = str.charAt(2);
    		try	{   
		    	int sum = Character.getNumericValue(firstIntChar);
		    	int difference = Character.getNumericValue(secondIntChar);
		    	
		    	// Check for valid sum and difference values
		    	boolean invalidSum = (sum > 12 || sum < 0);
		    	boolean invalidDifference = (difference > 12 || difference < 0);
		    	
		    	if (invalidSum || invalidDifference) {
		    		sumDifferenceBool = false;
		    	}
		    	
		    	else {
		    		
		    		if (sum % 2 == 0 &&(difference % 2 != 0 || sum < difference || 12 - difference < sum)) {
			    		sumDifferenceBool = false;
			    	}
			    	
		    		else if (difference % 2 == 0 && (sum % 2 != 0 || sum < difference || 12 - difference < sum))	{
			    		sumDifferenceBool = false;
			    	}
		    	}
		    	
    		} 
    		
    		catch(NumberFormatException e){
	    		sumDifferenceBool = false;
	    	}
    	}
    	
    	return sumDifferenceBool;
    	

    }

    public DominoHighLowSetImpl_Syed(String sumDifferenceString) {
    	char charSum = sumDifferenceString.charAt(0);
    	char charDiff = sumDifferenceString.charAt(2);

    	// Extract the characters representing the sum and difference from the input string

    	int sum = Character.getNumericValue(charSum);
    	int difference = Character.getNumericValue(charDiff);

    	// Convert the character values to integers to work with them

    	int highPipCount = (sum + difference) / 2;
    	int lowPipCount = sum - highPipCount;

    	// Calculate the high and low pip counts based on the sum and difference    	
    	
    	highLowSet = new HashSet<Integer>();
    	highLowSet.add(highPipCount);
    	highLowSet.add(lowPipCount);
    		
    }

    public static boolean isLowPlus8TimesHighInteger_Syed(int k) {
    	boolean isLowPlus8TimesHighIntegerBoolean = true;    	
    	int dividendOf8 = k/8;
    	boolean high = (k > ((8 * dividendOf8) + dividendOf8));
    	boolean low = (k < (8 * dividendOf8));
    	
    	// Check if the value satisfies the low + 8 times high condition
    	if(high || low) {
    		isLowPlus8TimesHighIntegerBoolean = false;
    	}
    	
    	return isLowPlus8TimesHighIntegerBoolean;
    }

    public DominoHighLowSetImpl_Syed(int lowPlus8TimesHigh) {
    	int lowPipCount = lowPlus8TimesHigh % 8;
    	int highPipCount = lowPlus8TimesHigh / 8;
    	
    	highLowSet = new HashSet<Integer>();
    	highLowSet.add(highPipCount);
    	highLowSet.add(lowPipCount);
    	
    }
    
    @Override
    public int getHighPipCount() {
        return Collections.max(highLowSet);
    }

    @Override
    public int getLowPipCount() {
        return Collections.min(highLowSet);
    }
}
