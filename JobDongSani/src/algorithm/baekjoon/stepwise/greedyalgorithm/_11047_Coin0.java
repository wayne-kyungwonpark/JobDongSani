package algorithm.baekjoon.stepwise.greedyalgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _11047_Coin0 {
    private static int N = 0, K = 0;
    private static int[] values = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nFreq = 0;
        String str;
        while((str = br.readLine()) != null){
            if(N == 0){
                String[] strArr = str.split(" ");
                N = Integer.parseInt(strArr[0]); K = Integer.parseInt(strArr[1]);
                values = new int[N];
            }else{
                values[nFreq] = Integer.parseInt(str);
                nFreq++;
                if(nFreq == N){
                    break;
                }
            }
        }
        int value = K;
        int startIndex = N - 1;
        int coinNums = 0;
        while(value > 0){
            int greedyCandidate = 0;
            for (int i = startIndex; i >= 0; i--) {
                if(values[i] < value){
                    greedyCandidate = values[i];
                    startIndex = i;
                    coinNums += (value / greedyCandidate);
                    value = value % greedyCandidate;
                    break;
                }else if(values[i] == value){
                    coinNums++;
                    value = 0;
                    break;
                }
            }
        }
        System.out.println(coinNums);
    }
}
