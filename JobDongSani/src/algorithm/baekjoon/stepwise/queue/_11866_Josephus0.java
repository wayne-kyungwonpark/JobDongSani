package algorithm.baekjoon.stepwise.queue;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class _11866_Josephus0 {
    private static int N = 0, K = 0;
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = scn.nextInt(); K = scn.nextInt();

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        ArrayList<Integer> order = new ArrayList<>();
        int index = K - 1;
        while(list.size() > 0){
            if(index >= list.size()){
                index %= list.size();
            }
            order.add(list.remove(index));
            index += (K - 1);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        for (int i = 0; i < N; i++) {
            sb.append(order.get(i));
            if(i != N - 1){
                sb.append(", ");
            }else{
                sb.append(">");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        scn.close();
        bw.close();
    }
}
