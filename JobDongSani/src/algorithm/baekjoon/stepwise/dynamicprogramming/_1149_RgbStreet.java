package algorithm.baekjoon.stepwise.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1149_RgbStreet {
    private static int N = 0;
    private static int[][] costs = null;
    private static int[][] minPartialCosts = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        int nFreq = 0;
        while((str = br.readLine()) != null){
            if(N == 0){
                N = Integer.parseInt(str);
                costs = new int[N][3];
                minPartialCosts = new int[N][3];
            }else{
                String[] strArr = str.split(" ");
                costs[nFreq][0] = Integer.parseInt(strArr[0]);
                costs[nFreq][1] = Integer.parseInt(strArr[1]);
                costs[nFreq][2] = Integer.parseInt(strArr[2]);
                nFreq++;
                if(N == nFreq){
                    break;
                }
            }
        }
        findMinCostSum(0);

        System.out.println(Math.min(minPartialCosts[N - 1][0], Math.min(minPartialCosts[N - 1][1], minPartialCosts[N - 1][2])));
    }
    private static void findMinCostSum(int nIndex){
        if(nIndex > N - 1){
            return;
        }
        if(nIndex == 0){
            minPartialCosts[0][0] = costs[0][0];
            minPartialCosts[0][1] = costs[0][1];
            minPartialCosts[0][2] = costs[0][2];
        }else{
            minPartialCosts[nIndex][0] = Math.min(minPartialCosts[nIndex - 1][1], minPartialCosts[nIndex - 1][2]) + costs[nIndex][0];
            minPartialCosts[nIndex][1] = Math.min(minPartialCosts[nIndex - 1][2], minPartialCosts[nIndex - 1][0]) + costs[nIndex][1];
            minPartialCosts[nIndex][2] = Math.min(minPartialCosts[nIndex - 1][0], minPartialCosts[nIndex - 1][1]) + costs[nIndex][2];
        }
        findMinCostSum(nIndex + 1);
    }
}
