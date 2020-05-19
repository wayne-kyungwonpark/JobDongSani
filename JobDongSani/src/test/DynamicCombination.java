package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DynamicCombination {
    public static void main(String[] args) {
        List<Integer>[] input = new List[3];
        List<Integer> list1 = new ArrayList<>();
        list1.add(1); list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3); list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(5);
        input[0] = list1;
        input[1] = list2;
        input[2] = list3;
//        List<Integer>[] input = new List[4];
//        List<Integer> list1 = new ArrayList<>();
//        list1.add(1); list1.add(2); list1.add(3); list1.add(4); list1.add(5);
//        List<Integer> list2 = new ArrayList<>();
//        list2.add(3);
//        List<Integer> list3 = new ArrayList<>();
//        list3.add(6); list3.add(7); list3.add(8);
//        List<Integer> list4 = new ArrayList<>();
//        list4.add(9); list4.add(10); list4.add(11);
//        input[0] = list1;
//        input[1] = list2;
//        input[2] = list3;
//        input[3] = list4;

        printCombination(input);

    }

    private static void printCombination(List<Integer>[] input){
        int size = 1;
        for (int i = 0; i < input.length; i++) {
            size *= input[i].size();
        }

        StringBuilder sb = new StringBuilder();

        int[] indexs = new int[input.length];
        LinkedList<Integer> combination = new LinkedList<>();
        boolean[] check = new boolean[input.length];

        makeAnswer(input, 0, combination, sb);
        System.out.println(sb.toString());
    }

    private static void makeAnswer(List<Integer>[] input, int index, LinkedList<Integer> combination, StringBuilder sb){
        if(combination.size() == input.length){
            for(int num : combination){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < input[index].size(); i++) {
            combination.add(input[index].get(i));
            makeAnswer(input, index + 1, combination, sb);
            combination.removeLast();
        }
    }

}
