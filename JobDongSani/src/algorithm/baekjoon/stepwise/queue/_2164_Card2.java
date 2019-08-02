package algorithm.baekjoon.stepwise.queue;

import java.util.LinkedList;
import java.util.Scanner;

public class _2164_Card2 {
    private static int N = 0;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        N = scn.nextInt();

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        while(list.size() > 1){
            list.removeFirst();
            if(list.size() == 1){
                break;
            }
            int tmp = list.removeFirst();
            list.add(tmp);
        }
        System.out.println(list.get(0));
        scn.close();
    }
}
