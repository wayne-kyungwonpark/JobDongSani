package algorithm.samsung;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _1244_MaxPrizeMoney {
    private static int findMax(char[] numPlate, int exchange){
        char[] realMax = numPlate.clone();
        Arrays.sort(realMax);
        StringBuilder real = new StringBuilder();
        StringBuilder real2 = new StringBuilder();
        for (int i = realMax.length - 1; i >= 1; i--) {
            if(i == 1){
                real.append(realMax[i]).append(realMax[i - 1]);
                real2.append(realMax[i - 1]).append(realMax[i]);
            }else{
                real.append(realMax[i]);
                real2.append(realMax[i]);
            }
        }
        int realMaxInt = Integer.parseInt(real.toString());
        int realMaxInt2 = Integer.parseInt(real2.toString());
        LinkedList<char[]> stage = new LinkedList<>();
        stage.add(numPlate);
        for (int i = 0; i < exchange; i++) {
            LinkedList<char[]> tmpStage = new LinkedList<>();
            while(!stage.isEmpty()){
                char[] chArr = stage.pop();
                tmpStage.addAll(exchangeAll(chArr));
            }
            stage = (LinkedList<char[]>) tmpStage.clone();
            for(char[] tmp : stage){
                StringBuilder sb = new StringBuilder();
                for(char c : tmp){
                    sb.append(c);
                }
                int num = Integer.parseInt(sb.toString());
                if(num == realMaxInt){
                    if((exchange - 1 - i) % 2 == 0){
                        return realMaxInt;
                    }else{
                        return realMaxInt2;
                    }
                }
            }
        }

        int max = 0;
        for(char[] tmp : stage){
            StringBuilder sb = new StringBuilder();
            for(char i : tmp){
                sb.append(i);
            }
            int num = Integer.parseInt(sb.toString());
            if(num > max){
                max = num;
            }
            if(num == realMaxInt){
                break;
            }
        }
        return max;
    }

    private static List<char[]> exchangeAll(char[] numPlate){
        List<char[]> list = new ArrayList<>();
        for (int i = 0; i < numPlate.length - 1; i++) {
            for (int j = i + 1; j < numPlate.length; j++) {
                char[] copy = numPlate.clone();
                exchangeNumPlate(copy, i, j);
                list.add(copy);
            }
        }
        return list;
    }

    private static void exchangeNumPlate(char[] numPlate, int i, int j){
        char tmp = numPlate[i];
        numPlate[i] = numPlate[j];
        numPlate[j] = tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str;
        int testNum = 0, testFreq = 0;
        int exchange = 0;
        char[] numPlate = null;
        while((str = br.readLine()) != null){
            if(testNum == 0){
                testNum = Integer.parseInt(str);
            }else{
                testFreq++;
                String[] strArr = str.split(" ");
                numPlate = strArr[0].toCharArray();
                exchange = Integer.parseInt(strArr[1]);
                bw.write("#" + String.valueOf(testFreq) + " " + String.valueOf(findMax(numPlate, exchange)));
                bw.newLine();
                if(testFreq == testNum){
                    break;
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
