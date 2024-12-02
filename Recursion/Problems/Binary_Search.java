package OOP_three;
public class AWTExample{
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 55;
        System.out.println(binary(nums, target));
    }
    public static int binary(int[] nums, int target){
//        return target(0, nums.length-1, nums, target);
        return method2(0, nums.length-1, nums, target);
    }
    static int method1(int start,int end, int[] nums, int target){
        if (start > end ){
            return -1;
        }
        int mid = (start+end)/2;
        if(target == nums[mid]){
            return mid;
        }
        else if(target<nums[mid]){
            return method1(0,mid-1, nums, target);
        }
        else return method1(mid+1, end, nums, target);
    }
    static int method2(int start,int end, int[] nums, int target){
        int mid = (start+end)/2;
        if (start>end){
            return -1;
        }
        else if(target > nums[mid]){
            return method2(mid+1, end, nums, target);
        }
        else if(target<nums[mid]){
            return method2(start,mid-1, nums, target);
        }
        else return mid;
    }

    // ---- 0_ms runtime-----
    public void method3(char[] s) {
        if (s != null && s.length > 0) {
            for (int l = 0, r = s.length - 1; l < r; l++, r--) {
                char tmp = s[l];
                s[l] = s[r];
                s[r] = tmp;
            }
        }
    }
}
