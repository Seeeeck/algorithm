package m10.d24;

import java.util.ArrayList;
import java.util.List;

public class PrimList {
    // 将一个数分解位质数因子 n=a*b*c*d...  不包含1
    public static List<Integer> prim(int n){
        List<Integer> prims = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0){
                prims.add(i);
                n /= i;
            }
        }
        return prims;
    }


    public static void main(String[] args) {
        System.out.println(prim(102));
    }
}
