package programmers.blindtest2018;

public class Problem1Test {
    public static void main(String[] args) {
        Problem1 pr1 = new Problem1();
        String[] param = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] answer = pr1.solution(param);
        for (int i = 0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }
}
