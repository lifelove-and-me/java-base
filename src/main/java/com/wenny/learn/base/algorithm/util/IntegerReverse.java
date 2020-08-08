package com.wenny.learn.base.algorithm.util;

public class IntegerReverse {

    public int reverseInt(int x){
        int ans = 0;

//通过 x/10获取高位
        while(x != 0){

            int pop = x % 10;
            //考虑最长32位，数据溢出返回为0
            if(ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7 )){
                return 0;
            }
            if(ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8)){

                return 0;
            }
            ans = ans * 10 + pop;
            x = x / 10;
        }
        return ans;
    }
}
