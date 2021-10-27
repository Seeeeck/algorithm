package m07.d28;

import m07.d22.LinkedHuiWen;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TreeMaxWidth {
    /**
     * 输出树的最大宽度
     */
    public static void maxWidth(Node head){
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        HashMap<Node,Integer> levelMap = new HashMap<>();
        int curLevel = 1;
        int curLevelWidth = 0;
        int maxWidth = Integer.MIN_VALUE;
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            int curNodeLevel = levelMap.get(cur);
            if (curNodeLevel == curLevel){
                curLevelWidth++;
            }else {
                maxWidth = Math.max(maxWidth,curLevelWidth);
                curLevelWidth = 1;
                curLevel ++;
            }
            if (cur.left != null){
                queue.add(cur.left);
                levelMap.put(cur.left,curLevel+1);
            }
            if (cur.right != null){
                queue.add(cur.right);
                levelMap.put(cur.right,curLevel+1);
            }
        }
        System.out.println(maxWidth);
    }



    public static void maxWidth2(Node head){
        Node curEnd = head;
        Node nextEnd = null;
        int curLevelWidth = 0;
        int maxWidth = Integer.MIN_VALUE;
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()){
            Node cur = queue.poll();
            if (cur.left != null){
                queue.add(cur.left);
                nextEnd = cur.left;
            }
            if (cur.right != null){
                queue.add(cur.right);
                nextEnd = cur.right;
            }
            curLevelWidth++;
            if (cur == curEnd){
                maxWidth = Math.max(curLevelWidth,maxWidth);
                curLevelWidth = 0;
                if (nextEnd != null){
                    curEnd = nextEnd;
                    nextEnd = null;
                }
            }
        }
        System.out.println(maxWidth);

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
