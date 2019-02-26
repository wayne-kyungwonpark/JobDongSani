package test;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        char[] chArr = new char[4];
        chArr[0] = '3';
        chArr[1] = '4';
        chArr[2] = '1';
        chArr[3] = '5';
        Arrays.sort(chArr);
        StringBuilder sb = new StringBuilder();
        for(char c : chArr){
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
