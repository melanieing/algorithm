package inflearnAlgorithm.string;

import java.util.Scanner;
/**
 * 01-01. 문자 찾기
 * 한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내기
 * 입력
 * Computercooler
 * c
 * 출력
 * 2
 */
public class String0101 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        System.out.print(solution(str, c));
    }

    public static int solution(String str, char t) {
        int answer = 0;

        // 대소문자 상관없게 만들기
        str = str.toUpperCase();
        t = Character.toUpperCase(t);
        // char[]로 만들면서 향상된 for문 사용
        for (char c : str.toCharArray()) {
            if (c == t) { answer++; }
        }

        return answer;
    }
}
