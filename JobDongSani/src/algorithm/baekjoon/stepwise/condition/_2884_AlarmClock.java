package algorithm.baekjoon.stepwise.condition;

import java.util.Scanner;

public class _2884_AlarmClock {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int h = scn.nextInt();
        int m = scn.nextInt();

        StringBuilder sb = new StringBuilder();
        if(h == 0){
            if(m < 45) {
                sb.append(23).append(" ").append(60 + m - 45);
            }else{
                sb.append(0).append(" ").append(m - 45);
            }
        }else{
            if(m < 45){
                sb.append(h - 1).append(" ").append(60 + m - 45);
            }else{
                sb.append(h).append(" ").append(m - 45);
            }
        }
        System.out.println(sb.toString());
        scn.close();
    }
}
