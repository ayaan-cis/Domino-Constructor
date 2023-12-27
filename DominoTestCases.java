package dominoes;
import java.util.HashSet;
import java.util.Set;

public class DominoTestCases {
    public static void main(String[] args) {
        // Test constructor with high and low pip counts
        Domino domino1 = new DominoHighLowImpl_Syed(3, 5);
        System.out.println("Domino 1 - High: " + domino1.getHighPipCount() + " Low: " + domino1.getLowPipCount());

        // Test constructor with a high-low string
        String highLowString = "4:2";
        if (DominoHighLowImpl_Syed.isHighLowString(highLowString)) {
            Domino domino2 = new DominoHighLowImpl_Syed(highLowString);
            System.out.println("Domino 2 - High: " + domino2.getHighPipCount() + " Low: " + domino2.getLowPipCount());
        } else {
            System.out.println("Invalid high-low string.");
        }

        // Test constructor with sum and difference
        int[] sumDiff = {12, 6};
        Domino domino3 = new DominoHighLowImpl_Syed(sumDiff);
        System.out.println("Domino 3 - High: " + domino3.getHighPipCount() + " Low: " + domino3.getLowPipCount());

        // Test constructor with a set of integers
        Set<Integer> highLowSet = new HashSet<>();
        highLowSet.add(1);
        highLowSet.add(6);
        Domino domino4 = new DominoHighLowImpl_Syed(highLowSet);
        System.out.println("Domino 4 - High: " + domino4.getHighPipCount() + " Low: " + domino4.getLowPipCount());

        // Test invalid high-low string
        String invalidHighLowString = "7:2";
        if (DominoHighLowImpl_Syed.isHighLowString(invalidHighLowString)) {
            System.out.println("Invalid high-low string should not pass.");
        } else {
            System.out.println("Invalid high-low string is correctly rejected.");
        }
    }
}