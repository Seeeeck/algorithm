package m09.d27;

/**
 * n*n的棋盘,要求所有的皇后不共行,不共列,不共斜线
 * 有多少种摆法
 */
public class NQueen {

    public static int num1(int n){
        if(n < 1){
            return 0;
        }
        // record[i] 代表第i行摆放在第几列
        int[] record = new int[n];
        return process1(0,record,n);
    }
    // 目前来到第i行
    // record[0..i-1]表示之前的行放的皇后位置
    private static int process1(int i, int[] record, int n) {
        // i超出边界 表示此摆法成功
        if (i == n){
            return 1;
        }
        int res = 0;
        // 尝试每一列
        for (int j = 0; j < n; j++) {
            if(isValid(record,i,j)){
                record[i] = j;
                res += process1(i+1,record,n);
            }
        }
        return res;
    }

    private static boolean isValid(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            // 两点(k,record[k]), (i,j)
            // |record[k]-j| == |k-i| 列差==行差 代表 |斜率|=0.45
            if(record[k] == j || Math.abs(record[k] - j) == Math.abs(k - i)){
                return false;
            }
        }
        return true;
    }

    /**
     * 利用位运算
     * @param n
     * @return
     */
    public static int num2(int n){
        if (n < 1 || n > 32){
            return 0;
        }
        // n位1     n=8   0000...0001111111
        int limit = n == 32 ? -1 : (1 << n) -1;
        return process2(limit,0,0,0);
    }
    // 对于 colLimit,leftDiaLimit,rightDiaLimit 1的位置不能放皇后,0的可以
    private static int process2(int limit, int colLimit, int leftDiaLimit, int rightDiaLimit) {
        if(colLimit == limit){
            return 1;
        }
        // pos 1的位置可以放皇后
        int pos = limit & (~(colLimit | leftDiaLimit | rightDiaLimit));
        int res=0;
        // pos的最右边的第一个1
        int mostRightOne;
        while (pos != 0){
            mostRightOne = pos & (~pos + 1);
            pos -= mostRightOne;
            res += process2(
                    limit,
                    colLimit | mostRightOne,
                    (leftDiaLimit | mostRightOne) << 1,
                    (rightDiaLimit | mostRightOne) >>> 1 //无符号右移
            );
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(num2(13));
    }
}
