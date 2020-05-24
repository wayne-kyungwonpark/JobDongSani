package algorithm.baekjoon.stepwise.sort;

import java.util.LinkedList;
import java.util.Scanner;

public class _1937_GreedyPanda {
    private static int n = 0;
    private static int[][] forest = null;
    private static int[][] dp = null;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        n = scn.nextInt();
        scn.nextLine();
        forest = new int[n][n];
        dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                forest[i][j] = scn.nextInt();
            }
            scn.nextLine();
        }

        System.out.println(solution());
    }

    private static int solution() {
       int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(dp[i][j] != 1){
                    max = Math.max(max, dp[i][j]);
                }else{
                    max = Math.max(max, answer(i, j));
                }
            }
        }

        return max;
    }

    private static int answer(int i, int j) {
        boolean[][] check = new boolean[n][n];
        check[i][j] = true;

        LinkedList<Integer> rows = new LinkedList<>();
        LinkedList<Integer> cols = new LinkedList<>();
        rows.offer(i);
        cols.offer(j);

        int level = 0;
        int[] numsPerLevel = new int[n * n];
        numsPerLevel[0] = 1;
        while(!rows.isEmpty()){
            int row = rows.poll();
            int col = cols.poll();
            numsPerLevel[level] = numsPerLevel[level] - 1;

            if(row != 0 && !check[row - 1][col] && forest[row - 1][col] > forest[row][col]){
                check[row - 1][col] = true;
                if(dp[row - 1][col] != 1){
                    dp[row][col] = Math.max(dp[row][col], dp[row - 1][col] + 1);
                }else{
                    rows.offer(row - 1);
                    cols.offer(col);
                    numsPerLevel[level + 1] = numsPerLevel[level + 1] + 1;
                }
            }
            if(row != n - 1 && !check[row + 1][col] && forest[row + 1][col] > forest[row][col]){
                check[row + 1][col] = true;
                if(dp[row + 1][col] != 1){
                    dp[row][col] = Math.max(dp[row][col], dp[row + 1][col] + 1);
                }else{
                    rows.offer(row + 1);
                    cols.offer(col);
                    numsPerLevel[level + 1] = numsPerLevel[level + 1] + 1;
                }
            }
            if(col != 0 && !check[row][col - 1] && forest[row][col - 1] > forest[row][col]){
                check[row][col - 1] = true;
                if(dp[row][col - 1] != 1){
                    dp[row][col] = Math.max(dp[row][col], dp[row][col - 1] + 1);
                }else{
                    rows.offer(row);
                    cols.offer(col - 1);
                    numsPerLevel[level + 1] = numsPerLevel[level + 1] + 1;
                }
            }
            if(col != n - 1 && !check[row][col + 1] && forest[row][col + 1] > forest[row][col]){
                check[row][col + 1] = true;
                if(dp[row][col + 1] != 1){
                    dp[row][col] = Math.max(dp[row][col], dp[row][col + 1] + 1);
                }else{
                    rows.offer(row);
                    cols.offer(col + 1);
                    numsPerLevel[level + 1] = numsPerLevel[level + 1] + 1;
                }
            }
            if(dp[row][col] != 1){
                level = level + dp[row][col];
                break;
            }

            if(numsPerLevel[level] == 0){
                level++;
            }
        }

        dp[i][j] = level;

        return level;
    }
}
