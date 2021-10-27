package m08.d04;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Dijkstra {
    /**
     * 返回图中某一点到所有点的最短距离的map
     * @param head
     * @return
     */
    public static Map<Node,Integer> dijkstra(Node head){
        Map<Node,Integer> distanceMap = new HashMap<>();
        distanceMap.put(head,0);
        HashSet<Node> selectedNodes = new HashSet<>();
        Node minNode = getMinDistanceAndUnselectedNode(distanceMap,selectedNodes);
        while (minNode != null){
            int distance = distanceMap.get(minNode);
            for (Edge edge : minNode.edges) {
                Node to = edge.to;
                if (!distanceMap.containsKey(to)){
                    distanceMap.put(to,distance+edge.weight);
                }else {
                    distanceMap.put(to,Math.min(distanceMap.get(to),distance+edge.weight));
                }
            }
            selectedNodes.add(minNode);
            minNode = getMinDistanceAndUnselectedNode(distanceMap,selectedNodes);
        }
        return distanceMap;
    }

    private static Node getMinDistanceAndUnselectedNode(Map<Node, Integer> distanceMap, HashSet<Node> selectedNodes) {
        int min = Integer.MAX_VALUE;
        Node res = null;
        for (Node node : distanceMap.keySet()) {
            int distance = distanceMap.get(node);
            if (!selectedNodes.contains(node) && distance < min){
                min = distance;
                res = node;
            }
        }
        return res;
    }
}
