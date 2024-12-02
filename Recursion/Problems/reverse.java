package Problems;

import java.util.Arrays;

public class reverse {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
    }
    public static void reverseString(char[] s){
        change(s, 0, s.length-1);
        System.out.println(Arrays.toString(s));
    }
    public static void change(char[] s,int start, int end){
        if (start==end){
            return;
        }
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        change(s, start+1, end-1);
    }
}
