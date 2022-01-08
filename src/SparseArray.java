import jdk.nashorn.internal.parser.JSONParser;

import java.util.Arrays;

/*
    稀疏数组，用于存储大量为空的二维数组，例如复盘棋局
    type[count+1][3]
    type[0][0],type[0][1],type[0][2]默认用于存储行列和非0的个数（即棋盘上以及下了多少颗子）
    后续type[i][0],type[i][1],type[i][2]分别表示行,列,值.
 */

public class SparseArray {
    public static void main(String[] args) {
        int[] a = {0,0,1,0};
        int[] b = {1,0,1,0};
        int[] c = {1,0,1,1};
        int[] d = {1,0,0,0};
        int[][] arr = {a,b,c,d};
        System.out.println("原始数组");
        for(int[] arr1 : arr){
            for(int i : arr1){
                System.out.printf("%d",i);
            }
            System.out.println();
        }
        System.out.println("进行稀疏数组创建");
        //稀疏数组的创建和赋值
        int[][] sparse = sparseArray(arr);
        for (int[] arr2:sparse) {
            for(int i : arr2){
                System.out.printf("%d",i);
            }
            System.out.println();
        }
        System.out.println("复原数组");
        //复原原始数组
        int[][] ret = new int[sparse[0][0]][sparse[0][1]];
        for(int i = 1;i<sparse.length;i++){
            ret[sparse[i][0]][sparse[i][1]] = sparse[i][2];
        }

        for(int[] arrs: ret){
            for(int i : arrs){
                System.out.printf("%d",i);
            }
            System.out.println();
        }
    }

    public static int[][] sparseArray(int[][] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] != 0){
                    count++;
                }
            }
        }
        int[][] arrs = new int[count+1][3];
        int yb = 1;
        arrs[0][0] = arr.length;
        arrs[0][1] = arr[0].length;
        arrs[0][2] = count;
        for(int i =0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]!=0){
                    arrs[yb][0] = i;
                    arrs[yb][1] = j;
                    arrs[yb][2] = arr[i][j];
                    yb++;
                }
            }
        }
        return arrs;
    }
}
