package m10.d24;

/**
 * 顺时针旋转二维数组90度
 */
public class Rotate {

    public static void rotate(int[][] matrix){
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR < dR){
            rotateEdge(matrix,tR++,tC++,dR--,dC--);
        }
    }

    /**
     * 转边框
     * @param m 原数组
     * @param a 左上角行号
     * @param b 左上角列号
     * @param c 右下角行号
     * @param d 右下角列号
     */
    private static void rotateEdge(int[][] m,int a,int b,int c,int d){
        int tmp;
        for (int i = 0; i < d - b; i++) {
            tmp = m[a][b+i];
            m[a][b+i] = m[c-i][b];
            m[c-i][b] = m[c][d-i];
            m[c][d-i] = m[a+i][d];
            m[a+i][d] = tmp;
        }
    }
}
