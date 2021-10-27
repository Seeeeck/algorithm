package m08.d02;

public class SuccessorNode {
    /**
     * 获得中序遍历中node的下一个node
     * @param node
     * @return
     */
    public static Node getSuccessorNode(Node node){
        if (node == null){
            return null;
        }
        if (node.right != null){
            return getMostLeftNode(node.right);
        }else {
            Node parent = node.parent;
            while (parent != null && parent.left != node){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    private static Node getMostLeftNode(Node node) {
        while (node.left != null){
            node = node.left;
        }
        return node;
    }

    private static class Node{
        int value;
        Node left;
        Node right;
        Node parent;

        public Node(int value) {
            this.value = value;
        }
    }
}
