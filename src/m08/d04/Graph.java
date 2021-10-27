package m08.d04;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    // key:点的编号
    HashMap<Integer,Node> nodes;
    HashSet<Edge> edges;

    public Graph() {
        this.nodes = new HashMap<>();
        this.edges = new HashSet<>();
    }
}
