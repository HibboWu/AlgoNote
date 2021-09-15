package com.hbo.sort;

/**
 * @Author: Haibo
 * @Date: 2021/9/11 11:53
 *
 * 逆序对
 * 在一个数组中，左边的数如果比右边的数大，则这两个数构成一个逆序对，请打印所有逆序对
 * [1,3,4,2,5]
 * 1右边比1小的数
 *
 * [1, 3, 4] [2, 5]
 * left = 0, mid = 2, mid+1 = 3, right = 4
 * p1 -> A[0], p2 -> B[0]
 * p1 < p2
 * copy A[0] => help[1]
 * p1++, p1 -> A[1], p2 -> B[0]
 * p1 > p2
 * inverseSum(B[0]) =  mid - p1 + 1
 * copy B[0] => help[1,2]
 * p2++, p1 -> A[1], p2 -> B[1]
 */
public class Code11_ReversePairsSum {

    public static int ReversePairsSum(int[] arr){
        if (arr == null || arr.length < 2)
            return 0;

        return process(arr, 0, arr.length-1);
    }

    public static int process(int[] arr, int left, int right){
        if (left == right)
            return 0;

        int mid = left + ((right - left) >> 1);

        return process(arr, left, mid) + process(arr, mid + 1, right) + mergeAndCount(arr, left, mid, right);
    }

    public static int mergeAndCount(int[] arr, int left, int mid, int right){
        int p1 = left;
        int p2 = mid + 1;
        int i = 0;
        int count = 0;
        int[] help = new int[right - left + 1];

        while (p1 <= mid && p2 <= right){
            if (arr[p1] <= arr[p2]){
                help[i++] = arr[p1++];
            }else {
                count += mid - p1 + 1;
                help[i++] = arr[p2++];
            }
        }

        while (p1 <= mid){
            help[i++] = arr[p1++];
        }

        while (p2 <= right){
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++){
            arr[left + j] = help[j];
        }

        return count;
    }
}
