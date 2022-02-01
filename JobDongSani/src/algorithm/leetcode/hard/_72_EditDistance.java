package algorithm.leetcode.hard;

public class _72_EditDistance {
    // word1의 i번째 길이까지를 word2의 j번째 길이까지로 바꿀 때의 최소 cost
    private static int[][] dp = null;

    public static int minDistance(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();

        dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {

                if(w1[i - 1] == w2[j - 1]){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
            }
        }


        return dp[word1.length()][word2.length()];
    }
}
