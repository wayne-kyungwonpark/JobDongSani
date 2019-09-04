package programmers.blindtest2018;

import java.util.ArrayList;
import java.util.HashMap;

public class Problem1 {
//    ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
//    ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
    public String[] solution(String[] record) {
        String[] answer = {};
        // uid : nickname map
        HashMap<String, String> uidNickMap = new HashMap<>();
        // ["uid", "님이 들어왔습니다"]
        ArrayList<String[]> answerList = new ArrayList<>();
        // record를 돌면서 answerList에 들어갈 uid와 문구를 넣는다.
        for (int i = 0; i < record.length; i++) {
            String[] strArr = record[i].split(" ");
            if("Enter".equals(strArr[0])){
                String[] elem = new String[2];
                elem[0] = strArr[1];
                elem[1] = "님이 들어왔습니다.";
                answerList.add(elem);
                uidNickMap.put(strArr[1], strArr[2]);
            }else if("Leave".equals(strArr[0])){
                String[] elem = new String[2];
                elem[0] = strArr[1];
                elem[1] = "님이 나갔습니다.";
                answerList.add(elem);
            }else{
                uidNickMap.put(strArr[1], strArr[2]);
            }
        }
        answer = new String[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = uidNickMap.get(answerList.get(i)[0]) + answerList.get(i)[1];
        }
        return answer;
    }
}
