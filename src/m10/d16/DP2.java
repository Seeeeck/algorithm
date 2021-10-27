package m10.d16;

public class DP2 {
    // 象棋 棋盘高row宽col 马在0,0 要去 a,b 马必须走k步 共有多少种走法
    public static int maxCount(int row,int col,int a,int b,int k){
        return process(row,col,a,b,k,0,0);
    }

    private static int process(int row, int col, int a, int b, int k, int curRow, int curCol) {
        if (curRow < 0 || curRow > row || curCol < 0 || curCol > col){
            return 0;
        }
        if (k == 0){
            return curRow == a && curCol == b ? 1 : 0;
        }
        int p1 = process(row,col,a,b,k-1,curRow-1,curCol+2);
        int p2 = process(row,col,a,b,k-1,curRow-2,curCol+1);
        int p3 = process(row,col,a,b,k-1,curRow+1,curCol+2);
        int p4 = process(row,col,a,b,k-1,curRow+2,curCol+1);
        int p5 = process(row,col,a,b,k-1,curRow+1,curCol-2);
        int p6 = process(row,col,a,b,k-1,curRow+2,curCol-1);
        int p7 = process(row,col,a,b,k-1,curRow-1,curCol-2);
        int p8 = process(row,col,a,b,k-1,curRow-2,curCol-1);
        return p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8;
    }


    public static int maxCount2(int row,int col,int a,int b,int k){
        int[][][] dp = new int[k+1][row+1][col+1];
        for (int i = 0; i < k+1; i++) {
            for (int j = 0; j < row+1; j++) {
                for (int l = 0; l < col+1; l++) {
                    dp[i][j][l] = -1;
                }
            }
        }
        return process2(row,col,a,b,k,0,0,dp);
    }

    private static int process2(int row, int col, int a, int b, int k, int curRow, int curCol,int[][][] dp) {
        if (curRow < 0 || curRow > row || curCol < 0 || curCol > col){
            return 0;
        }
        if (dp[k][curRow][curCol] != -1){
            return dp[k][curRow][curCol];
        }
        if (k == 0){
            dp[k][curRow][curCol] = curRow == a && curCol == b ? 1 : 0;
        }else {
            int p1 = process2(row,col,a,b,k-1,curRow-1,curCol+2,dp);
            int p2 = process2(row,col,a,b,k-1,curRow-2,curCol+1,dp);
            int p3 = process2(row,col,a,b,k-1,curRow+1,curCol+2,dp);
            int p4 = process2(row,col,a,b,k-1,curRow+2,curCol+1,dp);
            int p5 = process2(row,col,a,b,k-1,curRow+1,curCol-2,dp);
            int p6 = process2(row,col,a,b,k-1,curRow+2,curCol-1,dp);
            int p7 = process2(row,col,a,b,k-1,curRow-1,curCol-2,dp);
            int p8 = process2(row,col,a,b,k-1,curRow-2,curCol-1,dp);
            dp[k][curRow][curCol] = p1 + p2 + p3 + p4 + p5 + p6 + p7 + p8;
        }
        return dp[k][curRow][curCol];
    }


    public static int maxCount3(int row,int col,int a,int b,int k){
        int[][][] dp = new int[k+1][row+1][col+1];
        dp[0][a][b] = 1;
        for (int step = 1; step <= k; step++) {
            for (int x = 0; x <= row; x++) {
                for (int y = 0; y <= col; y++) {
                    dp[step][x][y] += getValue(dp,row,col,step-1,x+1,y+2);
                    dp[step][x][y] += getValue(dp,row,col,step-1,x+1,y-2);
                    dp[step][x][y] += getValue(dp,row,col,step-1,x+2,y+1);
                    dp[step][x][y] += getValue(dp,row,col,step-1,x+2,y-1);
                    dp[step][x][y] += getValue(dp,row,col,step-1,x-1,y+2);
                    dp[step][x][y] += getValue(dp,row,col,step-1,x-1,y-2);
                    dp[step][x][y] += getValue(dp,row,col,step-1,x-2,y+1);
                    dp[step][x][y] += getValue(dp,row,col,step-1,x-2,y-1);
                }
            }
        }
        return dp[k][a][b];
    }

    private static int getValue(int[][][] dp,int row, int col, int step, int x, int y) {
        if (x < 0 || x > row || y < 0 || y > col){
            return 0;
        }
        return dp[step][x][y];
    }

    public static void main(String[] args) {
        System.out.println(maxCount3(3, 3, 3, 3, 6));
    }
}
