package programmers.monthlycodechallenge.season1.third;

import java.util.Arrays;
import java.util.Comparator;

public class C2 {
    public static void main(String[] args) {
//        int[] a = {0};
//        int[] a = {5,2,3,3,5,3};
        int[] a = {0,3,3,0,7,2,0,2,2,0};
//        int[] a = {0,1,2,3,4,5,6,7};
        System.out.println(solution(a));
    }
    private static int[][] freqAndNum = null;

    public static int solution(int[] a) {
        if(a.length < 2){
            return 0;
        }

        freqAndNum = new int[a.length][2];
        for (int i = 0; i < a.length; i++) {
            freqAndNum[i][1] = i;
        }
        int prev = -1;
        for (int i = 0; i < a.length; i++) {
            freqAndNum[a[i]][0]++;
//            if(prev == a[i]){
//                if(i != a.length - 1 && a[i + 1] != a[i]){
//                    freqAndNum[a[i]][0]++;
//                }
//            }else{
//                prev = a[i];
//                freqAndNum[a[i]][0]++;
//            }
        }

        Arrays.sort(freqAndNum, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] < o2[0]){
                    return -1;
                }else if(o1[0] == o1[0]){
                    return 0;
                }else{
                    return 1;
                }
            }
        });
        int index = freqAndNum.length - 1;
        while(a.length / 2 < freqAndNum[index][0]){
            index--;
        }

        int maxAnswer = 0;

        while(index >= 0 && freqAndNum[index][0] > 0){
            int tmpIndex = 0;
            int endIndex = 0;
            int answer = 0;
            while(tmpIndex < a.length){
                if(a[tmpIndex] == freqAndNum[index][1]){
                    if(tmpIndex - 1 > endIndex && a[tmpIndex - 1] != freqAndNum[index][1]){
                        endIndex = tmpIndex;
                        tmpIndex++;
                        answer++;
                    }else{
                        if(tmpIndex + 1 < a.length && a[tmpIndex + 1] != freqAndNum[index][1]){
                            endIndex = tmpIndex + 1;
                            tmpIndex += 2;
                            answer++;
                        }else{
                            tmpIndex++;
                        }
                    }
                }else{
                    tmpIndex++;
                }
            }
            index--;
            if(maxAnswer < answer){
                maxAnswer = answer;
            }
        }

        return maxAnswer * 2;
    }
}
