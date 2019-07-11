package algorithm.baekjoon.stepwise.bruteforce;

import java.util.LinkedList;
import java.util.Scanner;

public class _1107_RemoteControl {
    private static int wanted = 0;
    private static int wantedLength = 0;
    private static int brokenNum = 0;
    private static boolean[] isBroken = new boolean[10];
    private static int[] notBroken = null;
    private static int minButtonNums = 0;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        wanted = Integer.parseInt(str);
        wantedLength = str.length();
        brokenNum = Integer.parseInt(scn.nextLine());
        if(brokenNum == 0){
            int diffVersus100 = Math.abs(wanted - 100);
            System.out.println(Math.min(wantedLength, diffVersus100));
        }else{
            for (int i = 0; i < brokenNum; i++) {
                isBroken[scn.nextInt()] = true;
            }
            notBroken = new int[10 - brokenNum];
            int index = 0;
            for (int i = 0; i < 10; i++) {
                if(!isBroken[i]){
                    notBroken[index++] = i;
                }
            }

            // 현재 채널(100)에서 +- 버튼만을 사용해서 wanted 채널에 도달하기 위해 눌러야 하는 횟수
            int diffVersus100 = Math.abs(wanted - 100);

            // brute force로 모든 notBrokenNums를 wanted 숫자의 자릿수만큼 돌려 눌러야 하는 버튼 수를 기록한다.
            minButtonNums = diffVersus100;
            if(minButtonNums != 0){
                LinkedList<Integer> permutationNums = new LinkedList<>();
                doPermutation(permutationNums);
            }
            System.out.println(minButtonNums);
        }
        scn.close();
    }

    private static void doPermutation(LinkedList<Integer> permutationNums){
        if(permutationNums.size() >= 1 && permutationNums.size() <= wantedLength + 1){
            StringBuilder sb = new StringBuilder();
            for (int num : permutationNums) {
                sb.append(num);
            }
            int diff = permutationNums.size() + Math.abs(Integer.parseInt(sb.toString()) - wanted);
            if(diff < minButtonNums){
                minButtonNums = diff;
            }
            if(permutationNums.size() == wantedLength + 1){
                return;
            }
        }
        for (int i = 0; i < notBroken.length; i++) {
            permutationNums.add(notBroken[i]);
            doPermutation(permutationNums);
            permutationNums.removeLast();
        }
    }
}
