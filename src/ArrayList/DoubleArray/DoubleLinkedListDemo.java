package ArrayList.DoubleArray;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(new Node(1));
        doubleLinkedList.add(new Node(2));
        doubleLinkedList.add(new Node(3));
        doubleLinkedList.add(new Node(4));
        try {
            doubleLinkedList.del(2);
            doubleLinkedList.show();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class DoubleLinkedList {
    Node head = new Node(0);

    public void show() {
        Node temp = head;
        if (temp == null) {
            throw new RuntimeException("双向链表为空");
        }
        while (temp.next  != null) {
            System.out.println(temp.next);
            temp = temp.next;
        }
    }

    public void add(Node node) {
        Node temp = head;
        if (temp.next == null) {
            temp.next = node;
            node.pre = temp;
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        node.pre = temp;
        temp.next = node;
    }

    public void update(Node node) {
        Node temp = head;
        if (temp.next == null) {
            throw new RuntimeException("列表为空");
        }
        while (temp.next != null) {
            if (temp.next.val == node.val) {
                temp.next = node;
                node.pre = temp;
                node.next.pre = node;
                return;
            }
            temp = temp.next;
        }
        throw new RuntimeException("没有找到");
    }
    public void del(int val){
        Node temp = head;
        if(temp.next == null ){
            throw new RuntimeException("列表为空");
        }
        while(temp.next != null){
            //列表末尾直接删除，不然会空指针

            if(temp.next.val == val){
                if(temp.next.next == null){
                    temp.next = null;
                    break;
                }
                temp.next = temp.next.next;
                temp.next.next.pre = temp;
            }
            temp = temp.next;
        }
    }

}

class Node {
    int val;
    Node pre;
    Node next;

    public Node(int val) {
        this.val = val;
        this.pre = null;
        this.next = null;
    }

    public Node(int val, Node pre, Node next) {
        this.val = val;
        this.pre = pre;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val + "}";
    }
}
