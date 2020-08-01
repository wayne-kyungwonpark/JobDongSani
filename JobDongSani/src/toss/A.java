package toss;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1과 2로 구성된 문자열의 유효성을 판별해주십시오.
 *
 *
 *
 * 규칙
 *
 *
 * 문자열은 1 과 2 로만 구성된다.
 *
 * 1의 뒤는 항상 2 가 존재해﻿야만 한다.
 *
 * 2의 뒤는 1 혹은 2 가 존재할 수 있다.
 *
 *
 * 위의 규칙을 모두 준수하는 문자열이면 true 그렇지 않으면 false를 출력하는 코드를 구현해주십시오.
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
 * 11
 * 출력
 * false
 * 예시 2
 * 입력
 * 12
 * 출력
 * true
 * 예시 3
 * 입력
 * 121
 * 출력
 * false
 * 예시 4
 * 입력
 * 122
 * 출력
 * true
 * ⋇ 입출력 형식을 잘 지켜주세요
 */
public class A {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] chArr = input.toCharArray();
        char prev = chArr[0];
        boolean follow = true;

        for(int i = 1; i < chArr.length; i++){
            if(prev == '1' && chArr[i] == '1'){ // 이전 문자열이 '1'인데 다음 문자열이 '1'인 경우
                follow = false;
                break;
            }
            prev = chArr[i];
        }

        if(prev == '1'){ // 문자열이 '1' 로 끝나는 경우
            follow = false;
        }

        if(follow){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
