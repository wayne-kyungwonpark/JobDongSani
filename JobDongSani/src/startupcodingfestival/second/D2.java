package startupcodingfestival.second;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class D2 {
    private static Map<Character, Map> trie = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            char[] chArr = br.readLine().toCharArray();
            Map<Character, Map> tmp = trie;
            for (int j = 0; j < chArr.length; j++) {
                if(!tmp.containsKey(chArr[j])){
                    tmp.put(chArr[j], new HashMap<Character, Map>());
                }
                tmp = tmp.get(chArr[j]);
            }
        }
        int Q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            String search = br.readLine();
            int num = find(trie, search.toCharArray(), 0);
            sb.append(num).append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int find(Map<Character, Map> present, char[] searchArr, int index){
        if(present == null || present.isEmpty()){
            return 0;
        }
        if(index == searchArr.length - 1){
            if(present.containsKey(searchArr[index])){
                return findLeafNums(present.get(searchArr[index])); // 하위 노드를 루트로 하는 트리의 리프 노드 갯수만큼 존재
            }
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if(searchArr[index] == (char) ('a' + i)){
                sum += find(present.get(searchArr[index]), searchArr, index + 1);
            }else{
                if(index == 0){
                    sum += find(present.get((char) ('a' + i)), searchArr, index);
                }
            }
        }
        return sum;
    }

    private static int findLeafNums(Map<Character, Map> present){
        if(present.isEmpty()){
            return 1;
        }
        int leafs = 0;
        for (int i = 0; i < 26; i++) {
            if(present.containsKey((char) ('a' + i))){
                leafs += findLeafNums(present.get((char) ('a' + i)));
            }
        }
        return leafs;
    }
}
