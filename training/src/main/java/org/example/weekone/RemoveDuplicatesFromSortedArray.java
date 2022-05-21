package org.example.weekone;

import java.util.Arrays;

/**
 * @Author: Haibo
 * @Date: 2022/2/27 13:51
 */
public class RemoveDuplicatesFromSortedArray {
    public static int solution(int nums[]){
        int cur = 0, p = 0;
        while (p < nums.length){
            if (nums[cur] != nums[p]){
                nums[++cur] = nums[p];
            }
            p++;
        }
        System.out.format("cur: %d, p: %d\n", cur, p);
        System.out.println(Arrays.toString(nums));
        return  cur + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 4, 4, 4, 5, 5, 6};
        RemoveDuplicatesFromSortedArray.solution(nums);
    }
}
