package com.wenny.learn.base.algorithm.array;

public class SearchInsertIndex {

    //二分查找：有序数组，假设无重复数据，返回目标数值角标位置，若不存在返回目标元素插入位置

    /*
    * left和right是基于数组已有角标，要考虑特殊情况：目标元素大于数组最后一个元素，即插入位置为nums.length
    * */
    public int searchInsert(int[] nums, int target) {

        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if(target > nums[len - 1]){
            return len;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left < right){
            int mid = left + right >>> 1;
            if(target > nums[mid]){
                left = mid + 1;

            }else{
                right = mid ;
            }
        }
        return left;

    }
}
