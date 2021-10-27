package m07.d29;



public class FullBinaryTree {
    /**
     * 是否是满二叉树
     */
    private static boolean isFull(Node head){
        if (head == null){
            return true;
        }
        ReturnType res = process(head);
        // 2的height次方 -1
        return 1 << res.height -1 == res.nodes;
    }

    private static ReturnType process(Node x){
        if (x == null){
            return new ReturnType(0,0);
        }
        ReturnType leftReturnType = process(x.left);
        ReturnType rightReturnType = process(x.right);
        int height =  Math.max(leftReturnType.height, rightReturnType.height) + 1;
        int nodes = leftReturnType.nodes + rightReturnType.nodes + 1;
        return new ReturnType(height,nodes);
    }

    private static class ReturnType{
        int height;
        int nodes;

        public ReturnType(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
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
