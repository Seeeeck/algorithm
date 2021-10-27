package util;

public class MyMath {
    public static int[][] matrixPower(int[][] a,int b){
        if (a == null || a.length != a[0].length){
            throw new IllegalMatrixException();
        }
        int[][] res = new int[a.length][a.length];
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }
        int[][] t = a;
        for (; b != 0; b >>= 1){
            if((b & 1) != 0){
                res = multiMatrix(res,t);
            }
            t = multiMatrix(t,t);
        }
        return res;
    }

    public static int[][] multiMatrix(int[][] m1, int[][] m2) {
        if (m1 == null || m2 == null || m1[0].length != m2.length){
            throw new IllegalMatrixException();
        }
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }


    private static class IllegalMatrixException extends RuntimeException{
        public IllegalMatrixException() {
            this("IllegalMatrix");
        }

        public IllegalMatrixException(String message) {
            super(message);
        }
    }
}
