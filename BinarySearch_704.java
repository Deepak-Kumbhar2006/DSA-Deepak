package Problems;

public class BinarySearch_704 {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 12;
        System.out.println(search(nums, target));
        System.out.println(search3(nums, target, 0, nums.length-1));
    }
    public static int search(int[] nums, int target) {
        return search2(nums, target, 0 , nums.length-1);
    }
    static int ans = -1;
    static int search2(int[] nums, int target, int start, int end){
        if (start<=end) {
            int mid = start + (end - start) / 2;
            if (target < nums[mid]) {
                return search2(nums, target, start, mid - 1);
            } else if (target > nums[mid]) {
                return search2(nums, target, mid + 1, end);
            }
            else ans = mid;
        }
        return ans;
    }
    static int search3(int[] nums, int target, int start, int end){
        if (start>end){
            return -1;
        }
        int mid = (start + end)/2;
        if (nums[mid]==target){
            return mid;
        }
        else if(nums[mid]>target){
            return search3(nums, target, start, mid-1);
        }
        else return search3(nums, target, mid+1, end);
    }
}