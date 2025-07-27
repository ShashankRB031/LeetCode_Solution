class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int cur = nums[i];

            int tempMax = Math.max(cur, Math.max(maxProd * cur, minProd * cur));
            minProd = Math.min(cur, Math.min(minProd * cur, maxProd * cur));
            maxProd = tempMax;

            result = Math.max(result, maxProd);
        }

        return result;
    }
}
