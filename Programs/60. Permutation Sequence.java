import java.util.*;

public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();

        // Step 1: Precompute factorials and initialize nums list
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            nums.add(i);
            factorial[i] = factorial[i - 1] * i;
        }

        k--; // Convert k to 0-based index

        // Step 2: Build the kth permutation
        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(nums.get(index));
            nums.remove(index);
            k %= factorial[n - i];
        }

        return sb.toString();
    }
}
