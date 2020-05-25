import java.util.HashMap;

public class TestJavas {
    public static int numPairs(int[] songLength,int totalDuration) {
        int numPairs = 0;
        HashMap<Integer, Integer> remainderFrequency = new HashMap<>();

        for( int i = 0; i < songLength.length; i++) {
            int remainder = songLength[i] % totalDuration; // 30
            int requiredRemainder = 0;
            if(remainder != 0)
                requiredRemainder = totalDuration - remainder; // 30


            if(remainderFrequency.get(requiredRemainder) != null)
                numPairs += remainderFrequency.get(requiredRemainder);
            else {
                System.out.println("No pair found - " + requiredRemainder);
            }

            if(remainderFrequency.containsKey(remainder)) {
                remainderFrequency.put(remainder, remainderFrequency.get(remainder)+1);
            } else {
                remainderFrequency.put(remainder, 1);
            }
        }
        return numPairs;
    }

    public static void main(String [] args) {
        System.out.println(""+numPairs(new int[]{60, 20, 120, 60}, 60));
    }
}
