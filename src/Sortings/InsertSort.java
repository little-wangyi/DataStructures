package Sortings;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/*
 * 插入排序，就是将已经插入过后的数组作为有序数组，未插入的数组不停的进行插入
 * 时间复杂度为O(n)
 */
public class InsertSort {
    public static void main(String[] args) {
        int arr[] = new int[]{103, 113, 21, 4, 3};

        //创建随即数
        int arr2[] = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr2[i] = (int)(Math.random()*80000);
        }

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = sdf.format(date);
        System.out.println("排序前的时间是:" + date1Str);
        insertSort(arr2);
        Date date2 = new Date();
        String date2Str = sdf.format(date2);
        System.out.println("排序后的时间是:"+date2Str);
//        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        //for循环进行n-1次
        for (int i = 1; i < arr.length; i++) {
            int insertIndex = i - 1;
            int insertVal = arr[i];
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                //每当没有确定insertVal的位置时，比他大的数全部后移动一位
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertVal;
        }
    }
}
