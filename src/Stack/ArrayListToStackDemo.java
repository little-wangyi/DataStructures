package Stack;

public class ArrayListToStackDemo {
    public static void main(String[] args) {
        SingleListMethod singleListMethod = new SingleListMethod(5);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        try {
//            singleListMethod.pop();
            singleListMethod.push(node1);
            singleListMethod.push(node2);
            singleListMethod.pop();
            singleListMethod.push(node3);
            singleListMethod.pop();
            singleListMethod.push(node4);
            singleListMethod.push(node5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(singleListMethod.isFull());
        singleListMethod.show();
    }
}

class SingleListMethod{
    Node head = new Node(-1);
    int index = -1;
    int maxSize;

    public SingleListMethod(int maxSize) {
        this.maxSize = maxSize;
    }

    public boolean isEmpty(){
        return index == -1;
    }

    public boolean isFull(){
        return index == maxSize - 1;
    }
    public void push(Node node){
        if(isFull()){
            throw new RuntimeException("栈已满");
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        index++;
    }

    public Node pop(){
        if(isEmpty()){
            throw new RuntimeException("栈为空");
        }
        Node temp = head;
        Node node;
        while(true){
            if(temp.next.next == null){
                break;
            }
            temp = temp.next;
        }
        node = temp;
        temp.next = null;
        index--;
        return node;
    }
    /*
    * 倒置链表
    */
    public void show(){
        if(isEmpty()){
            System.out.println("栈为空");
        }
        int nums = index;
        Node node = null ;
        while(true){
            if(nums == -1){
                break;
            }
            Node temp = head;
            while(temp.next != node){
               temp = temp.next;
            }
            node = temp;
            System.out.printf("栈%d=%d\n",nums--,node.value);
        }
    }
}

class Node {
    int value ;
    Node next ;

    public Node(int value) {
        this.value = value;
        next = null;
    }
}
