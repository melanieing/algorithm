package inflearnAlgorithm.string;

import java.util.Scanner;
/**
 * 01-08. 유효한 팰린드롬
 * 문자열이 입력되면 해당 문자열이 팰린드롬이면 "YES", 아니면 “NO"를 출력
 * 입력
 * found7, time: study; Yduts; emit, 7Dnuof
 * 출력
 * YES
 */
public class String0108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.print(solution(str));
    }

    public static String solution(String s){
        String answer = "NO";
        s = s.toUpperCase().replaceAll("[^A-Z]", ""); // 알파벳 남기고 나머지는 제거
        String tmp = new StringBuilder(s).reverse().toString(); // 거꾸로 뒤집기
        if (s.equals(tmp)) answer = "YES";
        return answer;
    }
}
