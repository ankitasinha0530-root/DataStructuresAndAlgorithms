package com.dsalgos.practice.dynamicProgramming;

public class FibonacciWithMemo {

    public static void main(String[] args){

        int n = 20;
        System.out.println(fibonacciWithMemo(n, new long[n+1]));

        System.out.println("Fibonnacci with Memo one = " + fibonacciWithMemo(5, new long[5+1]));
        System.out.println("Fibonnacci with Memo two = " + fibonacciWithMemo(30, new long[30+1]));
        System.out.println("Fibonnacci with Memo three = " + fibonacciWithMemo(50, new long[50+1]));
        System.out.println("Fibonnacci with Memo three = " + fibonacciWithMemo(100, new long[100+1]));
    }

    private static long fibonacciWithMemo(int n, long[] memo) {

        if(n < 2) return n;

        if(memo[n] > 0) return memo[n];

        long nm1 = fibonacciWithMemo(n - 1, memo);
        long nm2 = fibonacciWithMemo(n - 2, memo);
        long fib = nm1 + nm2;

        memo[n] = fib;
        return fib;
    }


}
