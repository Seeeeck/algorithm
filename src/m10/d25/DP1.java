package m10.d25;

/**
 * 给一个正数数组,每个值只能用一个,如何组合能获得不超过k的最大值,求最大值是多少
 */
public class DP1 {
    public static int maxScore1(int[] arr,int k){
        return process1(arr,0,k);
    }

    private static int process1(int[] arr,int index,int nokori){
        if(nokori < 0){
            return -1;
        }
        if (index == arr.length){
            return 0;
        }
        int p1 = process1(arr, index + 1, nokori - arr[index]);
        if (p1 != -1){
            p1 += arr[index];
        }
        int p2 = process1(arr, index + 1, nokori);
        return p1 > nokori ? p2 : Math.max(p1,p2);
    }

    public static int maxScore2(int[] arr,int k){
        int[][] dp = new int[arr.length+1][k+1];
        for (int i = 0; i < arr.length+1; i++) {
            for (int j = 0; j < k+1; j++) {
                dp[i][j] = -1;
            }
        }
        return process2(arr,0,k,dp);
    }

    private static int process2(int[] arr, int index, int nokori, int[][] dp) {
        if(nokori < 0){
            return -1;
        }
        if (dp[index][nokori] != -1){
            return dp[index][nokori];
        }
        if (index == arr.length){
            dp[index][nokori] = 0;
        }else{
            int p1 = process1(arr, index + 1, nokori - arr[index]);
            if (p1 != -1){
                p1 += arr[index];
            }
            int p2 = process1(arr, index + 1, nokori);
            dp[index][nokori] = p1 > nokori ? p2 : Math.max(p1,p2);
        }
        return dp[index][nokori];
    }


    public static int maxScore3(int[] arr,int k){
        if (k < 0){
            return -1;
        }
        int[][] dp = new int[arr.length+1][k+1];
        for (int index = arr.length-1; index >= 0; index--) {
            for (int nokori = 0; nokori < k+1; nokori++) {
                int p1 = -1;
                if (nokori - arr[index] >= 0){
                    p1 = dp[index + 1][nokori - arr[index]];
                }
                if (p1 != -1){
                    p1 += arr[index];
                }
                int p2 = dp[index + 1][nokori];
                dp[index][nokori] = p1 > nokori ? p2 : Math.max(p1,p2);
            }
        }
        return dp[0][k];
    }

    public static void main(String[] args) {
        System.out.println(maxScore3(new int[]{1,2,62,55,2,70,5}, 11));
    }
}
