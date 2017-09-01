package leetcode;

import java.util.Arrays;

/**
 * Created by bao on 2017/8/25.
 */
public class Test {
    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for(int i=0; i<len-1; i++ ){
            for(int j= len -1;j>i;j--){
                int sum = nums[i]+nums[j];
                if(sum==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    public static void  main(String args[]){
       int[] nums = {2,  -21, -15, -1,-2,-3,-6,-7,-8 ,7,-9,-10};
       int target = 9;
       int[] result = twoSum(nums, target);
       System.out.println(Arrays.toString(result));
    }
}
