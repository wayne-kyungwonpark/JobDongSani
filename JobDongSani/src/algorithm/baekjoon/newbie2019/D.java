package algorithm.baekjoon.newbie2019;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String[] strArr = scn.nextLine().split(" ");
        int N = Integer.parseInt(strArr[0]), B = Integer.parseInt(strArr[1]);
        int[] choose = new int[N];
        boolean[] check = new boolean[N];

        for (int i = 0; i < N; i++) {
            choose[i] = scn.nextInt();
        }
        int chosen = choose[0];
        int min = 1;
        while(chosen != B){
            check[chosen] = true;
            chosen = choose[chosen];
            if(check[chosen]){
                min = -1;
                break;
            }
            min++;
        }
        System.out.print(min);
    }
}
