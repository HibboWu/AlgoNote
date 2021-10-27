package org.example.weekone;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Haibo
 * @Date: 2022/3/24 16:07
 */
public class SpiralMatrix {

    public static List<Integer> solution(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int up = 0, down = m - 1;
        int left = 0, right = n - 1;

        while (true) {
            for (int i = left; i <= right; i++) list.add(matrix[up][i]);
            if (++up > down) break;
            for (int i = up; i < down; i++) list.add(matrix[i][right]);
            if (--right < left) break;
            for (int i = right; i >= left; i--) list.add(matrix[down][i]);
            if (--down < up) break;
            for (int i = down; i <= up; i--) list.add(matrix[i][left]);
            if(++left > right) break;
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        System.out.println(list.size());
    }

}
