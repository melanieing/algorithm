package inflearnAlgorithm.hash;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 04-01. 학급 회장(해쉬)
 * 어떤 기호의 후보가 학급회장이 되었는지 출력
 * 입력
 * 15
 * BACBACCACCBDEDE
 * 출력
 * C
 */
public class Hash0401 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();

        System.out.println(solution1(n, s));
        System.out.println(solution2(n, s));
    }

    public static String solution1(int n, String s) {
        String[] sarr = s.split("");
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>(); // (후보기호, 횟수)
        for (int i = 0; i < n; i++) {
            map.put(sarr[i], map.getOrDefault(sarr[i], 0) + 1);
        }

        int maxVal = Collections.max(map.values()); // 최대횟수 구하기

        for (String k : map.keySet()) {
            if (map.get(k) == maxVal) { // 최대 횟수인 기호 뽑기
                answer = k;
            }
        }
        return answer;
    }

    public static char solution2(int n, String s){
        char answer = ' ';

        HashMap<Character, Integer> map = new HashMap<>(); // 후보기호를 char로 저장
        for (char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        return answer;
    }
}
