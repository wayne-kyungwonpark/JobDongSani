package algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _386_LexicographicalNumbers {
    public static void main(String[] args) {
        List<Integer> answer = lexicalOrder(13);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> lexicalOrder(int n) {
        PriorityQueue<LexicographicInteger> heap = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            heap.offer(new LexicographicInteger(i));
        }

        List<Integer> answer = new ArrayList<>();
        while(!heap.isEmpty()){
            answer.add(heap.poll().num);
        }
        return answer;
    }

    private static class LexicographicInteger implements Comparable<LexicographicInteger> {
        int num;

        public LexicographicInteger(int num){
            this.num = num;
        }

        @Override
        public int compareTo(LexicographicInteger o) {
            return compare(this.num, o.num);
        }

        private int compare(int a, int b){
            char[] aArr = String.valueOf(a).toCharArray();
            char[] bArr = String.valueOf(b).toCharArray();
            int index = 0;
            while(true){
                if(index >= aArr.length){
                    return -1;
                }
                if(index >= bArr.length){
                    return 1;
                }
                if(aArr[index] < bArr[index]){
                    return -1;
                }else if(aArr[index] > bArr[index]){
                    return 1;
                }
                index++;
            }
        }
    }
}
