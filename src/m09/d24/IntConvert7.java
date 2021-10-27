package m09.d24;

public class IntConvert7 {
    public static int reverse(int x) {
        double limit = Math.pow(2,31);
        if (x == 0 || x<=-limit || x > limit-1){
            return 0;
        }
        boolean plus = x > 0;
        int a,b,c=0,res=0;
        int[] arr = new int[10];
        x = Math.abs(x);
        while(x != 0){
            a = x % 10;
            x = x / 10;
            arr[c++] = a;
        }
        b = c;

        for(int i=0;i<c;i++){
            double num = arr[i]*Math.pow(10,--b);
            if(limit - res < num){
                return 0;
            }
            res += num;
        }
        return plus ? res : -res;
    }

    public static void main(String[] args) {
        reverse(-2147483648);
    }
}
