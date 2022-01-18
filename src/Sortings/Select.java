package Sortings;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Select {
    public static void SelectSort(int arr[]) {
        for (int i = 0; i < arr.length -1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index] > arr[j]) {
                    index = j;
                }
            }
            if (index != i) {
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {-1, -2, 3, 2, 9};
//        SelectSort(arr);
//        System.out.println(Arrays.toString(arr));
        //创建随即数
        int arr2[] = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr2[i] = (int)(Math.random()*80000);
        }
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = sdf.format(date);
        System.out.println("排序前的时间是:" + date1Str);
        SelectSort(arr2);
        Date date2 = new Date();
        String date2Str = sdf.format(date2);
        System.out.println("排序后的时间是:"+date2Str);
        System.out.println(Arrays.toString(arr2));
    }
}
