// https://leetcode.com/contest/weekly-contest-443/problems/minimum-cost-to-reach-every-position/description/
class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums) list.add(n);
        int ops = 0;
        while (!isSorted(list)) {
            int minSum = Integer.MAX_VALUE, idx = -1;
            for (int i = 0; i < list.size() - 1; i++) {
                int s = list.get(i) + list.get(i + 1);
                if (s < minSum) {
                    minSum = s;
                    idx = i;
                }
            }
            list.set(idx, list.get(idx) + list.get(idx + 1));
            list.remove(idx + 1);
            ops++;
        }
        return ops;
    }

    private boolean isSorted(List<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < arr.get(i - 1)) return false;
        }
        return true;
    }
}

//    static int ans = 0;
//    public static void minimumPairRemoval(int[] nums) {
//        ArrayList<Integer> list = new ArrayList<>();
//        for (int num : nums) {
//            list.add(num);
//        }
//        ans = 0;
//        anss(list);
//        System.out.println(ans);
//    }
//    public  static void anss(List<Integer> list){
//        boolean check = true;
//        int index = 0;
//        int sum = list.get(0) + list.get(1);
//
//        for (int i = 1; i < list.size(); i++) {
//            int temp_sum = list.get(i) + list.get(i-1);
//            if (temp_sum<sum){
//                sum = temp_sum;
//                index = i-1;
//            }
//            if (list.get(i)< list.get(i-1)){
//                check = false;
//            }
//        }
//        if (!check){
//            list.set(index, sum);
//            list.remove(index+1);
//            ans++;
//            anss(list);
//        }
//    }
