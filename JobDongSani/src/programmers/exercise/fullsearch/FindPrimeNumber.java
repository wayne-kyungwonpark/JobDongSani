package programmers.exercise.fullsearch;

import java.util.*;

public class FindPrimeNumber {
    public static void main(String[] args) {
//        String numbers = "13579";
        String numbers = "137";
        System.out.println(solution(numbers));
    }

    public static int solution(String numbers) {
        int answer = 0;
        char[] chArr = numbers.toCharArray();

        Set<Integer> numSet = new HashSet<>();

        int start = (1 << numbers.length()) - 1;
        for (int i = start; i >= 1; i--) {
            ArrayList<Integer> nums = new ArrayList<>();
            int check = 1;
            int index = numbers.length() - 1;
            while(check < start){
                if((i & check) == check){
                    nums.add(Integer.parseInt(String.valueOf(chArr[index])));
                }
                index--;
                check = check << 1;
            }

            LinkedList<Integer> combination = new LinkedList<>();
            boolean[] checklist = new boolean[nums.size()];

            addAllCombination(nums, numSet, combination, checklist);
        }

        Iterator<Integer> iter = numSet.iterator();
        while(iter.hasNext()){
            if(isPrime(iter.next())){
                answer++;
            }
        }

        return answer;
    }

    private static void addAllCombination(ArrayList<Integer> nums, Set<Integer> numSet, LinkedList<Integer> combination, boolean[] checklist) {
        if(combination.size() == nums.size()){
            StringBuilder sb = new StringBuilder();
            for (int each : combination) {
                sb.append(each);
            }
            numSet.add(Integer.parseInt(sb.toString()));
            return;
        }
        for (int i = 0; i < nums.size(); i++) {
            if(!checklist[i]){
                checklist[i] = true;
                combination.add(nums.get(i));
                addAllCombination(nums, numSet, combination, checklist);
                combination.removeLast();
                checklist[i] = false;
            }
        }
    }

    private static boolean isPrime(int num){
        if(num == 1 || num % 2 == 0){
            return false;
        }
        int sqrt = (int) Math.sqrt(num) + 1;
        for (int i = 3; i <= sqrt; i += 2) {
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}
