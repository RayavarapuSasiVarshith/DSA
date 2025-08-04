class Solution {
    public int numDistinct(String s, String t) {
        int dp[][] = new int[t.length()+1][s.length()+1];
        for(int i=0;i<=s.length();i++){
            dp[t.length()][i] = 1;
        }
        for(int j=t.length()-1;j>=0;j--){
            for(int i=s.length()-1;i>=0;i--){
                if(s.charAt(i) == t.charAt(j)){
                    dp[j][i] = dp[j+1][i+1]+dp[j][i+1];
                }
                else{
                    dp[j][i] = dp[j][i+1];
                }
            }
        }
        return dp[0][0];
    }
}
