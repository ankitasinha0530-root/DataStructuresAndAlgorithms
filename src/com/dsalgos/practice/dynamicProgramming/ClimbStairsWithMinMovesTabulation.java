package com.dsalgos.practice.dynamicProgramming;

public class ClimbStairsWithMinMovesTabulation {

    public static void main(String[] args){

        int n = 10;
        int[] jumps = {2, 4, 3, 0, 2, 4, 2, 3, 2, 2};
        System.out.println("Count paths with minm moves = " + countminMoves(n, jumps));

        int n1 = 15;
        int[] jumps1 = {2, 4, 3, 0, 2, 4, 2, 3, 2, 2, 3, 0, 3, 1, 1};
        System.out.println("Count paths with minm moves = " + countminMoves(n1, jumps1));

        int n2 = 5;
        int[] jumps2 = {2, 2, 1, 0, 2};
        System.out.println("Count paths with minm moves = " + countminMoves(n2, jumps2));

    }

    private static int countminMoves(int n, int[] jumps) {

        Integer[] dp = new Integer[n+1];

        dp[n] = 0;

        for (int i = n-1; i >=0; i--) {
            if (jumps[i] > 0) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= jumps[i] && i + j < dp.length; j++) {
                    if (dp[i + j] != null) {
                        min = Math.min(min, dp[i + j]);
                    }
                }
                if (min != Integer.MAX_VALUE) {
                    dp[i] = min + 1;
                } else {
                    dp[i] = null;
                }

            }
        }
        return dp[0] == null ? 0 : dp[0];
    }
}
