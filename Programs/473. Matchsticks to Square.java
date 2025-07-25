class Solution {
    public boolean makesquare(int[] matchsticks) {
        int totalLength = Arrays.stream(matchsticks).sum();
        if (totalLength % 4 != 0) return false;
        int sideLength = totalLength / 4;
        return helper(matchsticks, new boolean[matchsticks.length], sideLength, 0, 0, 0);
    }

    private boolean helper(int[] matchsticks, boolean[] used, int targetLength, int currLength, int sideCount, int start) {
        if (sideCount == 4) return true;
        if (currLength == targetLength)
            return helper(matchsticks, used, targetLength, 0, sideCount + 1, 0);

        for (int i = start; i < matchsticks.length; i++) {
            if (!used[i] && currLength + matchsticks[i] <= targetLength) {
                used[i] = true;
                if (helper(matchsticks, used, targetLength, currLength + matchsticks[i], sideCount, i + 1)) return true;
                used[i] = false;
            }
        }

        return false;
    }
}