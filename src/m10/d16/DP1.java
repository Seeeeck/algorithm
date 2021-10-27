package m10.d16;

public class DP1 {
    // 一个正数列表,用里面的数组成N,最少需要几个数来组成
    // coins.length < 1000
    public static int minCoin1(int[] coins,int N){
        int[][] dp = new int[coins.length+1][N+1];
        for (int i = 0; i < coins.length+1; i++) {
            for (int j = 0; j < N+1; j++) {
                dp[i][j] = -1;
            }
        }
        int count = process(coins, 0, N,dp);
        return count >= 1000 ? -1 : count;
    }

    /**
     * coins[i...]自由选择,返回能组成n的最小coin数
     * @param coins
     * @param i 当前下标
     * @param n 当前还需要的钱数
     * @return
     */
    private static int process(int[] coins, int i, int n,int[][] dp) {
        if (n < 0){
            return 1000;
        }
        if (dp[i][n] != -1){
            return dp[i][n];
        }
        if (n == 0){
            dp[i][n] = 0;
        }else if (i == coins.length){
            dp[i][n] = 1000;
        }else {
            dp[i][n] = Math.min(process(coins,i + 1,n,dp),1 + process(coins,i + 1,n-coins[i],dp));
        }
        return dp[i][n];
    }

    public static int minCoin2(int[] coins,int N){
        int[][] dp = new int[coins.length+1][N+1];
        for (int i = 0; i < coins.length+1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < N + 1; i++) {
            dp[coins.length][i] = 1000;
        }
        for (int i = coins.length - 1; i >= 0; i--) {
            for (int n = 1; n < N + 1; n++) {
                int p1 = dp[i+1][n];
                int p2 = n-coins[i] < 0 ? 1000 : dp[i+1][n-coins[i]];
                dp[i][n] = Math.min(p1,1+p2);
            }
        }
        return dp[0][N] >= 1000 ? -1 : dp[0][N];
    }



    public static void main(String[] args) {
        System.out.println(minCoin2(new int[]{2, 5, 100,5,3,5,4,4,2,6,8}, 1252));

    }


}
