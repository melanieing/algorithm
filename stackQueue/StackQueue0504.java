package inflearnAlgorithm.stackQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 05-04. 후위식 연산(postfix)
 * 후위식 연산(postfix)
 * 입력
 * 352+*9-
 * 출력
 * 12
 */
public class StackQueue0504 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) { // 숫자면
                stack.push(c-48);
            } else { // 숫자가 아니면 연산자
                int rt = stack.pop();
                int lt = stack.pop();
                if (c == '+') {
                    stack.push(lt + rt);
                } else if (c == '-') {
                    stack.push(lt - rt);
                } else if (c == '*') {
                    stack.push(lt * rt);
                } else if (c == '/') {
                    stack.push(lt / rt);
                }
            }
        }

        return stack.get(0);
    }
}
