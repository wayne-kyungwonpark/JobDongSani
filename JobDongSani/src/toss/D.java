package toss;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * 사용자의 편의를 위해서 최근 사용한 결제수단 순으로 화면에 표시하려고 합니다. 이를 위해 최근 사용한 순서대로 결제수단을 나열해주십시오.
 *
 *
 *
 * 규칙
 *
 *
 * 내가 기억할 수 있는 결제수단은 최근 5개의 결제수단이다.
 *
 * 주어진 input은 내가 사용한 순서대로 나열한 것이다. (나열된 값 중 가장 마지막 값이 사용자가 가장 최근에 사용한 결제수단이다)
 *
 * 주어진 input을 기준으로 매 결제수단 사용시 최근 5개 결제수단을 출력하시오.
 *
 *
 *
 * 우리 우리 우리 하나 우리 국민 삼성 농협 농협 농협 국민 저축
 *
 * 우리
 * 우리
 * 우리
 * 하나 우리
 * 우리 하나
 * 국민 우리 하나
 * 삼성 국민 우리 하나
 * 농협 삼성 국민 우리 하나
 * 농협 삼성 국민 우리 하나
 * 농협 삼성 국민 우리 하나
 * 국민 농협 삼성 우리 하나
 * 저축 국민 농협 삼성 우리
 */
public class D {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        String[] banks = input.split(" ");

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < banks.length; i++){
            Set<String> set = new HashSet<>(); // 출력 시 중복 방지를 위한 HashSet
            for(int j = i; j >= 0; j--){
                if(set.size() == 5){
                    break;
                }
                if(!set.contains(banks[j])){
                    if(set.size() != 0){
                        sb.append(" ");
                    }
                    sb.append(banks[j]);
                    set.add(banks[j]);
                }
            }
            if(i != banks.length - 1){
                sb.append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
