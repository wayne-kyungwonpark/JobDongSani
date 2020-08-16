package algorithm.leetcode.hard;

public class _980_UniquePath3 {
    private static int startR, startC, endR, endC;
    private static boolean[][] walkedOver;
    private static int answer;

    public static void main(String[] args) {
//        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,0,2}};
        System.out.println(uniquePathsIII(grid));
    }

    public static int uniquePathsIII(int[][] grid) {
        answer = 0;
        walkedOver = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    startR = i;
                    startC = j;
                }
                if(grid[i][j] == 2){
                    endR = i;
                    endC = j;
                }
                if(grid[i][j] != 0 && grid[i][j] != 2){
                    walkedOver[i][j] = true;
                }
            }
        }
        dfs(startR, startC, grid);
        return answer;
    }

    private static void dfs(int r, int c, int[][] grid){

        if(grid[r][c] == 2){
            boolean all = true;
            for(int i = 0; i < walkedOver.length; i++){
                for(int j = 0; j < walkedOver[i].length; j++){
                    if(!walkedOver[i][j]){
                        all = false;
                        break;
                    }
                }
                if(!all){
                    break;
                }
            }
            if(all){
                answer++;
            }
            return;
        }
        if(r != 0 && !walkedOver[r - 1][c]){
            walkedOver[r - 1][c] = true;
            dfs(r - 1, c, grid);
            walkedOver[r - 1][c] = false;
        }
        if(c != 0 && !walkedOver[r][c - 1]){
            walkedOver[r][c - 1] = true;
            dfs(r, c - 1, grid);
            walkedOver[r][c - 1] = false;
        }
        if(r != grid.length - 1 && !walkedOver[r + 1][c]){
            walkedOver[r + 1][c] = true;
            dfs(r + 1, c, grid);
            walkedOver[r + 1][c] = false;
        }
        if(c != grid[r].length - 1 && !walkedOver[r][c + 1]){
            walkedOver[r][c + 1] = true;
            dfs(r, c + 1, grid);
            walkedOver[r][c + 1] = false;
        }
    }
}
