package toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 회사 14층에는 바리스타분 들이 직접 내려주시는 커피를 마실 수 있는 공간이 있다. 그 공간에 설치된 바 테이블의 둘레를 구하십시오.
 *
 *
 *
 * 규칙
 *
 *
 * 바 테이블의 영역, 입력은 0과 1로 이루어진 문자열로 구성된다.
 *
 * 0은 빈 공간, 1은 테이블이 있는 공간이다.
 *
 * 1과 1이 상하좌우 어디 방향으로든 연속적이면 그 두 영역은 연결된 영역으로 구분한다.
 *
 * 각 문자는 공백 한 칸으로, 각 한 줄은 세미콜론(;)로 구분된다.
 *
 * 입력 데이터가 n*m 일 때 모든 행은 동일한 길이를 가진다.
 *
 *
 * 입력의 테이블은 하나의 연속된 테이블 정보를 나타내고 있다.
 *
 * 테이블의 둘레는 바깥 둘레 뿐만 아니라 안쪽 둘레까지 구해야 한다.
 *
 *
 *
 * 0 0 0 0 0
 *
 * 0 1 1 1 0
 *
 *
 * 0 1 0 1 0  -> 둘레: 16
 *
 * 0 1 1 1 0
 *
 * 0 0 0 0 0
 *
 *
 *
 * 인풋 데이터의 최소 크기는 가로 3칸, 세로 3칸 이상이며 각 상하좌우 끝은 0으로 둘러싸여 있다고 가정한다.
 *
 *
 *
 * 0 0 0
 *
 * 0 1 0   ->   0 0 0;0 1 0;0 0 0;
 *
 * 0 0 0
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
 * 0 0 0 0;0 1 1 0;0 0 1 0;0 0 0 0
 * 출력
 * 8
 * ⋇ 입출력 형식을 잘 지켜주세요
 */
public class F {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] strArr = input.split(";");
        String[] strArrInner = strArr[0].split(" ");
        int[][] space = new int[strArr.length][strArrInner.length];
        for(int i = 0; i < strArr.length; i++){
            String[] inner = strArr[i].split(" ");
            for(int j = 0; j < inner.length; j++){
                space[i][j] = Integer.parseInt(inner[j]);
            }
        }

        long answer = 0;
        for(int i = 0; i < space.length; i++){
            for(int j = 0; j < space[i].length; j++){
                if(space[i][j] == 1){
                    if(space[i - 1][j] == 0){
                        answer++;
                    }
                    if(space[i + 1][j] == 0){
                        answer++;
                    }
                    if(space[i][j - 1] == 0){
                        answer++;
                    }
                    if(space[i][j + 1] == 0){
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
