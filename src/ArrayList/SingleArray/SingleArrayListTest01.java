package ArrayList.SingleArray;

public class SingleArrayListTest01 {
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
        System.out.println(getLength(node1));
        System.out.println(findLastIndexNode(node1,6));
    }
    //方法：获取到单链表的节点的个数(如果是带头结点的链表，需求不统计头节点)
    public static int getLength(Node head){
        int count =1;
        if(head.next == null){
            return 1;
        }
        Node temp = head;
        while(true){
            if(temp.next == null) {
                break;
            }
                count ++;
            temp = temp.next;
        }
        return count;
    }
    //查找单链表中的倒数第 k 个结点 【新浪面试题】
    //思路
//1. 编写一个方法，接收 head 节点，同时接收一个 index
//2. index 表示是倒数第 index 个节点
//3. 先把链表从头到尾遍历，得到链表的总的长度 getLength
//4. 得到 size 后，我们从链表的第一个开始遍历 (size-index)个，就可以得到
//5. 如果找到了，则返回该节点，否则返回 nulll
    public static Node findLastIndexNode(Node head, int index) {
        Node temp = head;
        int length = getLength(head);
        int n = 0;
        if(index > length){
            return null;
        }
        if(index == length){
            return head;
        }
        for(int i = 0;i<length-index;i++){
            temp = temp.next;
        }
        return temp;
    }
}



class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}