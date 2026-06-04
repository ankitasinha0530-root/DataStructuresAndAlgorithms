package com.dsalgos.practice.dynamicProgramming;

public class CountPathsToClimbStairsMemo {

    public static void main(String[] args){

        int n = 6;
        int countPathMemo = countPathsToClimbStairsMemo(n, new int[n+1]);
        System.out.println("countPath with Memo == " + countPathMemo);

        int countPathTabulation = countPathsToClimbStairsTabulation(n);
        System.out.println("countPath with Tabulation == " + countPathTabulation);
    }

    private static int countPathsToClimbStairsMemo(int n, int[] memo) {
        if(n==0) return 1;
        else if(n < 0 ) return 0;

        if(memo[n] > 0) return memo[n];

        int nm1 = countPathsToClimbStairsMemo(n-1, memo);
        int nm2 = countPathsToClimbStairsMemo(n-2, memo);
        int nm3 = countPathsToClimbStairsMemo(n-3, memo);
        int cp = nm1 + nm2 + nm3;

        memo[n] = cp;
        return cp;
    }

    private static int countPathsToClimbStairsTabulation(int n) {

        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <=n ; i++) {
            if(i == 1) dp[i] = dp[i-1];
            else if(i==2) dp[i] = dp[i-1] + dp[i-2];
            else dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }
}
