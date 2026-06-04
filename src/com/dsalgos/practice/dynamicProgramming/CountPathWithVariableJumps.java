package com.dsalgos.practice.dynamicProgramming;

public class CountPathWithVariableJumps {

    public static void main(String[] args) {

        int n = 6;
        int[] jumps = {2, 3, 0, 4, 1, 2};

        int countPathWithVariableJumps = countPathWithVariableJumpsTabulation(n, jumps);
        System.out.println("countPathWithVariableJumps == " + countPathWithVariableJumps);

        int n1 = 10;
        int[] jumps1 = {2, 3, 0, 3, 1, 2, 3, 2, 1, 4};

        int countPathWithVariableJumps1 = countPathWithVariableJumpsTabulation(n1, jumps1);
        System.out.println("countPathWithVariableJumps == " + countPathWithVariableJumps1);

    }

    private static int countPathWithVariableJumpsTabulation(int n, int[] jumps) {
        // top down approach
        int[] dp = new int[n + 1];
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j <= jumps[i] && i + j < dp.length; j++) {
                dp[i] += dp[i + j];
            }
        }

        return dp[0];
    }
}
