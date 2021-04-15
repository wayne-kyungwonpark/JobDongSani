package programmers.monthlycodechallenge.season1.third;

public class B {
    private static int zeros = 0;
    private static int convertNum = 0;

    public static void main(String[] args) {
        solution("0111010");
        System.out.println(convertNum);
        System.out.println(zeros);
    }

    public static int[] solution(String s) {
        int[] answer = new int[2];

        while(!"1".equals(s)){
            s = convert(s);
            convertNum++;
        }

        answer[0] = convertNum;
        answer[1] = zeros;
        return answer;
    }

    private static String convert(String s){
        char[] chArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int length = 0;
        for (int i = 0; i < chArr.length; i++) {
            if(chArr[i] != '0'){
                length++;
            }else{
                zeros++;
            }
        }
        while(length >= 1){
            sb.append(length % 2);
            length /= 2;
        }
        return sb.reverse().toString();
    }
}
