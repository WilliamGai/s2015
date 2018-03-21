package m2017;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by bao on 2017/8/25.
 */
public class TwoSum {
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
    //人家的代码
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> res = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            res.put(nums[i], i);
        }

        for(int j = 0; j < nums.length; j++) {
            int difference = target - nums[j];
            if(res.containsKey(difference) && res.get(difference) != j) {
                return new int[] {j, res.get(difference)};
            }
        }
        throw new IllegalArgumentException("No solution");
    }
}
