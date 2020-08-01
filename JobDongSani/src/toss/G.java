package toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 아래의 규칙을 따르는 데이터가 어떤 공간 A에 있다고 가정할 때 유효데이터를 차례대로 새로운 공간 B에 옮기는 코드를 작성해주십시오.
 *
 *
 *
 * 입력 예시
 *
 * 4; 1 30 0 6 0 2 1 3
 *
 *
 *
 * 규칙
 *
 * 공간 A와 공간 B는 동일하게 크기가 8인 공간을 가지고 있다.
 *
 * 각 공간의 주소는 0부터 7까지의 주소로 표현한다.
 *
 * 각 공간의 크기와 별개로 공간의 가장 앞 자리에는 해당 공간의 첫 유효한 데이터의 주소를 나타내는 Starting Pointer가 들어간다.
 *
 * 하나의 데이터는 크기가 항상 2이며 첫 번째 자리에는 데이터의 형식, 두 번째 자리에는 그 값이 들어간다.
 *
 * 각 포인터가 가리키는 대상 데이터는 유효한 데이터이므로 새로운 공간으로 옮겨져야 한다.
 *
 * 새로운 공간의 Starting pointer는 항상 0이다.
 *
 * 새로운 공간으로 옮겨질 때는 각 유효 데이터가 기존 공간에서 유효한 데이터의 순서대로 새로운 공간에 연속적인 공간에 놓여져야 하며, 남는 공간이 있다면 0으로 채워져야 한다.
 *
 *
 *
 *
 *
 * 데이터
 *
 * 첫 번째 자리에 0이 오면 그 다음 자리의 값은 포인터를 의미합니다.
 *
 * 예) 0 6 => 주소 6을 가리키는 포인터
 *
 *
 *
 * 첫 번째 자리에 1이 오면 그 다음 자리의 값은 숫자 값을 의미합니다.
 *
 * 예) 1 30 => 숫자 값 30
 *
 *
 *
 *
 *
 * 입력 설명
 *
 * 입력은 아래와 같이 제일 처음에 Starting Pointer와 함께 공간에 존재하는 내용들을 표시하고 있습니다.
 *
 *
 *
 * 4; 1 30 0 6 0 2 1 3
 *
 *
 *
 * 4가 Starting pointer가 되며, 이 포인터는 주소 4에 있는 (0 2)를 가리키고 있습니다.
 *
 * 공간의 주소 0이 가리키는 위치에는 1이 있고 마지막 주소인 7이 가리키는 위치에는 3이 있습니다.
 *
 *
 *
 * 풀이 예제
 *
 * Starting pointer 4는 주소 4를 가리킨다.
 *
 *
 *
 * 주소 4의 데이터는 유효하다는 것이다. 0으로 시작하므로 포인터이며 주소 2를 가리키는 데이터를 가지고 있다.
 *
 *
 *
 * 4; 1 30 0 6 0 2 1 3
 *
 *
 *
 * 주소 2의 데이터는 유효하다는 것이다. 0으로 시작하므로 포인터이며 주소 6을 가리키는 데이터를 가지고 있다.
 *
 *
 *
 * 4; 1 30 0 6 0 2 1 3
 *
 *
 *
 * 주소 6의 데이터는 유효하다는 것이다. 1으로 시작하므로 숫자 값 3의 데이터를 나타낸다.
 *
 *
 *
 * 4; 1 30 0 6 0 2 1 3
 *
 *
 *
 * 더 이상 유효한 데이터가 없으므로 새로운 공간으로 차례대로 옮겨온다.
 *
 *
 *
 * 새로운 공간의 Starting pointer는 항상 0 이므로 첫 번째 유효 데이터 0 2를 주소 0과 주소 1에 복사한다.
 *
 *
 *
 * 0; 0 2
 *
 *
 *
 * 두 번째 유효 데이터 0 6을 주소 2와 주소 3에 복사하고, 이 유효 데이터는 포인터므로 바로 다음 세 번째 유효 데이터를 가리키도록 0 4로 변경한다.
 *
 *
 *
 * 0; 0 2 0 4
 *
 *
 *
 * 마지막 세 번째 유효 데이터 1 3을 주소 4와 주소 5에 복사하고 남은 주소 6과 주소 7에는 0으로 채운다.
 *
 *
 *
 * 0; 0 2 0 4 1 3 0 0
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
 * 4; 1 30 0 6 0 2 1 3
 * 출력
 * 0; 0 2 0 4 1 3 0 0
 * ⋇ 입출력 형식을 잘 지켜주세요
 */
public class G {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] strArr = input.split("; ");
        int pointer = Integer.parseInt(strArr[0]); // Starting pointer
        String[] space = strArr[1].split(" ");
        int[] spaceA = new int[space.length];
        for(int i = 0; i < space.length; i++){
            spaceA[i] = Integer.parseInt(space[i]);
        }

        int[] spaceB = new int[space.length];
        int bIndex = 0;
        while(true){ // 유효데이터가 나올 경우 break
            if(bIndex >= 8){
                break;
            }
            spaceB[bIndex++] = spaceA[pointer];

            if(spaceA[pointer] == 1){
                spaceB[bIndex++] = spaceA[pointer + 1];
                break;
            }
            spaceB[bIndex++] = bIndex;
            pointer = spaceA[pointer + 1];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(0).append("; ");
        for(int i = 0; i < spaceB.length; i++){
            sb.append(spaceB[i]);
            if(i != spaceB.length - 1){
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
