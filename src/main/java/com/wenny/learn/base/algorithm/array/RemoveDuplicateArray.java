package com.wenny.learn.base.algorithm.array;

public class RemoveDuplicateArray {

    /**
     *
     * @param params
     * @return
     * @coment 有序数据去重，双指针去重
     */
    private int removeDuplicateData(int[] params){




        int cur = 0;
        int next = 1;
        for(int i =0 ; i < params.length ; i++){

            if(next < params.length && params[cur] != params[next] ){

                cur ++;
                params[cur] = params[next];

            }
            next ++;




        }
        for(int i =0; i <= cur ; i ++){

            System.out.println("remove array is "+ params[i]);

        }
        return cur + 1;


    }

    /**
     *
     * @param params
     * @return
     * @comment 考虑数据完全不存在重复项优化
     */
    private int optimisizeRemoveDuplicate(int[] params ){

        int cur = 0;

        for(int i = 1 ; i < params.length ; i++){

            if( params[cur] != params[i]  ){

                cur ++;
                if(i - cur > 1) params[cur] = params[i];

            }


        }
        return  cur + 1;

    }
    public static void main(String[] args){
        RemoveDuplicateArray duplicateArray = new RemoveDuplicateArray();
        int[] arrays = new int[] {1,2,3,3,4,6} ;

        System.out.println("array length is "+duplicateArray.removeDuplicateData(arrays) );

    }
}
