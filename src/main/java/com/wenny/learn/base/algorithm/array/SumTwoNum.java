package com.wenny.learn.base.algorithm.array;


import java.util.HashMap;
import java.util.Map;

public class SumTwoNum {


    private int[] printTargetIndex(int nums[],int target){

        int[] result = new int[2];

        for(int i =0; i< nums.length - 1; i ++){

            int paramA = nums[i];

            for(int j = i + 1 ; j < nums.length ; j ++){
                int paramB = nums[j];
                if(paramA == target - paramB){
                    result[0] = i;
                    result[1] = j;

                }

            }

        }
        return result;

    }

    //以空间换时间
    private int[] searchSumIndex(int nums[],int target){
        Map<Integer,Integer> dataMap = new HashMap<>();
        for(int i = 0 ; i <nums.length ; i ++){
            dataMap.put(nums[i],i);

        }
        for(int i = 0 ; i <nums.length ; i ++){
            if(dataMap.containsKey(target - nums[i]) && dataMap.get(target - nums[i]) != i ){
                return new int[]{i,dataMap.get(target - nums[i])};

            }

        }

        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args){
        SumTwoNum twoNum = new SumTwoNum();
        int[] array = new int[]{1,4,3,2,5,8};
        for(int index :  twoNum.searchSumIndex(array,8)){
            System.out.println("two index is " + index);

        }

    }
}
