package naver.financial;

public class Solution3 {
    public static void main(String[] args) {
        String S = "ABAABBBA";
//        String S = "BAAABAB";
        System.out.println(solution(S));
    }

    /**
     * check all the changes if there exists all 'A's before | and all 'B's after |
     * ex)
     *     A  B  A  A  B  B  B  A
     *   |  |  |  |  |  |  |  |  |
     *  0  1  2  3  4  5  6  7  8
     *
     *  prevA means the number of 'A's before |
     *  prevB means the number of 'B's before |
     *  nextA means the number of 'A's after |
     *  nextB means the number of 'B's after |
     *
     *  if | exists at 0, |ABAABBBA should be changed to |BBBBBBBB
     *    prevA = 0, prevB = 0, nextA = 4, nextB = 4 ->  prevB + nextA = 4 changes needed
     *  if | exists at 1, A|BAABBBA should be changed to A|BBBBBBB
     *    prevA = 1, prevB = 0, nextA = 3, nextB = 4 ->  prevB + nextA = 3 changes needed
     *  if | exists at 2, AB|AABBBA should be changed to AA|BBBBBB
     *    prevA = 1, prevB = 1, nextA = 3, nextB = 3 ->  prevB + nextA = 4 changes needed
     *  ...
     *  if | exists at 4, ABAA|BBBA should be changed to AAAA|BBBB
     *    prevA = 3, prevB = 1, nextA = 1, nextB = 3 ->  prevB + nextA = 1 changes needed  -> this is minimum!
     *  ...
     *
     * @param S
     * @return the minimum change of 'A's or 'B's which satisfies the format "A..AB..B'
     */
    public static int solution(String S) {
        char[] chArr = S.toCharArray();
        int prevA = 0;
        int prevB = 0;
        int nextA = 0;
        int nextB = 0;

        for (int i = 0; i < chArr.length; i++) {
            if(chArr[i] == 'A'){
                nextA++;
            }else{
                nextB++;
            }
        }

        int answer = nextA + prevB;
        for (int i = 1; i < chArr.length + 1; i++) {
            if(chArr[i - 1] == 'A'){
                prevA++;
                nextA--;
            }else{
                prevB++;
                nextB--;
            }
            answer = Math.min(answer, nextA + prevB);
        }

        return answer;
    }
}
