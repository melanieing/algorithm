package inflearnAlgorithm.stackQueue;

import java.util.Scanner;
import java.util.Stack;
/**
 * 05-01. 올바른 괄호
 * 괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력
 * 입력
 * (()(()))(()
 * 출력
 * NO
 */
public class StackQueue0501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(solution(s));
    }

    public static String solution(String s) {
        String answer = "YES";

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') { // 여는 괄호를 만나면 스택에 넣기
                stack.push(c);
            } else if (c == ')') { // 닫는 괄호를 만나면 스택 맨위의 값 꺼내기
                if (stack.isEmpty()) { // 꺼낼 값이 없으면 짝이 안 맞는다는 것!
                    return "NO";
                }
                stack.pop();
            }
        }

        if (!stack.isEmpty()) { // 모두 진행했는데도 스택이 비지 않았다면 짝이 안 맞는다는 것
            answer = "NO";
        }

        return answer;
    }
}
