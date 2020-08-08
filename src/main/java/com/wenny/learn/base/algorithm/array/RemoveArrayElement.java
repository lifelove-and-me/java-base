package com.wenny.learn.base.algorithm.array;


import java.util.concurrent.atomic.AtomicInteger;

public class RemoveArrayElement {



    private int removeElement(int [] params,int removeTarget){
        int start = -1 ;
        int next = -1 ;

        for(int i = 0; i < params.length ; i ++){
            if(start < 0 && params[i] == removeTarget){
                start = i;
                next = start + 1;

            }
            if(start > 0 && next < params.length && params[next] != removeTarget ){

                params[start] = params[next];
                start ++;


            }
            next ++;

        }
        for(int i =0 ; i < start; i ++ ){
            System.out.println("------ array data is " + params[i]);

        }
        return start ;



    }

    private int removeTargetElement(int[] nums,int val){
        int p ;
        int q = 0;
        for( p = 0; p < nums.length ; p ++){
            if( nums[p] != val){
                nums[q] = nums[p];
                q ++;

            }

        }
        for(int i =0 ; i < q; i ++ ){
            System.out.println("------ array data is " + nums[i]);

        }
        return  q;


    }

    private int removeElements(int[] nums,int val){
        int p ;
        int q = 0;
        int n = nums.length;
        for( p = 0; p < n ; p ++){
            if( nums[p] == val){
                nums[q] = nums[p - 1];
                q ++;
                p --;


            }

        }
        for(int i =0 ; i < q; i ++ ){
            System.out.println("------ array data is " + nums[i]);

        }
        return q;

    }
    public int removeElementB(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }



    public static void main(String[] args){
        RemoveArrayElement arrayElement = new RemoveArrayElement();
        int[] params = new int[]{0,1,2,2,3,0,4,2};
        System.out.println("----"+ arrayElement.removeElement(params,2) );

    }
}
