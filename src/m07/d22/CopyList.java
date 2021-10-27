package m07.d22;

public class CopyList {
    /**
     * 拷贝一份链表 额外空间复杂度O(1)
     * head有值
     * @param head
     * @return
     */
    public static Node copyList(Node head){
        if (head == null){
            return null;
        }
        Node cur = head;
        Node next;
        // 1 -> 1' -> 2 -> 2' ....
        while (cur != null){
            next = cur.next;
            cur.next = new Node(cur.value);
            cur.next.next = next;
            cur = next;
        }
        //设定rand
        cur = head;
        Node copy;
        while (cur != null){
            copy = cur.next;
            next = cur.next.next;
            copy.rand = cur.rand != null ? cur.rand.next : null;
            cur = next;
        }
        //拆分为两条链表
        Node res = head.next;
        cur = head;
        while (cur != null){
            copy = cur.next;
            next = cur.next.next;
            cur.next = next;
            copy.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }

    private static class Node{
        public int value;
        public Node next;
        //随机指向有的节点或null
        public Node rand;

        public Node(int value) {
            this.value = value;
        }
    }
}


