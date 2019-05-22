package algorithm.baekjoon.newbie2019;

import java.util.Scanner;

public class G {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int[][] A = new int[5][5];
        int[][] B = new int[5][5];
        for (int i = 0; i < 5; i++) {
            String[] strArr = scn.nextLine().split(" ");
            for (int j = 0; j < 5; j++) {
                A[i][j] = Integer.parseInt(strArr[j]);
            }
        }
        for (int i = 0; i < 5; i++) {
            String[] strArr = scn.nextLine().split(" ");
            for (int j = 0; j < 5; j++) {
                B[i][j] = Integer.parseInt(strArr[j]);
            }
        }
        int[][] result = matmul(A, B);
        int[] sum = new int[5];
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                sum[i] += result[i][j];
            }
            if(min >= sum[i]){
                minIndex = i;
                min = sum[i];
            }
        }
        switch (minIndex){
            case 0:
                System.out.print("Inseo");
                break;
            case 1:
                System.out.print("Junsuk");
                break;
            case 2:
                System.out.print("Jungwoo");
                break;
            case 3:
                System.out.print("Jinwoo");
                break;
            case 4:
                System.out.print("Youngki");
                break;
            default:
                break;
        }
    }

    private static int[][] matmul(int[][] A, int[][] B){
        int[][] result = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }
}
