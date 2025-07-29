class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums[0];

        while (left <= right) {
            // If the subarray is sorted
            if (nums[left] < nums[right]) {
                ans = Math.min(ans, nums[left]);
                break;
            }

            int mid = (left + right) / 2;
            ans = Math.min(ans, nums[mid]);

            // Check which side is sorted
            if (nums[left] <= nums[mid]) {
                // Left side is sorted, move to the right
                left = mid + 1;
            } else {
                // Right side is unsorted, move to the left
                right = mid - 1;
            }
        }

        return ans;
    }
}
