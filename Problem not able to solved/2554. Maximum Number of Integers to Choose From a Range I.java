class solution{
  // Correct one
  public int maxCount(int[] banned, int n, int maxSum) {
        int[] arr = new int[10001];
        for(int i=0; i<banned.length; i++){
            arr[banned[i]]=1;
        }

        long sum=0;
        int cnt=0;
        for(int i=1; i<=n; i++){
            if(arr[i]==1){continue;}
            sum+=i;
            if(sum>maxSum){
               break;
            }
            cnt++;
        }

        return cnt;
    }

  // Wrong one 
  public static int maxCount1(int[] banned, int n, int maxSum) {
        Arrays.sort(banned);
        int sum = 0;
        int count = 0;
        int k = 0;
        for(int i = 1;i<=n; i++){
            for(int j = k; j<banned.length; j++){
                if(i==banned[j]){
                    k++;
                    break;
                }
                else if(i<=(maxSum-sum)){
                    sum += i;
                    count++;
                    break;
                }
            }
        }
        return count;
    }
  public static int maxCount1(int[] banned, int n, int maxSum) {
    Set<Integer> bannedset = new HashSet<>();
    for(int num : banned){
      bannedset.add(num);
    }
    int count = 0, sum = 0;
    for(int i = 1; i<=n; i++){
      if(bannedset.contains(i){
        sum += i;
        if(sum> maxSum){
          break;
        }
        count++;
      }
    }
    return count;
  }
  
}
