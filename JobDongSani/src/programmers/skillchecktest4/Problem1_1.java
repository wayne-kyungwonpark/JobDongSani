package programmers.skillchecktest4;

import java.util.LinkedList;

public class Problem1_1 {
    public static void main(String[] args) {
//        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};


        System.out.println(solution(maps));
    }

    private static int n = 0;
    private static int m = 0;

    public static int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;

        boolean[][] check = new boolean[n][m];
        LinkedList<Integer> rows = new LinkedList<>();
        LinkedList<Integer> cols = new LinkedList<>();
        rows.add(0);
        cols.add(0);
        check[0][0] = true;
        int level = 1;
        int[] numsPerLevel = new int[n * m + 1];
        numsPerLevel[level] = 1;
        boolean find = false;
        while(!rows.isEmpty()){
            int row = rows.poll();
            int col = cols.poll();
            if(row == n - 1 && col == m - 1){
                find = true;
                break;
            }
            numsPerLevel[level]--;
            if(row + 1 < n && maps[row + 1][col] != 0 && !check[row + 1][col]){
                check[row + 1][col] = true;
                rows.offer(row + 1);
                cols.offer(col);
                numsPerLevel[level + 1]++;
            }
            if(row - 1 >= 0 && maps[row - 1][col] != 0 && !check[row - 1][col]){
                check[row - 1][col] = true;
                rows.offer(row - 1);
                cols.offer(col);
                numsPerLevel[level + 1]++;
            }
            if(col + 1 < m && maps[row][col + 1] != 0 && !check[row][col + 1]){
                check[row][col + 1] = true;
                rows.offer(row);
                cols.offer(col + 1);
                numsPerLevel[level + 1]++;
            }
            if(col - 1 >= 0 && maps[row][col - 1] != 0 && !check[row][col - 1]){
                check[row][col - 1] = true;
                rows.offer(row);
                cols.offer(col - 1);
                numsPerLevel[level + 1]++;
            }
            if(numsPerLevel[level] == 0){
                level++;
            }
        }

        return find? level : -1;
    }
}
