package inflearnAlgorithm.string;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * 01-04. 단어 뒤집기
 * N개의 단어가 주어지면 각 단어를 뒤집어 출력
 * 입력
 * 3
 * good
 * Time
 * Big
 * 출력
 * doog
 * emiT
 * giB
 */
public class String0104 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }
        for (String x : solution(n, str)) {
            System.out.println(x);
        }

    }

    public static ArrayList<String> solution(int n, String[] str){
        ArrayList<String> answer = new ArrayList<>();
        for (String x : str) {
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }
        return answer;
    }
}
