package programmers.skillchecktest4_1;

import java.util.HashSet;
import java.util.Set;

public class Problem1 {
    public static void main(String[] args) {
        String[] strs = {"ba", "na", "n", "a"};
        String t = "banana";
        System.out.println(solution(strs, t));
    }

    public static int solution(String[] strs, String t) {
        Set<String> strSet = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            strSet.add(strs[i]);
        }

        int[][] dp = new int[t.length()][t.length()];

        // dp 초기화
        for (int i = 0; i < t.length(); i++) {
            for (int j = i; j < t.length(); j++) {
                dp[i][j] = 987654321;
            }
        }

        for (int i = 0; i < t.length(); i++) { // i: dp index 차이 (i가 1일 경우, dp[0][1], dp[1][2] ... 를 체크)
            for (int j = 0; j < t.length() - i; j++) { //j: dp의 첫 번째 index 순회 용도
                if(strSet.contains(t.substring(j, j + i + 1))){
                    dp[j][j + i] = 1;
                    continue;
                }
                for (int k = 0; k < i; k++) { // k: i를 쪼개는 용도 (i가 4일 경우, dp[0][4] = min(dp[0][0] + dp[1][4]
                                                                                                // , dp[0][1] + dp[2][4]
                                                                                                // , dp[0][2] + dp[3][4]
                                                                                                // , dp[0][3] + dp[4][4]))
                    int left = dp[j][j + k];
                    int right = dp[j + k + 1][j + i];
                    if(left != 987654321 && right != 987654321){
                        dp[j][j + i] = Math.min(dp[j][j + i], left + right);
                    }
                }
            }
        }

        return dp[0][t.length() - 1] == 987654321? -1 : dp[0][t.length() - 1];
    }
}
