package programmers.skillchecktest2;

public class Problem2 {
    public int solution(int n) {
        int answer = 1;
        int limit = 0;
        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum += i;
            if(sum > n){
                limit = i - 1;
                break;
            }
        }
        if(n % 2 != 0){
            boolean isOdd = false;
            for (int i = 2; i <= limit; i++) {
                if(isOdd){
                    if(n % i == 0){
                        answer++;
                    }
                }else{
                    if(n % i == (i / 2)){
                        answer++;
                    }
                }
                isOdd = !isOdd;
            }
        }else{
            boolean isEven = true;
            for (int i = 2; i <= limit; i++) {
                if(!isEven){
                    if(n % i == 0){
                        answer++;
                    }
                }else{
                    if(n % i == (i / 2)){
                        answer++;
                    }
                }
                isEven = !isEven;
            }
        }
        return answer;
    }
}
