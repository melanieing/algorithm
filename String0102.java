package inflearnAlgorithm;

import java.util.Scanner;
/**
 * 01-02. 대소문자 변환
 * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력
 * 입력
 * StuDY
 * 출력
 * sTUdy
 */
public class String0102 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(solution1(str));
        // System.out.print(solution2(str));
    }

    /* 메서드 사용 */
    public static String solution1(String str) {
        StringBuilder answer = new StringBuilder();
        for (char x : str.toCharArray()) {
            if (Character.isLowerCase(x)) answer.append(Character.toUpperCase(x)); // 소문자면 대문자로
            else answer.append(Character.toLowerCase(x)); // 대문자면 소문자로

        }
        return answer.toString();
    }

    /* 아스키코드 사용 */
    public static String solution2(String str){
        StringBuilder answer= new StringBuilder();
        for (char x : str.toCharArray()) {
            if (x >= 97 && x <= 122) answer.append((char) (x - 32)); // 소문자면 대문자로
            else answer.append((char) (x + 32)); // 대문자면 소문자로
        }
        return answer.toString();
    }
}
