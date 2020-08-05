package algorithm.baekjoon.stepwise.exercise;

import java.util.Scanner;

public class _5543_Sanggeunald {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int up = scn.nextInt(); scn.nextLine();
        int mid = scn.nextInt(); scn.nextLine();
        int down = scn.nextInt(); scn.nextLine();
        int cola = scn.nextInt(); scn.nextLine();
        int cider = scn.nextInt();
        System.out.println(Math.min(up, Math.min(mid, down)) + Math.min(cola, cider) - 50);
    }
}
