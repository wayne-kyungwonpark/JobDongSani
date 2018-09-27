package kakao.test;

import java.util.HashMap;
import java.util.Map;

public class Number1 {

	private static String[] solution(String[] record) {
		String[] answer = {};
		Map<String, Integer> uidToLastnum = new HashMap<String, Integer>();
		Map<String, String> uidToNickname = new HashMap<String, String>();
		int answerLength = 0;
		for(int i=0;i<record.length;i++) {
			String[] strArr = record[i].split(" ");
			if("Enter".equals(strArr[0]) || "Leave".equals(strArr[0])) {
				answerLength++;
			}
			if(uidToLastnum.containsKey(strArr[1])) {
				uidToLastnum.put(strArr[1], uidToLastnum.get(strArr[1]) + 1);
			}else {
				uidToLastnum.put(strArr[1], 1);
			}
			if(strArr.length == 3) {
				uidToNickname.put(strArr[1], strArr[2]);
			}
		}
		answer = new String[answerLength];
		int answerFreq = 0;
		for(int i=0;i<record.length;i++) {
			String[] strArr = record[i].split(" ");
			StringBuilder sb = new StringBuilder();
			if("Enter".equals(strArr[0])) {
				sb.append(uidToNickname.get(strArr[1])).append("님이 들어왔습니다.");
				answer[answerFreq] = sb.toString();
				answerFreq++;
			}else if("Leave".equals(strArr[0])) {
				sb.append(uidToNickname.get(strArr[1])).append("님이 나갔습니다.");
				answer[answerFreq] = sb.toString();
				answerFreq++;
			}else {
				
			}
		}
		return answer;
	}
	
//	["Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"]	
//	["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
	
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
		String[] result = solution(record);
		for(int i=0;i<result.length;i++) {
			System.out.println(result[i]);
		}
	}
}
