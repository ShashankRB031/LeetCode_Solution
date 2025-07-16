import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Create a HashSet to store unique elements
        HashSet<Integer> seen = new HashSet<>();

        // Iterate through the array
        for (int num : nums) {
            // If the number is already in the set, it's a duplicate
            if (seen.contains(num)) {
                return true;
            }
            // Otherwise, add it to the set
            seen.add(num);
        }

        // If no duplicates are found, return false
        return false;
    }
}