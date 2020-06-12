package programmers.skillchecktest4;

/**
 * 시간초과 난 소스 (정확성은 다 맞춤)
 */
public class Problem1 {
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution(maps));
    }

    private static int minLength = 987654321;
    private static int n = 0;
    private static int m = 0;

    public static int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;

        boolean[][] check = new boolean[n][m];
        dfs(maps, 0, 0, 0, check);

        return minLength == 987654321? -1 : minLength;
    }

    private static void dfs(int[][] maps, int length, int row, int col, boolean[][] check) {
        if(row < 0 || col < 0 || row >= n || col >= m){
            return;
        }
        if(maps[row][col] == 0 || check[row][col]){
            return;
        }
        check[row][col] = true;
        if(row == n - 1 && col == m - 1){
            minLength = Math.min(minLength, length + 1);
        }

        dfs(maps, length + 1, row + 1, col, check);
        dfs(maps, length + 1, row, col + 1, check);
        dfs(maps, length + 1, row - 1, col, check);
        dfs(maps, length + 1, row, col - 1, check);

        check[row][col] = false;
    }
}
