package m10.d26;

/**
 * 字符串只能右0或者1组成,要求每个0的左边一定是1,给定位数N,求共有多少种排法
 */
public class DP1 {
    public static int count1(int N){
        if (N <= 0){
            return -1;
        }
        return process1(N,0,0);
    }

    private static int process1(int N, int index, int preChar){
        if(index == N){
            return 1;
        }
        int ans = 0;
        if(preChar == 1){
            ans = process1(N,index+1,1) + process1(N,index+1,0);
        }else if (preChar == 0){
            ans = process1(N,index+1,1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int a = 5;
        System.out.println(count1(a)==count3(a));

    }

    public static int count2(int N){
        if (N <= 0){
            return -1;
        }
        int[][] dp = new int[N+1][2];
        dp[N][0] = dp[N][1] = 1;
        for (int index = N-1; index >= 0; index--) {
            dp[index][0] = dp[index+1][1];
            dp[index][1] = dp[index+1][1] + dp[index+1][0];
        }
        return dp[0][0];
    }

    public static int count3(int N){
        if (N <= 0){
            return -1;
        }
        int[] dp = new int[2];
        dp[0] = dp[1] = 1;
        int pre1;
        for (int i= 0; i < N; i++) {
            pre1 = dp[1] + dp[0];
            dp[0] = dp[1];
            dp[1] = pre1;
        }
        return dp[0];
    }
}