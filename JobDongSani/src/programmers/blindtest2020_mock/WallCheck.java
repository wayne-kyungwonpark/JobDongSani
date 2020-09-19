package programmers.blindtest2020_mock;

import java.util.Arrays;
import java.util.Collections;

public class WallCheck {
    public static void main(String[] args) {
        int n = 12;
        int[] weak = {};
        int[] dist = {};
        System.out.println(solution(n, weak, dist));
    }

    public static int solution(int n, int[] weak, int[] dist) {
        int answer = 0;
        if(weak.length == 1){
            return 1;
        }

        int[] weakDiffCW = new int[weak.length];
        for (int i = 0; i < weak.length; i++) {
            if(i != weak.length - 1){
                weakDiffCW[i] = weak[i + 1] - weak[i];
            }else{
                weakDiffCW[i] = n - weak[i] + weak[0];
            }
        }
        int[] weakDiffCCW = new int[weak.length];
        for (int i = weak.length - 1; i >= 0; i--) {
            if(i != 0){
                weakDiffCCW[i] = weak[i] - weak[i - 1];
            }else{
                weakDiffCCW[i] = n - weak[weak.length - 1] + weak[0];
            }
        }

        int[] psCW = new int[weak.length];
        int[] psCCW = new int[weak.length];
        for (int i = 0; i < weak.length; i++) {
            if(i == 0){
                psCW[i] = weakDiffCW[i];
                psCCW[i] = weakDiffCCW[i];
            }else{
                psCW[i] = weakDiffCW[i] + psCW[i - 1];
                psCCW[i] = weakDiffCCW[i] + psCCW[i - 1];
            }
        }

        Arrays.sort(dist);
        int distIndex = dist.length - 1;
        for (int i = weak.length - 1; i >= 0; i--) {
            if(psCW[i] <= dist[distIndex]){

            }
        }


        return answer;
    }
}
