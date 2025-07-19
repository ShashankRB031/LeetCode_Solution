import java.util.Arrays;

class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Step 1: Sort boxTypes by units per box in descending order
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);

        int totalUnits = 0;

        // Step 2: Load the truck with boxes
        for (int[] box : boxTypes) {
            int numberOfBoxes = box[0];
            int unitsPerBox = box[1];

            // Determine how many boxes we can take of this type
            int boxesToTake = Math.min(truckSize, numberOfBoxes);

            // Add the units to total
            totalUnits += boxesToTake * unitsPerBox;

            // Decrease remaining truck size
            truckSize -= boxesToTake;

            // If truck is full, break
            if (truckSize == 0) {
                break;
            }
        }

        return totalUnits;
    }
}
