package m08.d04;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class GraphDfs {
    /**
     * 深度遍历
     * @param node
     */
    public static void printDfs(Node node){
        if (node == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        Set<Node> set = new HashSet<>();
        stack.push(node);
        set.add(node);
        System.out.println(node.value);
        Node cur;
        while (!stack.isEmpty()){
            cur = stack.pop();
            for (Node next : cur.nexts) {
                if (!set.contains(next)){
                    stack.push(cur);
                    stack.push(next);
                    set.add(next);
                    System.out.println(next);
                    break;
                }
            }
        }
    }
}
