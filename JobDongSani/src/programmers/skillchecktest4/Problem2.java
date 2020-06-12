package programmers.skillchecktest4;

public class Problem2 {
    public static void main(String[] args) {
        int[][] matrix_sizes = {{5, 3}, {3, 10}, {10, 6}};
        System.out.println(solution(matrix_sizes));
    }

    public static int solution(int[][] matrix_sizes) {
        int answer = 0;

        int[][] dp = new int[matrix_sizes.length][matrix_sizes.length];

        for (int i = 0; i < matrix_sizes.length; i++) {
            for (int j = 0; j < matrix_sizes.length; j++) {
                if(i != j){
                    dp[i][j] = 987654321;
                }
            }
        }

        for (int i = 1; i < matrix_sizes.length; i++) {
            for (int j = 0; j + i < matrix_sizes.length; j++) {
                for (int k = 1; k + j < matrix_sizes.length; k++) {
                    int left = dp[j][j + k - 1];
                    int right = dp[j + k][j + i];
                    int multiplicationCost = matrix_sizes[j][0] * matrix_sizes[j + k - 1][1] * matrix_sizes[j + i][1];
                    dp[j][j + i] = Math.min(dp[j][j + i], left + right + multiplicationCost);
                }
            }
        }

        return dp[0][matrix_sizes.length - 1];
    }
}
