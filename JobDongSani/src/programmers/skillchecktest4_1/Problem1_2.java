package programmers.skillchecktest4_1;

public class Problem1_2 {
    public static void main(String[] args) {
        String[] strs = {"ba", "na", "n", "a"};
        String t = "banana";
        System.out.println(solution(strs, t));
    }

    public static int solution(String[] strs, String t) {
        int[] dp = new int[t.length()];

        for (int i = 1; i < t.length() + 1; i++) {
            for (int j = 0; j < strs.length; j++) {
                String puzzle = strs[j];
                if (i - puzzle.length() < 0) continue;
                if (puzzle.equals(t.substring(i - puzzle.length(), i))) {
                    if (i - puzzle.length() == 0) {
                        dp[i - 1] = 1;
                        continue;
                    }
                    if (dp[i - puzzle.length() - 1] > 0) {
                        dp[i - 1] = dp[i - 1] == 0 ? dp[i - puzzle.length() - 1] + 1:
                                Math.min(dp[i - 1], dp[i - puzzle.length() - 1] + 1);
                    }
                }
            }
        }

        if (dp[dp.length - 1] == 0){
            return -1;
        }

        return dp[dp.length - 1];
    }
}
