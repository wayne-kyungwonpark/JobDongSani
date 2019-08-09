package algorithm.baekjoon.stepwise.greedyalgorithm;

import java.util.Scanner;

public class _1541_LostParenthesis {
    private static int maxParenthesisPair = 0;
    private static int[] originals = null;
    private static int[] withParenthesis = null;
    private static int[] differences = null;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        // 최대 몇 번까지 괄호로 묶을 수 있는지 계산
        maxParenthesisPair = (50 - str.length()) / 2;
        // - 로 split
        String[] strArr = str.split("-");
        boolean isNegativeStart = false;
        if("-".equals(str.substring(0, 1))){
            isNegativeStart = true;
        }
        // -로 시작할 경우 strArr의 첫 번째 요소는 ""이기 때문에 없애준다.
        String[] tmpStrArr = new String[strArr.length - 1];
        if(isNegativeStart){
            for (int i = 1; i < strArr.length; i++) {
                tmpStrArr[i - 1] = strArr[i];
            }
            strArr = tmpStrArr;
        }
        originals = new int[strArr.length];
        withParenthesis = new int[strArr.length];
        differences = new int[strArr.length];
        // 괄호를 칠 수 있는 곳이 몇 번인지 체크
        int parenthesisNums = 0;
        for (int i = 0; i < strArr.length; i++) {
            if(i == 0){
                String[] strArrArr = strArr[i].split("\\+");
                int firstNum = Integer.parseInt(strArrArr[0]);
                int partialSumExceptFirstNum = 0;
                for (int j = 1; j < strArrArr.length; j++) {
                    partialSumExceptFirstNum += Integer.parseInt(strArrArr[j]);
                }
                if(isNegativeStart){
                    originals[i] = (-1) * firstNum + partialSumExceptFirstNum;
                    withParenthesis[i] = (-1) * (firstNum + partialSumExceptFirstNum);
                    if(strArrArr.length > 1){
                        parenthesisNums++;
                    }
                }else{
                    originals[i] = firstNum +partialSumExceptFirstNum;
                    withParenthesis[i] = originals[i];
                }
                differences[i] = originals[i] - withParenthesis[i];
            }else{
                String[] strArrArr = strArr[i].split("\\+");
                if(strArrArr.length > 1){
                    parenthesisNums++;
                }
                int firstNum = Integer.parseInt(strArrArr[0]);
                int partialSumExceptFirstNum = 0;
                for (int j = 1; j < strArrArr.length; j++) {
                    partialSumExceptFirstNum += Integer.parseInt(strArrArr[j]);
                }
                originals[i] = (-1) * firstNum + partialSumExceptFirstNum;
                withParenthesis[i] = (-1) * (firstNum + partialSumExceptFirstNum);
                differences[i] = originals[i] - withParenthesis[i];
            }
        }

        int minimum = 0;
        if(maxParenthesisPair >= parenthesisNums){
            for (int i = 0; i < strArr.length; i++) {
                minimum += withParenthesis[i];
            }
        }else{
            // differences를 기준으로 하여 삼중 merge sort
            int[][] tmps = new int[strArr.length][3];
            merge(0, strArr.length - 1, tmps);
            // differences가 큰 순서대로 괄호를 씌워야 최소값이 나온다.
            int index = 0;
            for (int i = strArr.length - 1; i >= 0; i--) {
                if(index >= parenthesisNums){
                    minimum += originals[i];
                }else{
                    if(originals[i] != withParenthesis[i]){
                        index++;
                    }
                    minimum += withParenthesis[i];
                }
            }
        }
        System.out.println(minimum);
        scn.close();
    }

    private static void merge(int start, int end, int[][] tmps){
        if(start >= end){
            return;
        }
        if(start == end - 1){
            if(differences[start] > differences[end]){
                int tmpDiff = differences[start];
                differences[start] = differences[end];
                differences[end] = tmpDiff;
                int tmpWP = withParenthesis[start];
                withParenthesis[start] = withParenthesis[end];
                withParenthesis[end] = tmpWP;
                int tmpOri = originals[start];
                originals[start] = originals[end];
                originals[end] = tmpOri;
            }
            return;
        }
        int mid = (start + end) / 2;
        merge(start, mid, tmps);
        merge(mid + 1, end, tmps);
        int left = start, right = mid + 1, index = left;
        while(left <= mid && right <= end){
            if(differences[left] <= differences[right]){
                tmps[index][0] = differences[left];
                tmps[index][1] = withParenthesis[left];
                tmps[index][2] = originals[left];
                left++;
            }else{
                tmps[index][0] = differences[right];
                tmps[index][1] = withParenthesis[right];
                tmps[index][2] = originals[right];
                right++;
            }
            index++;
        }
        if(left > mid){
            for (int i = right; i <= end; i++) {
                tmps[index][0] = differences[i];
                tmps[index][1] = withParenthesis[i];
                tmps[index][2] = originals[i];
                index++;
            }
        }else{
            for (int i = left; i <= mid; i++) {
                tmps[index][0] = differences[i];
                tmps[index][1] = withParenthesis[i];
                tmps[index][2] = originals[i];
                index++;
            }
        }
        for (int i = start; i <= end; i++) {
            differences[i] = tmps[i][0];
            withParenthesis[i] = tmps[i][1];
            originals[i] = tmps[i][2];
        }
    }
}
