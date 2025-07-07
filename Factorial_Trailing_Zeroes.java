class Solution {
    public int Factorial_Trailing_Zeroes(int n) {
        int count = 0;
        while(n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}