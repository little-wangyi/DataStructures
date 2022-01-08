package Queue.ArrayQueue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        int max_size = 10;
        arrayQueue arrayQueue = new arrayQueue(max_size);
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            String sc = scanner.next();
            switch (sc) {
                case "e":
                    loop = false;
                    break;
                case "a":
                    arrayQueue.addQueue(scanner.nextInt());
                    break;
                case "s":
                    try {
                        arrayQueue.showQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "h":
                    try {
                        System.out.println(arrayQueue.headQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
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

class arrayQueue {
    int rear;
    int front;
    int maxSize;
    int[] array;

    public arrayQueue(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
        rear = -1;
        front = -1;
    }

    public void addQueue(int value) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        rear++;
        array[rear] = value;
    }

    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        front++;
        return array[front];
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < maxSize; i++) {
            System.out.printf("%d,", array[i]);
        }
        System.out.println("]");
    }

    public int headQueue() {
        System.out.println("front=" + front + ",rear = " + rear);
        if (isEmpty()) {
            throw new RuntimeException("数组为空不能出值");
        }
        return array[front + 1];
    }
}
