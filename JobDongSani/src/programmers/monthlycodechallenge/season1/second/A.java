package programmers.monthlycodechallenge.season1.second;

public class A {
    public static void main(String[] args) {
//        int n = 45;
        int n = 125;
//        int n = 100000000;
        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = 0;

        StringBuilder sb = new StringBuilder();
        while(n >= 1){
            int rest = n % 3;
            n /= 3;
            sb.append(rest);
        }

        char[] reverse = sb.toString().toCharArray();
        int nonzero = 0;
        for (int i = reverse.length - 1; i >= 0; i--) {
            if(reverse[i] != '0'){
                break;
            }else{
                nonzero++;
            }
        }
        int exp = 1;
        for (int i = 0; i < reverse.length - nonzero; i++) {
            answer += (exp * Integer.parseInt(String.valueOf(reverse[reverse.length - 1 - i])));
            exp *= 3;
        }

        return answer;
    }
}
