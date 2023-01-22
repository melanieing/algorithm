package inflearnAlgorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 01-07. 회문 문자열
 * 문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력
 * 입력
 * gooG
 * 출력
 * YES
 */
public class String0107 {
    public static void main(String[] args) throws IOException {
        String0107 s = new String0107();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(s.solution1(str));
        System.out.println(s.solution2(str));

    }

    public String solution1(String str) {
        String answer = "YES";
        str = str.toUpperCase(); // 모두 대문자로 바꾸기
        int len = str.length();
        for (int i = 0; i < len/2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                answer = "NO"; // 대칭에 있는 값이 다르면 NO
                break;
            }
        }
        return answer;
    }

    public String solution2(String str) {
        String answer = "NO";
        String tmp = new StringBuilder(str).reverse().toString(); // 거꾸로 뒤집기
        if (str.equalsIgnoreCase(tmp)) answer = "YES";

        return answer;
    }
}
