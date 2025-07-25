class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        Map<Character, String> map=new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        StringBuilder s=new StringBuilder();
        helper(0, map, ans, digits, s);
        return ans;
    }
    public void helper(int currDigit, Map<Character, String> map, List<String> ans, String digits, StringBuilder s) {
        if(currDigit==digits.length())
        {
            if(s.length()>0) ans.add(s.toString());
            return;
        }

        char currLetter=digits.charAt(currDigit);
        for(char c:map.get(currLetter).toCharArray())
        {
            s.append(c);
            helper(currDigit+1, map, ans, digits, s);
            s.deleteCharAt(s.length()-1);
        }
        
    }
}