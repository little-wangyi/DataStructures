package Stack;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(5);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);
        System.out.println(arrayStack.isFull());
        arrayStack.pop();
        arrayStack.push(6);
        arrayStack.show();
    }
}

class ArrayStack{
    private int[] Stack;
    private int top;
    private int maxSize;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1;
        this.Stack = new int[maxSize];
    }

    public boolean isFull(){
        return top == maxSize - 1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int num){
        if(isFull()){
           throw new RuntimeException("栈已满");
        }
        Stack[++top] = num;
    }

    public int pop(){
        if(isEmpty()){
            throw new RuntimeException("栈为空");
        }
        int num = Stack[top--];
        return num;
    }

    public void show(){
        if(isEmpty()){
            throw new RuntimeException("栈为空");
        }
        for (int i = top; i >=0 ; i--) {
            System.out.printf("栈%d的值为%d\n",i,Stack[i]);
        }
    }

    public int getTop() {
        return top;
    }
}