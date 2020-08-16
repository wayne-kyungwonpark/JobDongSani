package algorithm.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1255_MaximumScoreWordsFormedByLetters {
    public static void main(String[] args) {
        String[] words = {"dog","cat","dad","good"};
        char[] letters = {'a','a','c','d','d','d','g','o','o'};
        int[] score = {1,0,9,5,0,0,3,0,0,0,0,0,0,0,2,0,0,0,0,0,0,0,0,0,0,0};
//        String[] words = {"xxxz","ax","bx","cx"};
//        char[] letters = {'z','a','b','c','x','x','x'};
//        int[] score = {4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10};
        System.out.println(maxScoreWords(words, letters, score));
    }

    private static Map<Character, Integer> letterNums;
    private static Map<String, Integer> wordScores;
    private static List<Map<Character, Integer>> listOfLetterNumsInWord;
    private static int maxScore = 0;

    public static int maxScoreWords(String[] words, char[] letters, int[] score) {
        maxScore = 0;

        letterNums = new HashMap<>();
        for (int i = 0; i < letters.length; i++) {
            letterNums.put(letters[i], letterNums.getOrDefault(letters[i], 0) + 1);
        }

        wordScores = new HashMap<>();
        listOfLetterNumsInWord = new ArrayList<>();
        for (String word : words) {
            char[] chArr = word.toCharArray();
            Map<Character, Integer> letterNumsInWord = new HashMap<>();
            for (int i = 0; i < chArr.length; i++) {
                letterNumsInWord.put(chArr[i], letterNumsInWord.getOrDefault(chArr[i], 0) + 1);
            }
            listOfLetterNumsInWord.add(letterNumsInWord);
            boolean isPossible = true;
            int wordScore = 0;
            for(char letter : letterNumsInWord.keySet()){
                if(!letterNums.containsKey(letter) || letterNumsInWord.get(letter) > letterNums.get(letter)){
                    isPossible = false;
                    break;
                }
                int index = letter - 'a';
                wordScore += (letterNumsInWord.get(letter) * score[index]);
            }
            if (isPossible){
                wordScores.put(word, wordScore);
            }else{
                wordScores.put(word, 0);
            }
        }

        brute(words, 0, 0);

        return maxScore;
    }

    private static void brute(String[] words, int current, int scoreSum) {
        if(current >= words.length){
            maxScore = Math.max(maxScore, scoreSum);
            return;
        }

        // words[current] 포함
        boolean isPossible = true;
        int possibleIndex = -1;
        for(char letter : listOfLetterNumsInWord.get(current).keySet()){
            if(letterNums.containsKey(letter) && letterNums.get(letter) >= listOfLetterNumsInWord.get(current).get(letter)){
                letterNums.put(letter, letterNums.get(letter) - listOfLetterNumsInWord.get(current).get(letter));
                possibleIndex++;
            }else{
                isPossible = false;
                break;
            }
        }
        if(isPossible){
            brute(words, current + 1, scoreSum + wordScores.get(words[current]));
        }
        int tmpIndex = -1;
        for(char letter : listOfLetterNumsInWord.get(current).keySet()){
            if(tmpIndex < possibleIndex){
                letterNums.put(letter, letterNums.getOrDefault(letter, 0) + listOfLetterNumsInWord.get(current).get(letter));
                tmpIndex++;
            }
        }

        // words[current] 미포함
        brute(words, current + 1, scoreSum);
    }
}
