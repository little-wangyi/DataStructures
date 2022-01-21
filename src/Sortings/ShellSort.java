package Sortings;

import java.util.Arrays;

public class ShellSort {
    //  每次通过一个gap将原始数组分成多个数组,然后通过后比前对数组进行排序
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        for(int gap = arr.length/2;gap>0;gap /=2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i-gap; j >= 0; j--) {
                    if(arr[j] > arr[j+gap]){
                        int temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
