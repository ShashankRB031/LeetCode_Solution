class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        var result = new ArrayList<String>();
        int[] hours = new int[12], minutes = new int[60];
        for (int i = 0; i < 12; i++) 
            hours[i] = calculateOneBits(i);
        for (int i = 0; i < 60; i++) 
            minutes[i] = calculateOneBits(i);
        
        
        for (int i = 0; i < hours.length; i++)
            for (int j = 0; j < minutes.length; j++) 
                if ((hours[i] + minutes[j]) == turnedOn)
                    result.add(i + ":" + (j < 10 ? "0" + j : j));

        return result;
    }

    public int calculateOneBits(int n) {
        int result = 0;
        while (n > 0) {
            if (n % 2 == 1) result++;
            n /= 2;
        }
        return result;
    }
}