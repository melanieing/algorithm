package inflearnAlgorithm.string;

import java.util.Scanner;
/**
 * 01-06. 중복문자제거
 * 소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력, 중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지
 * 입력
 * ksekkset
 * 출력
 * kset
 */
public class String0106 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(solution(str));
    }

    public static String solution(String str){
        String answer = "";
        for (int i = 0; i < str.length(); i++){
            // System.out.println(str.charAt(i) + " " + i + " " + str.indexOf(str.charAt(i)));
            if (str.indexOf(str.charAt(i)) == i) answer += str.charAt(i);
        }
        return answer;
    }
}

