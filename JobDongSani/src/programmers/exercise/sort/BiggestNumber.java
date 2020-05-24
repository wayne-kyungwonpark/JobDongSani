package programmers.exercise.sort;

import java.util.Arrays;
import java.util.Comparator;

public class BiggestNumber {
    public static void main(String[] args) {
//        int[] numbers = {6, 10, 2};
//        int[] numbers = {3, 30, 34, 5, 9};
//        int[] numbers = {10, 110, 100, 101, 11001, 1100, 1};
//        int[] numbers = {2, 20, 200};
//        int[] numbers = {121, 12};
//        int[] numbers = {0, 0, 1000, 0};
//        int[] numbers = {12, 1213};
//        int[] numbers = {2, 22, 223};
//        int[] numbers = {40, 404};
//        int[] numbers = {40, 405};
//        int[] numbers = {40, 403};
//        int[] numbers = {0, 0, 0, 0, 0};
//        int[] numbers = {12, 12120, 1212};
        int[] numbers = {34, 344};
//        int[] numbers = {21, 212};
        System.out.println(solution(numbers));

//        NewInteger o1 = new NewInteger(200);
//        NewInteger o2 = new NewInteger(20);
//        System.out.println(o1.compareTo(o2));
    }

    public static String solution(int[] numbers) {
        NewInteger[] newNumbers = new NewInteger[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            NewInteger newInteger = new NewInteger(numbers[i]);
            newNumbers[i] = newInteger;
        }

        Arrays.sort(newNumbers, new Comparator<NewInteger>() {
            @Override
            public int compare(NewInteger o1, NewInteger o2) {
                return o1.compareTo(o2);
            }
        });

        if(newNumbers[newNumbers.length - 1].num == 0){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = newNumbers.length - 1; i >= 0; i--) {
            sb.append(String.valueOf(newNumbers[i].num));
        }

        return sb.toString();
    }

    private static class NewInteger implements Comparable<NewInteger> {
        int num = 0;
        public NewInteger(int num){
            this.num = num;
        }

        @Override
        public int compareTo(NewInteger o) {
            int oNum = o.num;
            char[] numChArr = String.valueOf(num).toCharArray();
            char[] oNumChArr = String.valueOf(oNum).toCharArray();
            return compare(numChArr, oNumChArr, 0, numChArr.length - 1, 0, oNumChArr.length - 1);
        }

        private int compare(char[] chArr1, char[] chArr2, int start1, int end1, int start2, int end2){
            char[] chArr1to2 = new char[chArr1.length + chArr2.length];
            char[] chArr2to1 = new char[chArr1.length + chArr2.length];

            for (int i = 0; i < chArr1.length; i++) {
                chArr1to2[i] = chArr1[i];
                chArr2to1[i + chArr2.length] = chArr1[i];
            }
            for (int i = 0; i < chArr2.length; i++) {
                chArr1to2[i + chArr1.length] = chArr2[i];
                chArr2to1[i] = chArr2[i];
            }

            for (int i = 0; i < chArr1to2.length; i++) {
                if(chArr1to2[i] < chArr2to1[i]){
                    return -1;
                }else if(chArr1to2[i] > chArr2to1[i]){
                    return 1;
                }
            }
            return 0;
        }
    }
}
