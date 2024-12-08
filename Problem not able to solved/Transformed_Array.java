package Problems;

import java.util.Arrays;

public class Transformed_Array {
    public static void main(String[] args) {
        System.out.println(3%5);
        int[] nums = {-17, 17, 0};
        System.out.println(Arrays.toString(construcTransformedArray(nums)));
    }
    public static int[] construcTransformedArray(int[] nums){
        int n = nums.length;
        int[] target = new int[n];
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
