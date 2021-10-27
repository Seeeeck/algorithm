package m08.d04;

import java.util.*;

/**
 * 前提:无向图
 * 最小生成数:所有的点联通时的最小权重值
 */
public class Kruskal {
    /**
     * 完成集合的合并
     */
    private static class UnionFind{
        private HashMap<Node, List<Node>> setMap;

        public UnionFind(Collection<Node> nodes) {
            setMap = new HashMap<>();
            for (Node node : nodes) {
                ArrayList<Node> nodeList = new ArrayList<>();
                nodeList.add(node);
                setMap.put(node,nodeList);
            }
        }

        public boolean isSameSet(Node from,Node to){
            return setMap.get(from) == setMap.get(to);
        }

        public void unionSet(Node from,Node to){
            List<Node> fromSet = setMap.get(from);
            List<Node> toSet = setMap.get(to);
            fromSet.addAll(toSet);
            setMap.put(to,fromSet);
        }
    }

    private static class EdgeComparator implements Comparator<Edge>{
        @Override
        public int compare(Edge o1, Edge o2) {
            return o1.weight-o2.weight;
        }
    }

    /**
     * 返回满足最小生成数的边集合
     * @param graph
     * @return
     */
    public static Set<Edge> kruskalMST(Graph graph){
        UnionFind unionFind = new UnionFind(graph.nodes.values());
        //小根堆 弹出最小权重值的边
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(new EdgeComparator());
        priorityQueue.addAll(graph.edges);
        Set<Edge> res = new HashSet<>();
        Edge cur;
        while (!priorityQueue.isEmpty()){
            cur = priorityQueue.poll();
            if (!unionFind.isSameSet(cur.from, cur.to)) {
                res.add(cur);
                unionFind.unionSet(cur.from, cur.to);
            }
        }
        return res;
    }

}
