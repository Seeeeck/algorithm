package m10.d16;

public class DP3 {
    //一个正数数组,每个值可以无限用, 要求累加起来等于aim 共有多少种方法
    public static int maxCount1(int[] arr,int aim){
        return process1(arr,0,aim);
    }

    private static int process1(int[] arr, int index, int rest) {
        if (index == arr.length){
            return rest == 0 ? 1 : 0;
        }
        int way = 0;
        for (int i = 0; i*arr[index] <= rest; i++) {
            way += process1(arr,index+1,rest-i*arr[index]);
        }
        return way;
    }

    public static int maxCount2(int[] arr,int aim){
        int[][] dp = new int[arr.length+1][aim+1];
        for (int i = 0; i < arr.length+1; i++) {
            for (int j = 0; j < aim+1; j++) {
                dp[i][j] = -1;
            }
        }
        return process2(arr,0,aim,dp);
    }

    private static int process2(int[] arr, int index, int rest,int[][] dp) {
        if (dp[index][rest] != -1){
            return dp[index][rest];
        }
        if (index == arr.length){
            dp[index][rest] = rest == 0 ? 1 : 0;
        }else {
            int way = 0;
            for (int i = 0; i*arr[index] <= rest; i++) {
                way += process2(arr,index+1,rest-i*arr[index],dp);
            }
            dp[index][rest] = way;
        }
        return dp[index][rest];
    }

    public static int maxCount3(int[] arr,int aim){
        int[][] dp = new int[arr.length+1][aim+1];
        dp[arr.length][0] = 1;
        for (int index = arr.length - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
//                int way = 0;
//                for (int i = 0; i*arr[index] <= rest; i++) {
//                    way += dp[index+1][rest-i*arr[index]];
//                }
//                dp[index][rest] = way;

                //利用观察的方法对遍历进行替代
                dp[index][rest] = dp[index+1][rest];
                if (rest - arr[index] >= 0){
                    dp[index][rest] += dp[index][rest-arr[index]];
                }
            }
        }
        return dp[0][aim];
    }
}
