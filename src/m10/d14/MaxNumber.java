package m10.d14;
public class MaxNumber {
    // 返回int符号位取反
    private static int sign(int n){
        return flip((n >> 31) & 1);
    }
    // 保证n为1或0  1 -> 0 , 0 -> 1
    private static int flip(int n){
        return n ^ 1;
    }


    public static int max(int a,int b){
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int difSab = sa ^ sb;
        int sameSab = flip(difSab);
        // ab符号相反&&a为正   或者    ab符号相同&&a-b为负   则返回a
        int returnA = difSab * sa + sameSab * sc;
        int returnB = flip(returnA);
        return returnA * a + returnB * b;
    }

}
