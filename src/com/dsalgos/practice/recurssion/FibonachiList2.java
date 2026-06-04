package com.dsalgos.practice.recurssion;

import java.util.HashSet;
import java.util.Set;

public class FibonachiList2 {

    public static void main(String[] args) {

        int n= 5;

        Set<Integer> fiboList = new HashSet<>();

        System.out.println(fibonachiList(n, fiboList));

        System.out.println("fiboList == " + fiboList);

    }

    private static int fibonachiList(int n, Set<Integer> resultList) {

        if(n <= 0){
            resultList.add(0);
            return 0;
        }
        if(n == 1 ){
            resultList.add(1);
            return 1;
        }

        int num = fibonachiList(n-1, resultList) + fibonachiList(n-2, resultList);

        resultList.add(num);

        return num;
    }
}
