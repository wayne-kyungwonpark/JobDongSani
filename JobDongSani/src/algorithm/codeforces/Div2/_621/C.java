package algorithm.codeforces.Div2._621;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Integer> msgCounts = new HashMap<>();
        String str = br.readLine();
        char[] chArr = str.toCharArray();
        for (int hops = 1; hops <= str.length(); hops++) {
            for (int startIndex = 0; startIndex < str.length(); startIndex++) {
                StringBuilder msgSb = new StringBuilder();
                int k = 0;
                if(hops != 1){
                    msgSb.append(chArr[startIndex]);
                    k++;
                }
                while(startIndex + k * hops <= str.length() - 1) {
                    msgSb.append(chArr[startIndex + k * hops]);
                    String tmp = msgSb.toString();
                    if(msgCounts.containsKey(tmp)){
                        msgCounts.put(tmp, msgCounts.get(tmp) + 1);
                    }else{
                        msgCounts.put(tmp, 1);
                    }
                    k++;
                }
            }
        }

        int maxOcc = Integer.MIN_VALUE;
        Iterator<String> msgSet = msgCounts.keySet().iterator();
        while(msgSet.hasNext()){
            maxOcc = Math.max(maxOcc, msgCounts.get(msgSet.next()));
        }

        bw.write(String.valueOf(maxOcc));
        bw.flush();
        bw.close();
        br.close();
    }
}
