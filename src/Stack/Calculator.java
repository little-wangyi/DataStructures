package Stack;

public class Calculator {
    public static void main(String[] args) {
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 opStack = new ArrayStack2(10);
        String expression = "3*2+4/2+9";
        int num1 = 0;
        int num2 = 0;
        char[] ch;
        int res = 0;
        ch = expression.toCharArray();
        int len = ch.length;
//        System.out.println(len);
        for (int i = 0; i < len; i++) {
            if (numStack.isNum(ch[i])) {
                numStack.push(ch[i] - 48);
            } else if (opStack.isOperator(ch[i])) {
                if (opStack.isEmpty()) {
                    //符号栈为空直接压入
                    opStack.push(ch[i]);
                } else {
                    //符号栈不为空
                        while(true) {
                            if (!opStack.isEmpty() && opStack.priority(ch[i]) < opStack.priority(opStack.peek())) {
                                //若当前要插入的优先级比符号栈顶低，
                                // 将从数字栈弹出两个数字，
                                //并通过符号栈顶的进行操作
                                num1 = numStack.pop();
                                num2 = numStack.pop();
                                int op = opStack.pop();
                                //计算
                                res = numStack.cal(num1, num2, op);

                                numStack.push(res);

                            }else{
                                break;
                            }
                        }
                        opStack.push(ch[i]);

                    }

                }
            if (i == len - 1) {
                while (true) {
                    if (opStack.isEmpty()) {
                        break;
                    }
                    num1 = numStack.pop();
                    num2 = numStack.pop();
                    int op = opStack.pop();
                    //计算
                    res = numStack.cal(num1, num2, op);
                    numStack.push(res);
                }
            }
            }


                System.out.println(numStack.array[numStack.top]);
    }
}

class ArrayStack2 {
    int top = -1;
    int[] array;
    int maxSize;

    public boolean isOperator(char ch) {
        return ch == '*' || ch == '/' || ch == '+' || ch == '-';
    }

    public boolean isNum(char ch) {

        if (ch - 48 >= 0 && ch - 48 <= 9) {
            return true;
        }
        return false;
    }

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int cal(int num1, int num2, int op) {
        switch (op) {
            case '*':
                return num1 * num2;
            case '/':
                return num2 / num1;
            case '+':
                return num1 + num2;
            case '-':
                return num2 - num1;
            default:
                throw new RuntimeException("运算有误");
        }
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public void push(int v) {
        if (isFull()) {
            throw new RuntimeException("栈已满");
        }
        array[++top] = v;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        return array[top];
    }

    public int priority(int ch) {
        switch (ch) {
            case '*':
                return 1;
            case '/':
                return 1;
            case '+':
                return 0;
            case '-':
                return 0;
            default:
                return -1;
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        int value = array[top];
        top--;
        return value;
    }

    public void show() {
        int index = top;
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        while (true) {
            if (index != -1) {
                System.out.printf("%d\n", array[index--]);
            }else{
                break;
            }
        }
    }
}
