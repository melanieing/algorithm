package inflearnAlgorithm;

import java.util.Scanner;
/**
 * 01-12. 암호
 * 1. “#*****#”를 일곱자리의 이진수로 바꾸기, #은 이진수의 1로, *이진수의 0으로 변환
 * 2. 바뀐 2진수를 10진수화
 * 3. 아스키 번호가 65문자로 변환
 * 입력
 * 4
 * #****###**#####**#####**##**
 * 출력
 * COOL
 */
public class String0112 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(solution(n, str));
    }

    public static String solution(int n, String s){
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++){
            // 1. 이진수로 변환
            String tmp = s.substring(0, 7).replace('#', '1').replace('*', '0');
            // 2. 10진수로 변환
            int num = Integer.parseInt(tmp, 2);
            // 3. 아스키코드 문자로 변환
            answer.append((char) num);
            // 다음 줄로 이동
            s = s.substring(7);
        }
        return answer.toString();
    }
}
