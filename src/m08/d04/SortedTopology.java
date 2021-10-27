package m08.d04;

import java.util.*;

public class SortedTopology {
    /**
     * 前提:有向图,无环
     * 拓扑排序
     * 包的依赖关系,包的加载顺序
     * @param graph
     * @return
     */
    public static List<Node> sortedTopology(Graph graph){
        // key:Node   value:Node的入度
        HashMap<Node,Integer> inMap = new HashMap<>();
        // 入度为0的队列
        Queue<Node> zeroInQueue = new LinkedList<>();
        for (Node node : graph.nodes.values()) {
            inMap.put(node,node.in);
            if (node.in == 0){
                zeroInQueue.add(node);
            }
        }
        List<Node> res = new ArrayList<>();
        Node cur;
        while (!zeroInQueue.isEmpty()){
            cur = zeroInQueue.poll();
            res.add(cur);
            for (Node next : cur.nexts) {
                inMap.put(next,inMap.get(next)-1);
                if (inMap.get(next) == 0){
                    zeroInQueue.add(next);
                }
            }
        }
        return res;
    }
}
