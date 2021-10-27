package m08.d04;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 前提:无向图
 * 最小生成数:所有的点联通时的最小权重值
 */
public class Prim {

    private static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight-o2.weight;
        }
    }

    public static Set<Edge> prim(Graph graph){
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        Set<Edge> res = new HashSet<>();
        Set<Node> book = new HashSet<>();

        //森林的情况
        for (Node node : graph.nodes.values()) {
            if (!book.contains(node)){
                book.add(node);
                priorityQueue.addAll(node.edges);
                Edge cur;
                while (!priorityQueue.isEmpty()){
                    cur = priorityQueue.poll();
                    Node to = cur.to;
                    if (!book.contains(to)){    //不含有的时候就是新的点
                        book.add(to);
                        res.add(cur);
                        priorityQueue.addAll(to.edges);
                    }
                }
            }
        }
        return res;
    }
}
