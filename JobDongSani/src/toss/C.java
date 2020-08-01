package toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 규칙
 *
 * compute(int n) 의 함수가 주어졌다
 * 주어진 compute 함수는 정수를 받아서 정수를 반환하지만, 1초가 걸린다.
 *
 * compute 함수는 동일한 인자가 주어지면 항상 동일한 수를 리턴한다.
 *
 *
 *
 * 중복이 2개 이상 포함된 n개의 정수가 주어졌을 때 함수를 이용하여 n초 미만으로 테스트 케이스를 통과하는 코드를 작성해주십시오.
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
 * 1134363
 * 출력
 * 97089708416007915416005821241600
 * ⋇ 입출력 형식을 잘 지켜주세요
 */
public class C {
    public static void main(String[] args) throws Exception {
        // [!!주의!!] Function.compute 함수는 이미 구현되어있지만, 숨김처리되어 있습니다. 호출해서 테스트 해주세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] strArr = input.split(" ");
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> numToComputeResult = new HashMap<>(); // 이전 결과를 저장시켜놓을 맵
        for(int i = 0; i < strArr.length; i++){
            int num = Integer.parseInt(strArr[i]);
            if(numToComputeResult.containsKey(num)){ // 결과가 기존에 있다면 있는 것을 사용
                sb.append(numToComputeResult.get(num));
            }else{ // 결과가 기존에 없다면 사용한 뒤 맵에 넣음
                int computeResult = Function.compute(num);
                sb.append(computeResult);
                numToComputeResult.put(num, computeResult);
            }
            if(i != strArr.length - 1){
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
