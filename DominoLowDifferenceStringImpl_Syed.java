package dominoes;

import java.util.List;

public class DominoLowDifferenceStringImpl_Syed implements Domino{
	private String lowDifferenceString;
	private static final char LOW_DIFFERENCE_DELIMITER = '*';
	
	// pre: left to student
	// post: left to student
	public DominoLowDifferenceStringImpl_Syed(int lowPlus8TimesHigh) {
		int lowPipCount = lowPlus8TimesHigh % 8;
		int highPipCount = lowPlus8TimesHigh / 8;
		int pipCountDifference = highPipCount - lowPipCount;
		String pipCountString = String.valueOf(lowPipCount);

		lowDifferenceString = "";
		lowDifferenceString += pipCountString + LOW_DIFFERENCE_DELIMITER + pipCountDifference;
	}
	
	public static final int INDEX_OF_HIGH = 0;
	public static final int INDEX_OF_LOW = 1;
	
	// pre: left to student
	// post: left to student
	public DominoLowDifferenceStringImpl_Syed(List<Integer> highSum) {
		int highPipCount = highSum.get(0);
		int sum = highSum.get(1);
		int lowPipCount = sum - highPipCount;
		int difference = highPipCount - lowPipCount;
		String pipCount = String.valueOf(lowPipCount);
		
		lowDifferenceString = "";
		lowDifferenceString += pipCount + LOW_DIFFERENCE_DELIMITER + difference;
	}

	@Override
	public int getHighPipCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getLowPipCount() {
		// TODO Auto-generated method stub
		return 0;
	}
}
