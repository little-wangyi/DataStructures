package ArrayList.SingleArray;

public class SingleArrayListDemo {
    public static void main(String[] args) {
        singArrayList single = new singArrayList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(5);
        try {
            single.add2(node1);
            single.add2(node4);
            single.add2(node3);
            single.add2(node2);
            single.add2(node5);
//            single.del(5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        single.show();
        System.out.println(SingleArrayListTest01.getLength(node1));
    }
}

class singArrayList {
    Node head = new Node(-1);

    public void add(Node nextNode) {
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = nextNode;
    }
    //将数值插入到指定的位置
    public void add2(Node node) {
        Node temp = head;
        while(true){
            //当处于链表最后一位直接插入
            if(temp.next == null){
                break;
            }
            //当值相同时,抛出异常
            if(temp.next.val == node.val){
                throw new RuntimeException("已经有相同的值了");
            }else if(temp.next.val > node.val){
                //若插入的值小于当前的值
                break;
            }
            temp = temp.next;
        }
            node.next = temp.next;
            temp.next = node;
    }

    public void show() {
        Node temp = head.next;
        if (temp == null) {
            System.out.println("列表为空");
        }
        while (temp != null) {
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    public void del(int n){
        Node temp = head;
        while(true){
            if(temp.next == null) {
                throw new RuntimeException("没有找到");
            }
            if(temp.next.val == n){
                break;
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }
    public void addByOrder(Node node) {
        //因为头节点不能动，因此我们仍然通过一个辅助指针(变量)来帮助找到添加的位置
        //因为单链表，因为我们找的 temp 是位于 添加位置的前一个节点，否则插入不了
        Node temp = head;
        boolean flag = false; // flag 标志添加的编号是否存在，默认为 false
        while (true) {
            if (temp.next == null) {//说明 temp 已经在链表的最后
                break; //
            }
            if (temp.next.val > node.val) { //位置找到，就在 temp 的后面插入
                break;
            } else if (temp.next.val == node.val) {//说明希望添加的 heroNode 的编号已然存在
                flag = true; //说明编号存在
                break;
            }
            temp = temp.next; //后移，遍历当前链表
        }
//判断 flag 的值
        if (flag) { //不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", node.val);
        } else {
//插入到链表中, temp 的后面
            node.next = temp.next;
            temp.next = node;
        }
    }
}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val + "}";
    }
}

