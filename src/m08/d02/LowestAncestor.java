package m08.d02;

public class LowestAncestor {
    /**
     * 返回o1和o2的最初的共同祖先节点
     * @param head
     * @param o1
     * @param o2
     * @return
     */
    public static Node lowestAncestor(Node head,Node o1,Node o2){
        if (head == null || head == o1 || head == o2){
            return head;
        }
        Node left = lowestAncestor(head.left,o1,o2);
        Node right = lowestAncestor(head.right,o1,o2);
        if (left != null && right != null){
            return head;
        }
        return left != null ? left : right;
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
