package Queue.ArrayQueue;

import java.util.Scanner;

public class CircleArrayQueue {
    public static void main(String[] args) {
        int max_size = 4;
        circleArrayQueue arrayQueue = new circleArrayQueue(max_size);
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            String sc = scanner.next();
            switch (sc) {
                case "e":
                    loop = false;
                    break;
                case "a":
                    System.out.println("请输入数据");
                    try {
                        arrayQueue.addQueue(scanner.nextInt());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "s":
                    try {
                        arrayQueue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
/*                case "h":
                    try {
                        System.out.println(arrayQueue.headQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;*/
                case "g":
                    try {
                        arrayQueue.getQueue();
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

            }
        }
    }
}

class circleArrayQueue {
    //rear指向最后一个元素的后一个节点
    //空出一个元素
    private int rear;
    //front指向数组的第一个元素。
    private int front;
    private int[] array;
    private int maxSize;

    public circleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.array = new int[maxSize];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public void addQueue(int val) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        array[rear] = val;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int val = array[front];
        front = (front + 1) % maxSize;
        return val;
    }

    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        for(int i = front;i<size()+front;i++){
            System.out.printf("arr[%d] = %d\t",(i+maxSize)%maxSize,array[(i+maxSize)%maxSize]);
        }
    }

    //实际存储的数据个数
    public int size() {
        return (maxSize - front + rear) % maxSize;
    }
}