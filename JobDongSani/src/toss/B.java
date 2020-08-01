package toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 입력으로 들어온 로또 번호 문자열의 유효성을 검사하는 코드를 작성해주십시오.
 *
 *
 *
 * 규칙
 *
 *
 * 로또 번호는 중복되지 않는 숫자 6개로 구성된다.
 *
 * 각 번호는 1 부터 45 까지의 숫자로 구성된다.
 *
 * 로또 번호는 오름차순으로 정렬되어야 한다.
 *
 *
 * 위의 규칙을 모두 준수하는 로또 번호면 true 그렇지 않으면 false를 출력하는 코드를 구현해주시면 됩니다.
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
 * 123456
 * 출력
 * true
 * 예시 2
 * 입력
 * 135779
 * 출력
 * false
 * 예시 3
 * 입력
 * 12456
 * 출력
 * false
 * 예시 4
 * 입력
 * 213579
 * 출력
 * false
 * 예시 5
 * 입력
 * 4613579
 * 출력
 * false
 * ⋇ 입출력 형식을 잘 지켜주세요
 */
public class B {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] strArr = input.split(" ");
        if(strArr.length != 6){ // 로또 번호의 길이가 6이 아닐 경우
            System.out.println("false");
            return;
        }
        int[] lotto = new int[strArr.length];
        int[] sortedLotto = new int[strArr.length]; // 정렬 및 비교 대상

        for(int i = 0; i < strArr.length; i++){
            int num = Integer.parseInt(strArr[i]);
            lotto[i] = num;
            sortedLotto[i] = num;
        }

        Arrays.sort(sortedLotto);

        boolean follow = true;
        for(int i = 0; i < strArr.length; i++){
            // lotto의 원소가 정렬된 것과 다르거나 혹은 정렬된 숫자가 이전 것과 같을 경우, 그리고 [1, 45] 구간에 있지 않을 경우 false
            if(lotto[i] != sortedLotto[i]
                    || (i != 0 && sortedLotto[i - 1] == sortedLotto[i])
                    || (lotto[i] < 1 || lotto[i] > 45)){
                follow = false;
                break;
            }
        }

        if(follow){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
