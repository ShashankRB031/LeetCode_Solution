class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        
        String result = "1";
        
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            char prevChar = result.charAt(0);
            
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == prevChar) {
                    count++;
                } else {
                    sb.append(count).append(prevChar);
                    prevChar = result.charAt(j);
                    count = 1;
                }
            }
            sb.append(count).append(prevChar);
            result = sb.toString();
        }
        
        return result;
    }
}
