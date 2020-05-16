package naver.financial;

import java.util.*;
public class Solution2 {
    public static void main(String[] args) {
        System.out.println(solution("rather", "harder"));
        System.out.println(solution("apple", "pear"));
        System.out.println(solution("lemon", "melon"));
        System.out.println(solution("admirer", "married"));
    }

    /**
     * save the each frequencies for the character in A, B (aMap, bMap)
     * then, check the differences and return the sum of differences.
     *
     * @param A
     * @param B
     * @return the minimum number of added characters which A and B are anagrams of one another.
     */
    public static int solution(String A, String B) {
        char[] chArrA = A.toCharArray();
        char[] chArrB = B.toCharArray();

        Map<Character, Integer> aMap = new HashMap<>();
        Map<Character, Integer> bMap = new HashMap<>();

        for (int i = 0; i < chArrA.length; i++) {
            if(aMap.containsKey(chArrA[i])){
                aMap.put(chArrA[i], aMap.get(chArrA[i]) + 1);
            }else{
                aMap.put(chArrA[i], 1);
            }
        }

        for (int i = 0; i < chArrB.length; i++) {
            if(bMap.containsKey(chArrB[i])){
                bMap.put(chArrB[i], bMap.get(chArrB[i]) + 1);
            }else{
                bMap.put(chArrB[i], 1);
            }
        }

        int answer = 0;
        char check = 'a';
        while(check <= 'z'){
            int num1 = aMap.getOrDefault(check, 0);
            int num2 = bMap.getOrDefault(check, 0);
            answer += Math.abs(num1 - num2);
            check++;
        }

        return answer;
    }
}
