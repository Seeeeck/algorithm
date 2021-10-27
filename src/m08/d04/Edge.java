package m08.d04;

// 边,from和to对调的两条边可以表示一条无向边
public class Edge {
    // 权重,可以表达边的距离之类
    int weight;
    Node from;
    Node to;

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}
