package algorithm.baekjoon.stepwise.slidingwindow;

import java.io.*;

/**
 * https://github.com/ParkKyungWon/JobDongSani/blob/master/JobDongSani/src/algorithm/baekjoon/stepwise/slidingwindow/_11003_FindMinValue.java
 *
 * ## 슬라이딩 윈도우 알고리즘 학습
 * ### 예시를 통한 학습
 * 1. 예시) N = 12, K = 3
 * 2. 2K - 1 개씩 배열을 쪼갬 ( 2 * 3 - 1 = 5 )쪼개는 방법은 다음과 같다.
 * 	1. A(1)      A(2)      … A(K-1)       A(K), A(K+1),     … A(2K-1)
 * 	2. M(1, K) M(2, K) … M(K-1, K) A(K), M(K, K+1) … M(K, 2K-1)
 * 3. 각각의 M 값은 O(1) 만에 연산 가능
 * 4. 우리가 구해야 할 것은 다음과 같다.
 * 	1. M(1, 1), M(1, 2), …, M(1, K - 1)
 * 	2. M(1, K) = M(M(1, K), M(K, K))
 * 	3. M(2, K+1) = M(M(2, K), M(K, K+1))
 * 	4. 각각은 이전의 M 값이 계산이 되어 있다면 O(1) 에 계산 가능
 * 5. 예시에서는 1 5 2 3 6 2 3 7 3 5 2 6
 * 	1. 아래와 같이 5개씩 쪼갠 후 M을 계산한다.
 * 	2. D_1 ~ D_2 까지는 for문 돌며 따로 계산한다.
 * 	3. 1 5 2 3 6                -> M(1, 3) ~ M(3, 5) (즉, D_3 ~ D_5)
 * 	4.       3 6 2 3 7          -> M(4, 6) ~ M(6, 8)  (즉, D_6 ~ D_8)
 * 	5.             3 7 3 5 2    -> M(7, 9) ~ M(9, 11) (즉, D_9 ~ D_11)
 * 	6.                   5 2 6  -> M(10, 12)  (즉, D_12)
 * 6. O(2K - 1) 구간이 O(N/K) 만큼 있으므로, O(N) 만에 가능
 */
public class _11003_FindMinValue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int n = 0, k = 0;
        int[] nums = null;
        int[] d = null;
        while((str = br.readLine()) != null){
            String[] strArr = str.split(" ");
            if(n == 0){
                n = Integer.parseInt(strArr[0]);
                k = Integer.parseInt(strArr[1]);
                nums = new int[n + 1];
                d = new int[n + 1];
            }else{
                for (int i = 1; i <= n; i++) {
                    nums[i] = Integer.parseInt(strArr[i - 1]);
                }
                break;
            }
        }

        int subInterval = 2 * k - 1;
        int numOfSubIntervals = n / k;
        for (int i = 0; i < numOfSubIntervals; i++) {
            int center = (i + 1) * k;
            int[] mins = new int[subInterval + 1];
            for (int j = 0; j < k; j++) {
                if(j == 0){
                    mins[k] = nums[center];
                }else{
                    if(center - j >= 0){
                        mins[k - j] = Math.min(mins[k - (j - 1)], nums[center - j]);
                    }
                    if(center + j <= n){
                        mins[k + j] = Math.min(mins[k + (j - 1)], nums[center + j]);
                    }
                }
            }

            if(i == 0){
                int minVal = Integer.MIN_VALUE;
                for (int j = 1; j <= k - 1; j++) {
                    if(minVal == Integer.MIN_VALUE || minVal > nums[j]){
                        d[j] = nums[j];
                        minVal = nums[j];
                    }else{
                        d[j] = minVal;
                    }
                }
            }

            int minsCenter = k;
            for (int j = center; j < center + k; j++) {
                if(j <= n){
                    d[j] = Math.min(mins[minsCenter - k + 1], mins[minsCenter]);
                    minsCenter++;
                }
            }

//            if(i == 0){
//                StringBuilder sbTest = new StringBuilder();
//                for (int j = 1; j <= k - 1; j++) {
//                    sbTest.append(d[j]).append(" ");
//                }
//                bw.write(sbTest.toString());
//            }
//            StringBuilder test = new StringBuilder();
//            for (int j = 1; j <= subInterval; j++) {
//                test.append(mins[j]).append(" ");
//            }
//            bw.write(test.toString());
//            bw.newLine();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(d[i]).append(" ");
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
