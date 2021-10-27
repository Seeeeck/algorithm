package m08.d02;


import com.sun.xml.internal.ws.util.StringUtils;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndReconstructTree {
    /**
     * 先序遍历序列化一棵树
     */
    @NotNull
    public static String serializeTree(Node head){
        if (head == null){
            return "#_";
        }
        StringBuilder sb = new StringBuilder();
        process(head,sb);
        return sb.toString();
    }
    private static void process(Node node,StringBuilder sb){
        if (node == null){
            sb.append("#_");
            return;
        }
        sb.append(node.value).append("_");
        process(node.left,sb);
        process(node.right,sb);
    }

    /**
     * 先序遍历反序列化一棵树
     */
    public static Node reconstructTree(String str){
        if (str == null || str.length() == 0 || str.equals("#_")){
            return null;
        }
        String[] values = str.split("_");
        Queue<String> queue = new LinkedList<>(Arrays.asList(values));
        return reconPreOrder(queue);

    }

    private static Node reconPreOrder(Queue<String> queue) {
        String value = queue.poll();
        if (value == null || "#".equals(value)){
            return null;
        }
        Node node = new Node(Integer.parseInt(value));
        node.left = reconPreOrder(queue);
        node.right = reconPreOrder(queue);
        return node;
    }


    private static class Node{
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
