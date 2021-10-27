package m09.d28;

/**
 * 左右上下相连的为一个岛 数有多少个岛 1为陆地,0为海
 */
public class Islands {
    public static int countIsland(int[][] map){
        if(map == null || map.length == 0 || map[0].length == 0){
            return 0;
        }
        final int N = map.length;
        final int M = map[0].length;
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1){
                    res++;
                    infect(map,i,j,N,M);
                }
            }
        }
        return res;
    }

    /**
     * 把与其相连的陆地变为2
     * @param map
     * @param i
     * @param j
     * @param N
     * @param M
     */
    private static void infect(int[][] map, int i, int j, int N, int M) {
        if(i < 0 || i >= N || j < 0 || j >= M || map[i][j] != 1){
            return;
        }
        map[i][j] = 2;
        infect(map, i+1, j, N, M);
        infect(map, i-1, j, N, M);
        infect(map, i, j+1, N, M);
        infect(map, i, j-1, N, M);
    }
}
