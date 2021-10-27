package m10.d12;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 对数组的每一个数,求其左边与右边最近的比其大的数的下标
 */
public class LeftRightMaxNumber {
    public static int[][] lrMaxNumber(int[] arr){
        if (arr == null || arr.length == 0){
            return new int[0][0];
        }
        LinkedList<Node> stack = new LinkedList<>();
        int[][] res = new int[arr.length][3];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek().value < arr[i]){
                midProcess(stack,res,i);
            }
            if (!stack.isEmpty() && stack.peek().value == arr[i]){
                Node node = stack.peek();
                while (node.next != null){
                    node = node.next;
                }
                node.next = new Node(i,arr[i]);
            }else {
                stack.push(new Node(i,arr[i]));
            }
        }
        while(!stack.isEmpty()){
            midProcess(stack,res,-1);
        }
        return res;
    }

    private static void midProcess(LinkedList<Node> stack,int[][] res,int i){
        Node cur = stack.pop();
        Node node = stack.peek();
        while (node != null && node.next != null){
            node = node.next;
        }
        int[] ints = new int[]{cur.value,node == null ? -1 : node.index,i};
        while(cur != null){
            res[cur.index] = ints;
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        int[][] ints = lrMaxNumber(new int[]{5, 3, 8, 0, 6, 65, 5, 9,5});
        System.out.println(Arrays.deepToString(ints));
    }

    private static class Node{
        private final int index;
        private final int value;
        private Node next;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
