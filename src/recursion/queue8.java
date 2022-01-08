package recursion;

public class queue8 {
    public int count = 0;
    public int maxSize = 8;
    public int array[] = new int[maxSize];

    public void check(int n) {
        if (n == maxSize) {
            print();
            return;
        }
        for (int i = 0; i < maxSize; i++) {
            array[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    public void print() {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //Math.abs(n-i)==Math.abs(array[n]-array[i])用于判断是否在一条斜线上
            if (array[i] == array[n] || Math.abs(n-i)==Math.abs(array[n]-array[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        queue8 queue8 = new queue8();
        queue8.check(0);
        System.out.println("一共有"+queue8.count+"种解法");
    }


}
