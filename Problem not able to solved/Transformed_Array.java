package Problems;

import java.util.Arrays;

// This is an problem link : https://leetcode.com/problems/transformed-array/
public class Transformed_Array {
    public static void main(String[] args) {
        int[] nums = {-1, 4, -1};
        System.out.println(Arrays.toString(construcTransformedArray(nums)));
    }
    public static int[] construcTransformedArray(int[] nums){
        int n = nums.length;
        int[] target = new int[n];
		// This for loop is very important to understand how to move array in circular path. 
        for (int i = 0; i <  n; i++) {
            int steps = nums[i];
            int targetIndex = (i+steps)%n;
            if (targetIndex<0){
                targetIndex += n;
            }
            target[i] = nums[targetIndex];
        }
        return target;
    }
}
		
// O/P
// target = {-1, -1, 4}

