package m07.d22;
//单链表判断是否是回文
public class LinkedHuiWen {
    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        head.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
    }

    public static boolean isHuiWen(Node head){
        if (head == null){
            return true;
        }
        int size = 0;
        Node slow = head;
        Node next = head.getNext();
        while (next != null ) {
            size++;
            if (size % 2 == 0){
                slow = slow.getNext();
            }
            next = next.getNext();
        }
        if (size == 1){
            return true;
        }
        size = size % 2 == 0 ? size / 2 : size / 2 + 1;
        Node[] nodes = new Node[size];
        int top = 0;
        next = slow.getNext();
        while (next != null){
            nodes[top++] = next;
            next = next.getNext();
        }
        next = head.getNext();
        while (top > 0){
            if (nodes[--top].getValue() != next.getValue()){
                return false;
            }
        }
        return true;

    }

    public static void printLinkedList(Node head){
        if (head == null){
            return;
        }
        Node next = head.getNext();
        while (next != null){
            System.out.println(next);
            next = next.getNext();
        }
    }

    private static class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }



}



