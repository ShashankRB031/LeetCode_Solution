class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        helper(candidates, 0, target, 0, res, temp);
        return res;
    }

    public void helper(int[] candidates, int index, int target, int sum, List<List<Integer>> res, List<Integer> temp) {
        if(sum==target)
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        else if(sum>target) return;
        for(int i=index;i<candidates.length;i++)
        {
            sum+=candidates[i];
            temp.add(candidates[i]);
            helper(candidates, index, target, sum, res, temp);
            sum-=candidates[i];
            temp.remove(temp.size()-1);
            index++;
        }
    }
}