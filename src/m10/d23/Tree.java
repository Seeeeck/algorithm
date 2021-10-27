package m10.d23;

/**
 * 二叉树每个节点有一个int值,计算从根结点到叶节点到所有路径中值最大到值
 */
public class Tree {

    public static int max(Node node){
        return process(node);
    }


    private static int process(Node node){
        if (node == null){
            return 0;
        }
        int left = process(node.left);
        int right = process(node.right);
        return node.val + Math.max(left,right);
    }


    private static class Node{
        private final int val;
        private final Node left;
        private final Node right;

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
