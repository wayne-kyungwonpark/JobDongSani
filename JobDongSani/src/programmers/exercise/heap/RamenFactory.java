package programmers.exercise.heap;

import java.util.PriorityQueue;

public class RamenFactory {
    public static void main(String[] args) {
        int stock = 4;
        int[] dates = {4,10,15};
        int[] supplies = {20,5,10};
        int k = 30;
//        int stock = 4;
//        int[] dates = {1,2,3,4};
//        int[] supplies = {1,1,1,1};
//        int k = 6;
        // result: 2
        System.out.println(solution(stock, dates, supplies, k));

        PriorityQueue<AbroadFactory> queue = new PriorityQueue<>();
        AbroadFactory factory1 = new AbroadFactory(1, 10);
        AbroadFactory factory2 = new AbroadFactory(2, 15);
        AbroadFactory factory3 = new AbroadFactory(3, 13);
        AbroadFactory factory4 = new AbroadFactory(4, 11);

        queue.offer(factory1);
        queue.offer(factory2);
        queue.offer(factory3);
        queue.offer(factory4);

        for(int i = 0; i < 4; i++){
            System.out.println(queue.poll().supply);
        }

    }

    public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        PriorityQueue<AbroadFactory> maxHeap = new PriorityQueue<>();

        int index = 0;
        for(int date = 0; date < k; date++){
            if(index < dates.length && date == dates[index]){
                AbroadFactory factory = new AbroadFactory(dates[index], supplies[index]);
                maxHeap.offer(factory);
                index++;
            }
            if(stock == 0){
                stock += maxHeap.poll().supply;
                answer++;
            }
            stock--;
        }

        return answer;
    }

    private static class AbroadFactory implements Comparable<AbroadFactory> {
        public int date;
        public int supply;

        public AbroadFactory(int date, int supply){
            this.date = date;
            this.supply = supply;
        }

        @Override
        public int compareTo(AbroadFactory o) {
            // 내림차순 구현
            if(this.supply < o.supply){
                return 1;
            }else if(this.supply > o.supply){
                return -1;
            }
            return 0;
        }
    }
}
