package OOP_three;
public class AWTExample{
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 55;
        System.out.println(binary(nums, target));
    }
    public static int binary(int[] nums, int target){
//        return target(0, nums.length-1, nums, target);
        return target2(0, nums.length-1, nums, target);
    }
    static int target(int start,int end, int[] nums, int target){
        if (start > end ){
            return -1;
        }
        int mid = (start+end)/2;
        if(target == nums[mid]){
            return mid;
        }
        else if(target<nums[mid]){
            return target(0,mid-1, nums, target);
        }
        else return target(mid+1, end, nums, target);
    }
    static int target2(int start,int end, int[] nums, int target){
        int mid = (start+end)/2;
        if (start>end){
            return -1;
        }
        else if(target > nums[mid]){
            return target2(mid+1, end, nums, target);
        }
        else if(target<nums[mid]){
            return target2(start,mid-1, nums, target);
        }
        else return mid;
    }
}
