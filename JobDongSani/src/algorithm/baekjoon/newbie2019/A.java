package algorithm.baekjoon.newbie2019;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int num = Integer.parseInt(scn.nextLine());
        String str = scn.nextLine();
        char[] chArr = str.toCharArray();
        String answer = "Yes";
        char prev = '1';
        for (int i = 0; i < chArr.length; i++) {
            if(i != 0){
                if(chArr[i - 1] == chArr[i]){
                    answer = "No";
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}
