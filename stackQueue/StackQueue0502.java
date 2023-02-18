package inflearnAlgorithm.stackQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 05-02. 괄호문자제거
 * 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력
 * 입력
 * (A(BC)D)EF(G(H)(IJ)K)LM(N)
 * 출력
 * EFLM
 */
public class StackQueue0502 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(solution(s));
    }

    public static String solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == ')') { // 닫는 괄호를 만나면
                while (true) { // 일단 꺼내기
                    stack.pop();
                    if (stack.peek() == '(') { // 여는 괄호를 만나면 뽑고 반복문 나오기
                        stack.pop();
                        break;
                    }
                }
            } else { // 기본적으로 스택에 넣기
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) { // 스택에 남아있는 값 이어 붙이기
            sb.append(c);
        }

        return sb.toString();
    }
}
