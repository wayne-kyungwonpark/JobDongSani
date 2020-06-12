package programmers.skillchecktest4_1;

import java.util.HashSet;
import java.util.Set;

public class Problem1_1 {
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

        int[] dp = new int[t.length()];

        for (int i = 0; i < t.length(); i++) {
            if(strSet.contains(t.substring(0, i + 1))){
                dp[i] = 1;
                continue;
            }else{
                dp[i] = 987654321;
            }
            for (int j = 0; j < i; j++) {
                if(dp[j] != 987654321 && strSet.contains(t.substring(j + 1, i + 1))){
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[dp.length - 1] == 987654321? -1 : dp[dp.length - 1];
    }
}
