package m07.d29;


import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {

    /**
     * 是否是完全二叉树
     * @param head
     * @return
     */
    public static boolean isCompleteBinaryTree(Node head){
        if (head == null){
            return true;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        Node cur,l,r;
        //是否遇到过子左右不双全的节点
        boolean leaf = false;
        while (!queue.isEmpty()){
            cur = queue.poll();
            l = cur.left;
            r = cur.right;
            if ((leaf && (l != null || r != null)) || (l == null && r != null)){
                return false;
            }
            if (l != null){
                queue.add(l);
            }
            if (r != null){
                queue.add(r);
            }
            if (l == null || r == null){
                leaf = true;
            }
        }
        return true;
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
