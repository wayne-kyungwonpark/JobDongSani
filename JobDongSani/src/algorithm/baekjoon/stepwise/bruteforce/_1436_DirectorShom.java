package algorithm.baekjoon.stepwise.bruteforce;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class _1436_DirectorShom {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        int NCheck = N;
        int addNum = 0;
        while(NCheck > 0){
            HashSet<Integer> set = new HashSet<>();
            find666Num(addNum, set);
            if(set.size() >= NCheck){
                // set 정렬
                Integer[] arr = new Integer[set.size()];
                arr = set.toArray(arr);
                Arrays.sort(arr);
                // NCheck번째 수 출력
                System.out.println(arr[NCheck - 1]);
                break;
            }
            addNum++; NCheck -= set.size();
        }
        scn.close();
    }

    // 666에 addNum만큼의 자리를 붙여 만들 수 있는 종말의 숫자의 set을 만든다.
    private static void find666Num(int addNum, HashSet<Integer> set){
        if(addNum == 0){
            set.add(666);
            return;
        }
        // xx...x666, x...x666x, ... , x666x...x, 666xx...x 까지의 수를 set에 넣는다.
        // 맨 앞자리 수는 1부터.. 즉 10...00 ~ 99...99까지 수 사이에 666을 끼워넣자.
        // 만약 666이 맨 앞으로 올 경우에는 00...00 ~ 99...99까지의 수를 넣으면 된다.
        int end = (int) Math.pow(10, addNum) - 1;
        int nonZeroStart = (int) Math.pow(10, addNum - 1);
        for (int i = 0; i <= end; i++) {
            char[] numChar = zeroPadding(i, addNum);
            // 666이 맨 앞으로 오는 경우는 앞자리가 0으로 시작하는 것들도 넣을 수 있음
            if(i < nonZeroStart){
                char[] tmpArr = new char[numChar.length + 3];
                tmpArr[0] = '6'; tmpArr[1] = '6'; tmpArr[2] = '6';
                for (int j = 3; j < tmpArr.length; j++) {
                    tmpArr[j] = numChar[j - 3];
                }
                set.add(Integer.parseInt(new String(tmpArr)));
            }else{
                // 666을 하나의 수로 보고, 몇 번째에 올 지를 j로 결정한다.
                for (int j = 0; j < addNum + 1; j++) {
                    char[] tmpArr = new char[numChar.length + 3];
                    int numCharIndex = 0;
                    for (int k = 0; k < tmpArr.length; k++) {
                        if(k >= j && k < j + 3){
                            tmpArr[k] = '6';
                        }else{
                            tmpArr[k] = numChar[numCharIndex++];
                        }
                    }
                    set.add(Integer.parseInt(new String(tmpArr)));
                }
            }
        }

    }

    // 숫자가 addNum 자리보다 작은 경우, zero padding 해줘야 함
    private static char[] zeroPadding(int num, int addNum){
        String numStr = String.valueOf(num);
        char[] chArr = numStr.toCharArray();
        if(numStr.length() == addNum){
            return chArr;
        }else{
            char[] tmpArr = new char[addNum];
            int zeroPaddingNum = addNum - numStr.length();
            for (int i = 0; i < zeroPaddingNum; i++) {
                tmpArr[i] = '0';
            }
            for (int i = zeroPaddingNum; i < addNum; i++) {
                tmpArr[i] = chArr[i - zeroPaddingNum];
            }
            return tmpArr;
        }
    }
}
