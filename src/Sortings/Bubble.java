package Sortings;


import java.util.Arrays;

public class Bubble {
    public static void BubbleSort(int[] arr) {
        //冒泡优化思路
        //设置一个flag ，若一次循环结束flag没有变化，说明已经是排序完成了，可直接退出
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {3, -1, 10, 9, 20};
        BubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
