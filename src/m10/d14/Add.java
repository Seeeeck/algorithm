package m10.d14;

public class Add {

    public static int add(int a,int b){
        int sum = a;
        while (b != 0){
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    public static int negNum(int n){
        return add(~n,1);
    }

    public static int minus(int a,int b){
        return add(a,negNum(b));
    }

    public static int multi(int a,int b){
        int res = 0;
        while (b != 0){
            if ((b & 1) != 0){
                res = add(res,a);
            }
            a <<= 1;
            // 无符号右移 以0补位
            b >>>= 1;
        }
        return res;
    }

    public static int div(int a,int b){
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 31; i > -1; i = minus(i,1)) {
            if ((x >> i) >= y){
                res |= 1 << i;
                x = minus(x,y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

    public static boolean isNeg(int n){
        return (n >>> 31) == 1;
    }

    public static void main(String[] args) {
        System.out.println(div(50, 2));
    }
}
