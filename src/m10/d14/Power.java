package m10.d14;

public class Power {

    public static boolean is2Power(int n){
        return (n & (n -1)) == 0;
    }

    public static boolean is4Power(int n){
        return is2Power(n) && (n & 0x55555555) != 0;
    }
}
