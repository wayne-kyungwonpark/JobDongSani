package toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 김토스와 이토스 두 사람이 있습니다.
 *
 *
 *
 * 규칙
 *
 *
 * 김토스는 이토스에게 매일 특정 금액을 줘야한다
 *
 * 이토스는 김토스에게 매일 특정 금액을 줘야한다
 *
 * 두 명이 서로 주는게 귀찮아서, 항상 김토스가 이토스에게 받을 금액을 감안해서 이토스에게 돈을 준다
 *
 *
 *
 * 김토스가 당일 이토스에게 줘야 할 금액을 출력하는 코드를 작성해주십시오.
 *
 *
 *
 *
 *
 * 예시
 *
 *
 *
 * 김토스 >이토스
 *
 * 100
 *
 * 300
 *
 * 10
 *
 * 0
 *
 * 40
 *
 * 0
 *
 * 0
 *
 * 70
 *
 * 65
 * 이토스
 *
 * >김토스
 *
 * 40
 *
 * 300
 *
 * 20
 *
 * 10
 *
 * 10
 *
 * 20
 *
 * 100
 *
 * 10
 *
 * 0
 * 김토스
 *
 * >이토스
 *
 * (결과)
 *
 * 60
 *
 * 0
 *
 * 0
 *
 * 0
 *
 * 10
 *
 * 0
 *
 * 0
 *
 * 0
 *
 * 5
 *
 *
 *
 *
 *
 * 입/출력 예시
 * :
 * 공백
 * :
 * 줄바꿈
 * :
 * 탭
 * 예시 1
 * 입력
 * 100 300 10 0 40 0 0 70 65
 * 40 300 20 10 10 20 100 10 0
 * 출력
 * 60 0 0 0 10 0 0 0 5
 * ⋇ 입출력 형식을 잘 지켜주세요
 */
public class E {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] kimToss = br.readLine().split(" ");
        String[] leeToss = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        long debtKimToLee = 0; // 김토스가 이토스에게 진 빚
        for(int i = 0; i < kimToss.length; i++){
            int kimToLee = Integer.parseInt(kimToss[i]);
            int leeToKim = Integer.parseInt(leeToss[i]);
            if(kimToLee >= (leeToKim + debtKimToLee)){
                sb.append(kimToLee - (leeToKim + debtKimToLee));
                debtKimToLee = 0;
            }else{
                sb.append(0);
                debtKimToLee += (leeToKim - kimToLee);
            }
            if(i != kimToss.length - 1){
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
