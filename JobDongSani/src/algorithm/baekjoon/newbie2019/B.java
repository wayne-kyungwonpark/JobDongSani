package algorithm.baekjoon.newbie2019;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String a = scn.nextLine();
        String b = scn.nextLine();
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            if(i != 7){
                sb1.append(a.substring(i, i + 1));
                sb1.append(b.substring(i, i + 1));
            }else{
                sb1.append(a.substring(i));
                sb1.append(b.substring(i));
            }
        }
        String str = sb1.toString();
        for (int i = 0; i < 14; i++) {
            sb1 = new StringBuilder();
            char[] chArr = str.toCharArray();
            int[] intArr = new int[chArr.length];
            for (int j = 0; j < intArr.length; j++) {
                intArr[j] = Integer.parseInt(String.valueOf(chArr[j]));
                if(j != 0){
                    sb1.append((intArr[j - 1] + intArr[j]) % 10);
                }
            }
            str = sb1.toString();
        }
        System.out.println(str);
    }
}
