class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int dp[][] = new int[m+1][n+1];
        char x[][] = new char[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    x[i][j] = 'd';
                }
                else if(dp[i][j-1]>=dp[i-1][j]){
                    dp[i][j] = dp[i][j-1];
                    x[i][j] = 'l';
                }
                else{
                    dp[i][j] = dp[i-1][j];
                    x[i][j] = 'u';
                }
            }
        }
        int i = m;
        int j = n;
        StringBuilder sb = new StringBuilder();
        while(j>0 && i>0){
            if(x[i][j] == 'd'){
                sb.append(str1.charAt(i-1));
                j--;
                i--;
            }
            else if(x[i][j] == 'u'){
                i--;
            }
            else{
                j--;
            }
        }
        i = 0;
        j = 0;
        String s = sb.reverse().toString();
        StringBuilder ans = new StringBuilder();
        for(char ch : s.toCharArray()){
            while(str1.charAt(i)!=ch){
                ans.append(str1.charAt(i));
                i++;
            }
            while(str2.charAt(j)!=ch){
                ans.append(str2.charAt(j));
                j++;
            }
            ans.append(ch);
            i++;
            j++;
        }
        while(i<m){
            ans.append(str1.charAt(i));
            i++;
        }
        while(j<n){
            ans.append(str2.charAt(j));
            j++;
        }
        return ans.toString();
    }
}
