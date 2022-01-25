package Sortings;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
//        int[] arr = {1,2,3,4,3,5,4};
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format = sdf.format(date);
        System.out.println("before:" + format);
        quickSort2(arr, 0, arr.length - 1);
        Date date1 = new Date();
        String format1 = sdf.format(date1);
        System.out.println("after" + format1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(left + right) / 2];
        int temp = 0;
        while (l < r) {
            while (arr[l] < pivot) {
                l += 1;
            }
            while (arr[r] > pivot) {
                r -= 1;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == pivot) {
                r -= 1;
            }
            if (arr[r] == pivot) {
                l += 1;
            }
        }
        if (l == r) {
            l += 1;
            r -= 1;
        }
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }
    }

    private static void quickSort2(int[] arr, int begin, int end) {
        if (begin < end) {
            int l = begin;
            int r = end;
            int key = arr[begin];
            while (l < r) {
                while (l < r && arr[r] > key) {
                    r--;
                }
                if (l < r) {
                    arr[l] = arr[r];
                    l++;
                }
                while(l<r && arr[l]<key){
                    l++;
                }
                if(l<r){
                    arr[r] = arr[l];
                    r--;
                }
            }
            arr[l] = key;
            quickSort2(arr,begin,l-1);
            quickSort2(arr,l+1,end);
        }

    }
}
