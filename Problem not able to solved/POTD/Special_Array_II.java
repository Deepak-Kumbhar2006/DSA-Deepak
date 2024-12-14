class Solution {
  /*
  Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 105
1 <= queries.length <= 105
queries[i].length == 2
0 <= queries[i][0] <= queries[i][1] <= nums.length - 1
*/

  // Time Limit Exceed, Because this is brute force solution time complexity becomes - queries*10^5
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] lis = new boolean[queries.length];
        for(int i = 0; i< lis.length; i++){
            // if(nums.length==1){
            //     lis[i] = true;
            //     break;
            // }
            for (int j = 0; j < queries[i].length-1; j++) {
                int from = queries[i][j];
                int to = queries[i][j+1];
                if(from==to){
                    lis[i] = true;
                    break;
                }
                for (int k = from; k < to ; k++) {
                    if (nums[k]%2 == nums[k+1]%2){
                        lis[i] = false;
                        break;
                    }
                    else lis[i] = true;
                }
            }
        }
        return lis;
    }

  // More optimize solution 
  // first make a array of cummulitive sum 
  // watch video of codestorywithMIK yt special array II
}
