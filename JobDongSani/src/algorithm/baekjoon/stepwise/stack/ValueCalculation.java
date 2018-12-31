package algorithm.baekjoon.stepwise.stack;

import java.io.*;
import java.util.LinkedList;

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
