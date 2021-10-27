package m08.d04;

import java.util.ArrayList;

public class Node {
    int value;
    // 进度:从这个点出发点线点数量
    int in;
    // 出度:进入这个点的线的数量
    int out;
    // 从这个点出发指向的点的集合
    ArrayList<Node> nexts;
    // 从这个点出发的边线
    ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        this.in = 0;
        this.out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}
