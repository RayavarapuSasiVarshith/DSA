class Solution {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()+1][word2.length()+1];
        for(int a[] : dp){
            Arrays.fill(a,-1);
        }
        int x = lcs(word1,word2,0,0,dp);
        return word1.length()-x + word2.length()-x;
    }
    public int lcs(String x,String y,int i,int j,int dp[][]){
        if(i == x.length() || j == y.length()){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(x.charAt(i) == y.charAt(j)){
            dp[i][j] = 1+lcs(x,y,i+1,j+1,dp);
        }
        else{
            dp[i][j] = Math.max(lcs(x,y,i+1,j,dp),lcs(x,y,i,j+1,dp));
        }
        return dp[i][j];
    }
}
