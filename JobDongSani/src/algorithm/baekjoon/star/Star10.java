package algorithm.baekjoon.star;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Star10 {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();
        int exp = 0;
        String[] strArr = new String[num];
        int tmp = num;
        while(tmp != 1){
            tmp /= 3;
            exp++;
        }
        String[] tmpArr = {"*"};
        for (int i = 1; i <= exp; i++) {
            //
            String[] newTmpArr = new String[(int)Math.pow(3, i)];
            for (int j = 0; j < tmpArr.length; j++) {
                newTmpArr[j] = tmpArr[j] + tmpArr[j] + tmpArr[j];
            }
            //
            StringBuilder spaces = new StringBuilder();
            for (int j = 0; j < (int)Math.pow(3, i - 1); j++) {
                spaces.append(" ");
            }
            int indexForCopy = 0;
            for (int j = tmpArr.length; j < tmpArr.length * 2; j++) {
                newTmpArr[j] = tmpArr[indexForCopy] + spaces.toString() + tmpArr[indexForCopy];
                indexForCopy++;
            }
            //
            indexForCopy = 0;
            for (int j = tmpArr.length * 2; j < tmpArr.length * 3; j++) {
                newTmpArr[j] = newTmpArr[indexForCopy++];
            }
            tmpArr = newTmpArr;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < tmpArr.length; i++) {
            bw.write(tmpArr[i]);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
