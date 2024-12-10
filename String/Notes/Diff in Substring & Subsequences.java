Difference between Subsequences and substring
String str = "abc";
String[] Subsequences  = {"a",  "b", "c", "ab", "ac", "bc", "abc"}  // non contiguous   total = (2^n - 1)
String[] Substring = {"a", "ab" ,"abc", "b", "bc", "c"}    // contiguous    total = n*(n-1)/2
