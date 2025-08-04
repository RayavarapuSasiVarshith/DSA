// Memoization
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        String t = new StringBuilder(s).reverse().toString();
        int dp[][] = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j] = -1;
            }
        }
        return lcs(s,t,n-1,n-1,dp);
    }
    public int lcs(String s,String y,int i,int j,int dp[][]){
        if(i <0|| j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i) == y.charAt(j)){
            dp[i][j] = 1+lcs(s,y,i-1,j-1,dp);
            return dp[i][j];
        }
        dp[i][j] = Math.max(lcs(s,y,i-1,j,dp),lcs(s,y,i,j-1,dp));
        return dp[i][j];
    }
}
