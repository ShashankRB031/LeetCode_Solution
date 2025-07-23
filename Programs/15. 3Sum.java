class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            int target = nums[i];
            
            if (target > 0) break;  // early stopping since array is sorted
            
            if (i > 0 && nums[i] == nums[i - 1]) continue;  // skip duplicates
            
            int left = i + 1, right = nums.length - 1;
            
            while (left < right) {
                int sum = target + nums[left] + nums[right];
                
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    res.add(Arrays.asList(target, nums[left], nums[right]));
                    
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}