package Problems;

import java.util.Arrays;

public class reverse {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
    }
    public static void reverseString(char[] s){
        method1(s, 0, s.length-1);
        System.out.println(Arrays.toString(s));
    }
    public static void method1(char[] s,int start, int end){
        if (start==end){
            return;
        }
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        method1(s, start+1, end-1);
    }
    // ------- Method2/ 0 ms runtime/ best method --------
    public void reverseString2(char[] s) {
        if (s != null && s.length > 0) {
            for (int l = 0, r = s.length - 1; l < r; l++, r--) {
                char tmp = s[l];
                s[l] = s[r];
                s[r] = tmp;
            }
        }
    }
}
