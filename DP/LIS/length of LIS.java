//Approach 1 ---> Standard
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
        }

        int ans = 0;
        for (int x : dp){
          ans = Math.max(ans, x);
        }
        return ans;
    }
}
//Approach 2 ---> Binary Search
class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> tail = new ArrayList<>();
        for(int num : nums){
            int idx = Collections.binarySearch(tail, num);
            if (idx < 0){
                idx = - (idx + 1);
            }
            if(idx == tail.size()){
                tail.add(num);
            }
            else{
                tail.set(idx, num);
            }
        }
        return tail.size();
    }
}
