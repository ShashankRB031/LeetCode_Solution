import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, "", 0, result);
        return result;
    }

    private void backtrack(String s, int index, String currentIP, int count, List<String> result) {
        if (count == 4 && index == s.length()) {
            result.add(currentIP.substring(0, currentIP.length() - 1)); // remove last '.'
            return;
        }

        if (count >= 4 || index >= s.length()) return;

        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
            String part = s.substring(index, index + len);
            if (isValid(part)) {
                backtrack(s, index + len, currentIP + part + ".", count + 1, result);
            }
        }
    }

    private boolean isValid(String s) {
        if (s.length() > 1 && s.startsWith("0")) return false;
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }
}
