package algorithm.codeforces.Div2.Educational._82;

import java.io.*;
import java.util.*;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            Map<Character, List<Character>> adjMap = new HashMap<>();
            char[] chArr = br.readLine().toCharArray();
            boolean isPossible = true;
            boolean[] check = new boolean[26];
            for (int j = 0; j < chArr.length; j++) {
                if(!adjMap.containsKey(chArr[j])){
                    List<Character> chList = new ArrayList<>();
                    adjMap.put(chArr[j], chList);
                }
                if(j != 0){
                    adjMap.get(chArr[j]).add(chArr[j - 1]);
                }
                if(j != chArr.length - 1){
                    adjMap.get(chArr[j]).add(chArr[j + 1]);
                }
                check[chArr[j] - 97] = true;
                if(adjMap.get(chArr[j]).size() > 2){
                    isPossible = false;
                    break;
                }
            }
            if(!isPossible){
                sb.append("NO").append("\n");
            }else{
                LinkedList<Character> makeS = new LinkedList<>();
                for (int j = 0; j < check.length; j++) {
                    if(check[j]){
                        char a = 97;
                        a += j;
                        makeS.add(a);

                    }
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
