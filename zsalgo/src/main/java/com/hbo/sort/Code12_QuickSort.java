package com.hbo.sort;

/**
 * @Author: Haibo
 * @Date: 2021/9/21 14:59
 */
public class Code12_QuickSort {

    public static void quickSort(int[] arr){
        if(arr == null || arr.length < 2)
            return;
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int L, int R) {
        if (L < R){
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, p[1] + 1, R);
        }
    }

    private static int[] partition(int[] arr, int L, int R) {
        int less = L - 1; // 定义<区的右边界
        int more = R; // 定义>区的左边界
        while (L < more){
            if (arr[L] < arr[R]) {
                // 当前值小于划分值
                swap(arr, ++less, L++);
            }else if (arr[L] > arr[R]){
                swap(arr, --more, L);
            }else {
                L++;
            }
        }
        swap(arr, more, R);
        return new int[] {less + 1, more};
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }


}
