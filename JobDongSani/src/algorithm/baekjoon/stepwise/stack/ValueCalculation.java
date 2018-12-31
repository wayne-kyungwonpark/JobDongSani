package algorithm.baekjoon.stepwise.stack;

import java.io.*;
import java.util.LinkedList;

/**
 * https://github.com/ParkKyungWon/JobDongSani
 *
 * Baekjoon > 문제 > 단계별로 풀어보기 > 스택 사용하기(기초) > 괄호의 값
 * 1. 스택에 괄호를 쌓는다.
 * 2. ")" 나 "]"가 나왔을 경우 스택에 쌓인 괄호들을 숫자로 변환한다.
 * 3. 변환하는 과정에서 괄호가 맞지 않는 경우 (ex. (], [), ...) isPossible을 false로 지정한다.
 * 4. 변환하는 과정에서 숫자가 있을 경우 이를 더해준다. (num)
 * 5. 최종적으로 숫자가 없을 경우 () -> 2, [] -> 3, 으로 변환
 * 6. 숫자가 있을 경우 더해진 num 값에 2나 3을 곱한다.
 * 7. 스택에 최종적으로 숫자만 남아야 한다. 숫자가 아닌 값 (괄호들) 이 있을 경우 isPossible을 false로 지정한다.
 * 8. 스택에 남은 값을 모두 더해주면서 (value) stack을 비운다.
 * 9. isPossible이 true이면서 stack이 비었을 경우에만 value값을 출력하고, 아닐 경우 0을 출력한다.
 */
public class ValueCalculation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = null;
        LinkedList<String> stack = new LinkedList<String>();
        boolean isPossible = true;
        int value = 0;
        while ((str = br.readLine()) != null) {
            String[] strArr = str.split("");
            // String을 ""로 split 했을 경우, 맨 끝은 빈 값("") 이 나오므로 주의
            // ex) ()] -> {"(", ")", "]", ""}
            // 그래서 i의 범위를 원래 str의 길이로 지정
            for (int i = 0; i < str.length(); i++) {
                if (strArr[i].equals(")")) {
                    if (stack.isEmpty()) {
                        isPossible = false;
                        break;
                    } else {
                        int num = 0;
                        while (!stack.isEmpty() && !stack.peek().equals("(")) {
                            if (stack.peek().equals("[")) {
                                isPossible = false;
                                stack.pop();
                                break;
                            } else {
                                num += Integer.parseInt(stack.pop());
                            }
                        }
                        if (stack.isEmpty()) {
                            isPossible = false;
                            break;
                        } else if (num == 0) {
                            stack.pop();
                            stack.push("2");
                        } else {
                            stack.pop();
                            stack.push(String.valueOf(num * 2));
                        }
                    }
                } else if (strArr[i].equals("]")) {
                    if (stack.isEmpty()) {
                        isPossible = false;
                        break;
                    } else {
                        int num = 0;
                        while (!stack.isEmpty() && !stack.peek().equals("[")) {
                            if (stack.peek().equals("(")) {
                                isPossible = false;
                                stack.pop();
                                break;
                            } else {
                                num += Integer.parseInt(stack.pop());
                            }
                        }
                        if (stack.isEmpty()) {
                            isPossible = false;
                            break;
                        } else if (num == 0) {
                            stack.pop();
                            stack.push("3");
                        } else {
                            stack.pop();
                            stack.push(String.valueOf(num * 3));
                        }
                    }
                } else {
                    stack.push(strArr[i]);
                }
            }
            break;
        }
        while (!stack.isEmpty() &&
                !(stack.peek().equals("(") || stack.peek().equals("[")
                        || stack.peek().equals(")") || stack.peek().equals("]"))) {
            value += Integer.parseInt(stack.pop());
        }

        if (isPossible && stack.isEmpty()) {
            bw.write(String.valueOf(value));
        } else {
            bw.write("0");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
