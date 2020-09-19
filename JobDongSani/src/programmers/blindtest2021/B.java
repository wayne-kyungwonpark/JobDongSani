package programmers.blindtest2021;

import java.util.*;

public class B {
    public static void main(String[] args) {
//        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
//        int[] course = {2, 3, 4};
//        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
//        int[] course = {2, 3, 5};
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};
        String[] answer = solution(orders, course);
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    private static char A = 'A';
    private static char Z = 'Z';
    private static int length = Z - A + 1;

    public static String[] solution(String[] orders, int[] course) {
        // orders 내부 String 오름차순 정렬 (ABDC -> ABCD)
        for (int i = 0; i < orders.length; i++) {
            char[] chArr = orders[i].toCharArray();
            Arrays.sort(chArr);
            orders[i] = String.valueOf(chArr);
        }
        
        int[] cnt = new int[length];

        for (int i = 0; i < orders.length; i++) {
            char[] chArr = orders[i].toCharArray();
            for (int j = 0; j < chArr.length; j++) {
                cnt[chArr[j] - A]++;
            }
        }

        List<Integer> nonzero = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if(cnt[i] != 0){
                nonzero.add(i);
            }
        }

        PriorityQueue<String> answerQueue = new PriorityQueue<>();

//        List<String> answerList = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {
            List<String> candidateList = new ArrayList<>();
            List<Character> charList = new ArrayList<>();
            boolean[] visit = new boolean[length];
            find(course[i], 0, nonzero, visit, candidateList, charList);
            
            int maxCnt = 0;
            Map<Integer, List<String>> map = new HashMap<>();
            for (String candidate : candidateList) {
                char[] chArr = candidate.toCharArray();
                int orderFreq = 0;
                for (int j = 0; j < orders.length; j++) {
                    if(orderContains(candidate, orders[j])){
                        orderFreq++;
                    }
                }
                if(orderFreq >= 2){
                    if(!map.containsKey(orderFreq)){
                        map.put(orderFreq, new ArrayList<>());
                    }
                    map.get(orderFreq).add(candidate);
                }
                maxCnt = Math.max(maxCnt, orderFreq);
            }

            if(maxCnt >= 2){
                for(String candidate : map.get(maxCnt)){
                    answerQueue.offer(candidate);
                }
            }
        }

        String[] answer = new String[answerQueue.size()];
        int index = 0;
        while(!answerQueue.isEmpty()){
            answer[index++] = answerQueue.poll();
        }

        return answer;
    }
    
    // candidate를 order가 가지고 있는지 확인
    private static boolean orderContains(String candidate, String order){
        char[] chArr1 = candidate.toCharArray();
        char[] chArr2 = order.toCharArray();
        for (int i = 0; i < chArr1.length; i++) {
            if(Arrays.binarySearch(chArr2, chArr1[i]) < 0){
                return false;
            }
        }
        return true;
    }

    private static void find(int rest, int index, List<Integer> nonzero, boolean[] visit, List<String> candidateList, List<Character> charList) {
        if(rest == 0){
            StringBuilder sb = new StringBuilder();
            for(char c : charList){
                sb.append(c);
            }
            candidateList.add(sb.toString());
            return;
        }

        for (int i = index; i < nonzero.size(); i++) {
            if(!visit[nonzero.get(i)]){
                visit[nonzero.get(i)] = true;
                charList.add((char) (nonzero.get(i) + A));
                find(rest - 1, i + 1, nonzero, visit, candidateList, charList);
                visit[nonzero.get(i)] = false;
                charList.remove((charList.size() - 1));
            }
        }
    }
}
