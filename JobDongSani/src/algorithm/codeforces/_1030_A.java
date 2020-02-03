package algorithm.codeforces;

import java.io.InputStreamReader;
import java.util.Scanner;

public class _1030_A {
    public static void main(String[] args) {
        Scanner scn = new Scanner(new InputStreamReader(System.in));
        int n = scn.nextInt();
        scn.nextLine();
        boolean isHard = false;
        for (int i = 0; i < n; i++) {
            if(scn.nextInt() == 1){
                isHard = true;
                break;
            }
        }
        if(isHard){
            System.out.println("HARD");
        }else{
            System.out.println("EASY");
        }
    }
}
