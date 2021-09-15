package com.hbo.sort;

/**
 * @Author: Haibo
 * @Date: 2021/9/9 21:05
 *
 * 小和问题
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和
 * [1,3,4,2,5]
 * 1左边比1小的数，没有
 * 3左边比3小的数，1
 * 4左边比4小的数，1，3
 * 2左边比2小的数，1
 * 5左边比5小的数，1，3，4，2
 * 所以小和为 1+1+3+1+1+3+4+2=16
 */
public class Code10_SmallSum {

    public static int smallSum(int[] arr){
        if (arr == null || arr.length  < 2){
            return 0;
        }
        return process(arr, 0, arr.length - 1);
    }

    public static int process(int[] arr, int l, int r){
        if (l == r){
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return process(arr, l , mid)
                + process(arr, mid + 1, r)
                + merge(arr, l, mid, r);
    }

    public static int merge(int[] arr, int l, int m, int r){
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m + 1;
        int res = 0;

        while (p1 <= m && p2 <= r){
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= m){
            help[i++] = arr[p1++];
        }

        while (p2 <= r){
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[l + j] = help[j];
        }
        return res;
    }

}
