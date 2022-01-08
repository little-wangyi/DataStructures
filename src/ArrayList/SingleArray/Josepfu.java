package ArrayList.SingleArray;

public class Josepfu {
    public static void main(String[] args) {
        CircleLinkedList circleLinkedList = new CircleLinkedList();
        circleLinkedList.addBoy(5);
//        circleLinkedList.show();
        circleLinkedList.countBoy(1,2,5);
    }
}

class CircleLinkedList{
    private Boy first = null;
    private Boy curBoy = null;
    public void addBoy(int nums){
        if(nums < 1){
            throw new RuntimeException("人数不能小于一人");
        }
        for (int i = 1; i <=nums ; i++) {
            Boy boy = new Boy(i);
            //如果是第一个节点
            if(first == null){
                first = boy;
                first.setNext(first);
                curBoy = first;
            }else{
                //如果不是第一个节点，
                // 那么将最后一个男孩与本次要插入的男孩相连，并让最后一个男孩的指针指向第一个指针
                //形成首尾相连
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    public void show(){
        curBoy = first;
        if(first == null){
            throw new RuntimeException("当前未插入男孩");
        }
        while(true){
            System.out.printf("这是第%d个小孩\n",curBoy.getNo());

            if(curBoy.getNext() == first){
                break;
            }
            curBoy = curBoy.getNext();
        }
    }
    /*
    * startNums表示开始的男孩号码
    * countNums表示数几位
    * nums代表男孩总数
    * */
    public void countBoy(int startNums,int countNums,int nums){
        if(first == null || startNums < 1 || startNums > nums){
            throw new RuntimeException("输入参数有误");
        }
        //helper指针用于指向first的前一个元素，
        // 即链表最后一个元素
        //当helper == first时表示只剩下最后一个孩子
        Boy helper = first;
        while(true){
            if(helper.getNext() == first){
                break;
            }
            helper = helper.getNext();
        }
        //找到开始报数的男孩的位置
        for (int i = 0; i < startNums - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        while(helper != first) {
            for (int i = 0; i < countNums - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println("此时出圈的小孩为"+first.getNo()+"号");
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后一个场内的小孩是"+first.getNo());
    }
}

class Boy{
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
        this.next = null;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}