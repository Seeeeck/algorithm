package m07.d28;

import m07.d29.BalancedBinaryTree;

public class BST {

    private static int preValue = Integer.MIN_VALUE;
    /**
     * 检查是否是搜索二叉树
     * 搜索二叉树: 对于任何子树,一定是左孩子 ＜ 它 ＜ 右孩子
     */
    private static boolean isBST(Node head){
        if (head == null){
            return true;
        }
        boolean isLeftBST = isBST(head.left);
        if (!isLeftBST){
            return false;
        }
        if (head.value <= preValue){
            return false;
        }else {
            preValue = head.value;
        }
        return isBST(head.right);
    }

    private static boolean isBST2(Node head){
        if (head == null){
            return true;
        }
        return process(head).isBST;
    }

    private static ReturnType process(Node x){
        if (x == null){
            return null;
        }
        ReturnType leftReturnType = process(x.left);
        ReturnType rightReturnType = process(x.right);
        int minValue = x.value;
        int maxValue = x.value;
        boolean isBST = true;
        if (leftReturnType != null){
            minValue = Math.min(minValue,leftReturnType.minValue);
            maxValue = Math.max(maxValue,leftReturnType.maxValue);
            if (!leftReturnType.isBST || leftReturnType.maxValue >= x.value){
                isBST = false;
            }
        }
        if (rightReturnType != null){
            minValue = Math.min(minValue,rightReturnType.minValue);
            maxValue = Math.max(maxValue,rightReturnType.maxValue);
            if (!rightReturnType.isBST || rightReturnType.minValue <= x.value){
                isBST = false;
            }
        }
        return new ReturnType(maxValue,minValue,isBST);
    }

    private static class ReturnType{
        int maxValue;
        int minValue;
        boolean isBST;

        public ReturnType(int maxValue, int minValue, boolean isBST) {
            this.maxValue = maxValue;
            this.minValue = minValue;
            this.isBST = isBST;
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
