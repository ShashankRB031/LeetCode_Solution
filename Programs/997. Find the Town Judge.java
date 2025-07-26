class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        vector<int> trustScore(n + 1, 0);
        
        for (const auto& t : trust) {
            trustScore[t[0]]--; // person trusts someone
            trustScore[t[1]]++; // person is trusted
        }
        
        for (int i = 1; i <= n; ++i) {
            if (trustScore[i] == n - 1) {
                return i; // found the judge
            }
        }
        
        return -1; // no judge found
    }
};
