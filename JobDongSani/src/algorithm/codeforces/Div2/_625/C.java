package algorithm.codeforces.Div2._625;

import java.io.*;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int length = Integer.parseInt(br.readLine());
        LinkedList<Character> charList = new LinkedList<>();
        char[] chArr = br.readLine().toCharArray();
        for (int i = 0; i < length; i++) {
            charList.add(chArr[i]);
        }
        // from 'z' to 'a'
        char check = 'z';
        int nums = 0;
        for (int i = 0; i < 26; i++) {
            if(charList.contains(check)){
                int j;
                for (j = 0; j < length; j++) {
                    char present = charList.get(j);
                    if(present == check){
                        if((j != 0 && charList.get(j - 1) == check - 1) || (j != length - 1 && charList.get(j + 1) == check - 1)){
                            charList.remove(j);
                            nums++;
                            length--;
                            j--;
                        }
                    }
                }
            }
            check--;
        }
        sb.append(nums);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
