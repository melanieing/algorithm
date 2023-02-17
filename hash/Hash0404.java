package inflearnAlgorithm.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 04-04. 모든 아나그램 찾기
 * S문자열에서 T문자열과 아나그램이 되는 S의 부분문자열의 개수를 구하는 프로그램
 * 입력
 * bacaAacba
 * abc
 * 출력
 * 3
 */
public class Hash0404 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String k = sc.next();

        System.out.println(solution(s, k));
    }

    public static int solution(String s, String k) {
        int answer = 0;
        int totalLength = s.length();
        int windowLength = k.length();

        HashMap<Character, Integer> defaultMap = new HashMap<>(); // 기준이 되는 k를 담을 map
        HashMap<Character, Integer> map = new HashMap<>(); // 윈도우가 될 map

        for(char c : k.toCharArray()) {  // k를 (알파벳, 개수)로 담기
            defaultMap.put(c, defaultMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < windowLength - 1; i++) { // s를 (알파벳, 개수)로 담기
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        int lt = 0;
        for (int rt = windowLength - 1; rt < totalLength; rt++) { // 슬라이딩 윈도우 움직이기
            map.put(s.charAt(rt), map.getOrDefault(s.charAt(rt), 0) + 1);
            if (defaultMap.equals(map)) { // 아나그램이라면 하나 올리기
                answer++;
            }
            map.put(s.charAt(lt), map.get(s.charAt(lt)) - 1); // 빠지는 lt값은 -1
            if (map.get(s.charAt(lt)) <= 0) { // 0이라면 종류에서 빠지도록 삭제하기
                map.remove(s.charAt(lt));
            }
            lt++; // 우측으로 이동
        }

        return answer;
    }
}
