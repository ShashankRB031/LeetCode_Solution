class Solution {
    public int missingNumber(int[] nums) {
        int allXOR = 0;

        
        for(int i = 0 ; i <= nums.length ; i++){
            allXOR = allXOR ^ i;  // ^ is XOR operator 
        }

        for(int num : nums){
            allXOR = allXOR ^ num;
        }
        return allXOR;
    }
}