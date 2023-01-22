package inflearnAlgorithm;

import java.util.Scanner;
/**
 * 01-11. 문자열 압축
 * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
 * 문자 바로 오른쪽에 반복 횟수를 표기하는 방법으로 문자열을 압축
 * 입력
 * KKHSSSSSSSE
 * 출력
 * K2HS7E
 */
public class String0111 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }

    public static String solution(String s){
        StringBuilder answer = new StringBuilder();
        s = s + " ";
        int cnt = 1;
        for (int i = 0; i < s.length() - 1; i++){
            if (s.charAt(i) == s.charAt(i + 1)) cnt++;
            else {
                answer.append(s.charAt(i));
                if (cnt > 1) answer.append(cnt);
                cnt = 1;
            }
        }
        return answer.toString();
    }
}
