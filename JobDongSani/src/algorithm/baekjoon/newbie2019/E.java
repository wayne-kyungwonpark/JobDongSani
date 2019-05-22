package algorithm.baekjoon.newbie2019;

import java.util.Scanner;

public class E {
    private static char a = 'a';
    private static int aToZ = 'z' - 'a' + 1;
    private static long[] pow;
    private static long[] powCdf;
    private static int maxLength;

    public static void main(String[] args) {
//        System.out.println(Long.MAX_VALUE);
        Scanner scn = new Scanner(System.in);
        maxLength = Integer.parseInt(scn.nextLine());
        char[] chArr = scn.nextLine().toCharArray();
        
        long time = 1;
        pow = new long[maxLength];
        powCdf = new long[maxLength];
        for (int i = 0; i < maxLength; i++) {
            if(i == 0){
                pow[i] = 1;
                powCdf[i] = pow[i];
            }else{
                pow[i] = pow[i - 1] * aToZ;
                powCdf[i] = powCdf[i - 1] + pow[i];
            }
        }
        for (int i = 0; i < chArr.length; i++) {
            long diff = chArr[i] - a;
            if(i == 0){
//                long oneTerm = 0;
//                for (int j = 0; j < maxLength; j++) {
//                    oneTerm += Math.pow(aToZ, j);
//                }
                long oneTerm = powCdf[maxLength - 1];
                time += diff * oneTerm;
            }else{
                time += getUnitTime(maxLength - i, chArr[i]);
                time++;
            }
        }
        System.out.print(time);
    }

    private static long getUnitTime(int maxLen, char ch){
        long diff = ch - a;
        long oneTerm = 0;
        if(diff != 0){
//            for (int i = 0; i < maxLen; i++) {
//                oneTerm += Math.pow(aToZ, i);
//            }
            oneTerm = powCdf[maxLen - 1];
        }
        return diff * oneTerm;
    }
}
