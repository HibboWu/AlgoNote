package com.hbo.sort;

public class Code13_HeapSort {

    public static void heapSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        // 将整个数组转化成大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0){
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    // 某个数现在处在index位置， 往上继续移动 logN
    public static void heapInsert(int[] arr, int index){
        while (arr[index] > arr[(index - 1) / 2]){
            swap(arr, index, (index - 1) / 2);
            index = (index - 1)/2;
        }
    }

    // 某个数现在处在index位置， 往下继续移动
    public static void heapify(int[] arr, int index, int heapSize){
        int left = index * 2 + 1; // 左孩子的下标
        while (left < heapSize){
            // 两个孩子中， 谁的值大， 把下标给largest
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left]
                            ? left + 1 : left;
            // 父和较大的孩子之间 谁的值大 把下标给largest
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index)
                break;
            swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
    }
}
