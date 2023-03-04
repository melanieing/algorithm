package inflearnAlgorithm.stackQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 05-05. 쇠막대기
 * 쇠막대기와 레이저의 배치를 나타내는 괄호 표현이 주어졌을 때, 잘려진 쇠막대기 조각의 총 개수를 구하는 프로그램
 * 입력
 * ()(((()())(())()))(())
 * 출력
 * 17
 */
public class StackQueue0505 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        System.out.println(solution(s));
    }
    public static int solution(String str){
        int cnt = 0;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') stack.push('('); // 여는 괄호일 때는 스택에 넣기
            else { // 닫는 괄호일 때는
                stack.pop(); // 스택에서 하나 뽑기
                if (str.charAt(i - 1) == '(') cnt += stack.size(); // 그게 여는 괄호일 경우 스택 크기를 더하기
                else cnt++; // 그게 닫는 괄호면 1만 더하기
            }
        }
        return cnt;
    }
}
