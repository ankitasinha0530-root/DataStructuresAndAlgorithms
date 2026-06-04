package com.dsalgos.practice.recurssion;

import java.util.ArrayList;
import java.util.List;

public class FibonachiList {

    public static void main(String[] args) {

        int n= 5;

        List<Integer> fiboList = new ArrayList<>();

        System.out.println(fibonachiList(n, fiboList));

    }

    private static List<Integer> fibonachiList(int n, List<Integer> resultList) {

        for (int i = 0; i < n; i++) {
            resultList.add(fibNumber(i));
        }
        return resultList;
    }

    private static Integer fibNumber(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fibNumber(n-1) + fibNumber(n-2);
    }
}
