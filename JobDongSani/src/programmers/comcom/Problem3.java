package programmers.comcom;

import java.util.*;

public class Problem3 {
    public int[] solution(int[] grade) {
        int[] answer = new int[grade.length];
        int[] sortedGrade = Arrays.copyOf(grade, grade.length);
        Arrays.sort(sortedGrade);
        int[] reverseOrderGrade = new int[grade.length];
        for (int i = grade.length - 1; i >= 0; i--) {
            reverseOrderGrade[grade.length - 1 - i] = sortedGrade[i];
        }

        int nonDupGradeNums = 0;
        int[] reverseOrderNonDupGrade = new int[grade.length];
        int[] numsPerGrade = new int[grade.length]; // CDF처럼 누적 개념 생각하면 나중에 편함

        int prevNum = 0;
        for (int i = 0; i < grade.length; i++) {
            if(i == 0){
                reverseOrderNonDupGrade[nonDupGradeNums] = reverseOrderGrade[i];
                numsPerGrade[nonDupGradeNums]++;
                prevNum = reverseOrderNonDupGrade[nonDupGradeNums];
            }else{
                if(reverseOrderGrade[i] == prevNum){
                    numsPerGrade[nonDupGradeNums]++;
                }else{
                    reverseOrderNonDupGrade[++nonDupGradeNums] = reverseOrderGrade[i];
                    numsPerGrade[nonDupGradeNums] = numsPerGrade[nonDupGradeNums - 1] + 1;
                    prevNum = reverseOrderNonDupGrade[nonDupGradeNums];
                }
            }
        }

        for (int i = 0; i < grade.length; i++) {
            answer[i] = search(reverseOrderNonDupGrade, numsPerGrade, 0, nonDupGradeNums, grade[i]);
        }

        return answer;
    }

    public int search(int[] reverseOrderNonDupGrade, int[] numsPerGrade, int start, int end, int target){
        if(start == end){
            if(start == 0){
                return 1;
            }else{
                return numsPerGrade[start - 1] + 1;
            }
        }
        int mid = (start + end) / 2;
        if(target > reverseOrderNonDupGrade[mid]){
            return search(reverseOrderNonDupGrade, numsPerGrade, start, mid, target);
        }else if(target == reverseOrderNonDupGrade[mid]){
            if(mid == 0){
                return 1;
            }else{
                return numsPerGrade[mid - 1] + 1;
            }
        }else{
            return search(reverseOrderNonDupGrade, numsPerGrade, mid + 1, end, target);
        }
    }

}
