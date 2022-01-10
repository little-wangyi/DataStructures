package Sortings;

import java.util.Arrays;

public class Select {
    public static void SelectSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length - 1; j++) {
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
        SelectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
