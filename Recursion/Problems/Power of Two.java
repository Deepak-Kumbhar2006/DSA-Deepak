public class String_space {
    public static void main(String[] args) {
        int n = 32;
//        System.out.println(isPowerOfTwo1(n));
//        System.out.println(isPowerOfTwo(n));
      
      // Learned How to do power of any number
        double result = Math.pow(2, 31);   
        System.out.println((long)result);
    }

    public static boolean isPowerOfTwo(int n) {
        if(n==1){
            return true;
        }
        else if(n<1 || n%2!=0){
            return false;
        }
        return isPowerOfTwo(n/2);
    }    
  // This code will not accept all the cases because i <= 2^31 is wrong format as you have given through constains of LC.
  // why it is wrong format explain upside
  public static boolean isPowerOfTwo1(int n){
            for(int i = 1;  i <= (2^31); i = i << 1)
                if(n == i)
                    return true;
            return false;
        }
}
