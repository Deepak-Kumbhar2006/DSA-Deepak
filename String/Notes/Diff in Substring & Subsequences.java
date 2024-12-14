Difference between Subsequences and substring
String str = "abc";
String[] Subsequences  = {"a",  "b", "c", "ab", "ac", "bc", "abc"}  // non contiguous   total = (2^n - 1)
String[] Substring = {"a", "ab" ,"abc", "b", "bc", "c"}    // contiguous    total = n*(n+1)/2


sorting a substring:
String s = "abcaba";
char[] temps.toCharArray();
Arrays.sort(s.toCharArray());
Arrays.sort(temp);
String s_sort = new String(temp);
System.out.println(s_sort);

Q] Why can't we write this sorting string code of number of line in just one line like this: 

String = new String(Arrays.sort(s.toCharArray()));

Ans] Arrays.sort() does not have any return type. It is void method
