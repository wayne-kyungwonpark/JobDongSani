package programmers.exercise.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class SteppingStone {
    public static void main(String[] args) {
        int distance = 30;
//        int[] rocks = {2, 14, 11, 21, 17};
//        int n = 2;
//        int[] rocks = {1, 2, 3};
//        int n = 3;
        int[] rocks = {4, 6, 8, 12, 25, 19};
        int n = 2;
        System.out.println(solution(distance, rocks, n));
    }

    public static int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        Arrays.sort(rocks);

        long[] diffsForSort = new long[rocks.length + 1];
        int tmpIndex = 0;
        ArrayList<Long> diffs = new ArrayList<>();
        diffs.add((long) rocks[0]);
        diffsForSort[tmpIndex++] = rocks[0];
        for (int i = 1; i < rocks.length; i++) {
            int diff = rocks[i] - rocks[i - 1];
            diffs.add((long) diff);
            diffsForSort[tmpIndex++] = diff;
        }
        diffs.add((long) distance - rocks[rocks.length - 1]);
        diffsForSort[tmpIndex++] = distance - rocks[rocks.length - 1];

        Arrays.sort(diffsForSort);

        for (int i = 0; i < diffsForSort.length; i++) {
            int j = 0;
            while(j < diffs.size()){
                if(diffs.get(j) == diffsForSort[i]){
                    if(j == diffs.size() - 1 || (j != 0 && diffs.get(j - 1) < diffs.get(j + 1))){
                        long sum = diffs.get(j - 1) + diffs.get(j);
                        diffs.remove(j);
                        diffs.remove(j - 1);
                        diffs.add(j - 1, sum);
                    }else{
                        long sum = diffs.get(j) + diffs.get(j + 1);
                        diffs.remove(j + 1);
                        diffs.remove(j);
                        diffs.add(j, sum);
                    }
                    n--;
                    break;
                }
                j++;
            }
            if(n == 0){
                break;
            }
        }

        answer = (int) (long) diffs.get(0);

        for (int i = 1; i < diffs.size(); i++) {
            answer = (int) (long) Math.min(answer, diffs.get(i));
        }

        return answer;
    }
}
