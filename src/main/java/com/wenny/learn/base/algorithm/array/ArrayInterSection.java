package com.wenny.learn.base.algorithm.array;

import java.util.Arrays;
import java.util.HashSet;

public class ArrayInterSection {



    //或者使用retainAll
    public int[] interSection(int[] numsA ,int[] numsB){

        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : numsA) set1.add(n);
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : numsB) set2.add(n);

        if (set1.size() < set2.size()) return set_intersection(set1, set2);
        else return set_intersection(set2, set1);
    }

    private int[] set_intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
        int [] output = new int[set1.size()];
        int idx = 0;
        for (Integer s : set1)
            if (set2.contains(s)) output[idx++] = s;

        return Arrays.copyOf(output, idx);


    }


}

