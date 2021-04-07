package algorithm.leetcode.medium;

import java.util.Arrays;

public class _74_SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = -1;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int[] firsts = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            firsts[i] = matrix[i][0];
        }
        int index1 = Arrays.binarySearch(firsts, target);
        if(index1 >= 0){
            return true;
        }
        if(index1 == -1){
            return false;
        }

        int index2 = Arrays.binarySearch(matrix[Math.abs(index1) - 2], target);
        if(index2 >= 0){
            return true;
        }

        return false;
    }
}
