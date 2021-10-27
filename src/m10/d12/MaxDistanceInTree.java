package m10.d12;

/**
 * 二叉树的两个节点之间的最大距离
 */
public class MaxDistanceInTree {


    public static int maxDistance(Node head){
        return process(head).maxDistance;
    }

    private static Info process(Node x){
        if (x == null){
            return new Info(0,0);
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int maxDistance = Math.max(leftInfo.maxDistance, Math.max(rightInfo.maxDistance, leftInfo.height + rightInfo.height + 1));
        int height = leftInfo.height + rightInfo.height + 1;
        return new Info(maxDistance,height);
    }


    private static class Node{
        private Node left;
        private Node right;
    }

    private static class Info{
        private final int maxDistance;
        private final int height;

        public Info(int maxDistance, int height) {
            this.maxDistance = maxDistance;
            this.height = height;
        }
    }
}
