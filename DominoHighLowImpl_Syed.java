package dominoes;

import java.util.Set;

public class DominoHighLowImpl_Syed implements Domino {
    private int highPipCount;
    private int lowPipCount;

    public DominoHighLowImpl_Syed(int highPipCount, int lowPipCount) {
        this.highPipCount = highPipCount;
        this.lowPipCount = lowPipCount;
    }

    public static final char HIGH_LOW_STRING_SEPARATOR = ':';

    public static boolean isHighLowString(String str) {
    	
    	if (str == null || str.length() != 3 || str.charAt(1) != HIGH_LOW_STRING_SEPARATOR) {
            return false;
        }

        int num, num2;
        
        try {
            num = Character.getNumericValue(str.charAt(0));
            num2 = Character.getNumericValue(str.charAt(2));
        } catch (NumberFormatException e) {
            return false;
        }

        return num >= num2 && num >= 0 &&  num2 >= 0 && num <= 6 && num2 <= 6;
    }

    public DominoHighLowImpl_Syed(String highLowString) {
        highPipCount = Character.getNumericValue(highLowString.charAt(0));
        lowPipCount = Character.getNumericValue(highLowString.charAt(2));
    }

    public static final int INDEX_OF_SUM = 0;
    public static final int INDEX_OF_DIFFERENCE = 1;
    // part of pre: sumDifference.length == 2
    // part of pre: sumDifference[INDEX_OF_SUM] >= sumDifference[INDEX_OF_DIFFERENCE]
    public DominoHighLowImpl_Syed(int[] sumDifference) {
        int sum = sumDifference[INDEX_OF_SUM];
        int difference = sumDifference[INDEX_OF_DIFFERENCE];
        
        highPipCount = (sum + difference) / 2;
        lowPipCount = sum - highPipCount;
    }

    // part of pre: 1<= highLowSet.size() <= 2
    // part of pre: ! highLowSet.contains(null)
    public DominoHighLowImpl_Syed(Set<Integer> highLowSet) {
        int size = highLowSet.size();
        if (size == 1) {
            highPipCount = lowPipCount = highLowSet.iterator().next();
        }
        
        else if (size == 2) {
            Integer[] values = highLowSet.toArray(new Integer[0]);
            highPipCount = Math.max(values[0], values[1]);
            lowPipCount = Math.min(values[0], values[1]);
        } 
        
        else {
            throw new IllegalArgumentException("INVALID SET INPUT");
        }
    }

    @Override
    public int getHighPipCount() {
        return highPipCount;
    }

    @Override
    public int getLowPipCount() {
        return lowPipCount;
    }
}
