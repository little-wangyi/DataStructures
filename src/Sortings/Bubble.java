package Sortings;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

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
        //创建随即数
        int arr2[] = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr2[i] = (int)(Math.random()*80000);
        }

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = sdf.format(date);
        System.out.println("排序前的时间是:" + date1Str);
        BubbleSort(arr2);
        Date date2 = new Date();
        String date2Str = sdf.format(date2);
        System.out.println("排序后的时间是:"+date2Str);
//        BubbleSort(arr);
        System.out.println(Arrays.toString(arr2));
    }
}
