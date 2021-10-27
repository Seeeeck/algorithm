package m07.d29;

public class BalancedBinaryTree {

    /**
     * 是否是平衡二叉树
     * 平衡二叉树: 对于任何子树,它的左右子树的差要小于等于1
     * @param head
     * @return
     */
    public static boolean isBalanced(Node head){
        if (head == null){
            return true;
        }
        return process(head).isBalanced;
    }

    private static ReturnType process(Node x){
        if (x == null){
            return new ReturnType(true,0);
        }
        ReturnType leftReturnType = process(x.left);
        ReturnType rightReturnType = process(x.right);
        boolean isBalanced = leftReturnType.isBalanced &&
                rightReturnType.isBalanced &&
                Math.abs(leftReturnType.height- rightReturnType.height) < 2;
        int height = Math.max(leftReturnType.height, rightReturnType.height) + 1;
        return new ReturnType(isBalanced,height);
    }




    private static class ReturnType {
        boolean isBalanced;
        int height;

        public ReturnType(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
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
