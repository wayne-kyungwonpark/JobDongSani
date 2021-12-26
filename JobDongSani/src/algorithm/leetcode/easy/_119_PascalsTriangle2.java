package algorithm.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class _119_PascalsTriangle2 {
    public static void main(String[] args) {
        for (int i : getRow(1)) {
            System.out.println(i);
        }
    }

    private static int[][] dp = null;

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        if(rowIndex == 0){
            result.add(1);
            return result;
        }

        dp = new int[rowIndex + 1][rowIndex + 1];
        dp[1][0] = 1; dp[1][1] = 1;

        for (int i = 2; i <= rowIndex; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        for (int a : dp[rowIndex]){
            result.add(a);
        }
        return result;
    }
}
