package inflearnAlgorithm.hash;

import java.util.*;

/**
 * 04-02. 아나그램(해쉬)
 * Anagram : 두 문자열이 알파벳의 나열 순서를 다르지만 그 구성이 일치
 * 길이가 같은 두 개의 단어가 주어지면 두 단어가 아나그램인지 판별하는 프로그램(대소문자가 구분)
 * 입력
 * AbaAeCe
 * baeeACA
 * 출력
 * YES
 */
public class Hash0402 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();

//        System.out.println(solution1(s1, s2));
        System.out.println(solution2(s1, s2));
    }

    public static String solution1(String s1, String s2) {
        String answer = "YES";
        int length = s1.length();
        String[] sarr1 = s1.split(""); // 첫 번째 문자열 배열화
        String[] sarr2 = s2.split(""); // 두 번째 문자열 배열화

        // 알파벳순대로 정렬하기 위해 트리맵 사용
        TreeMap<String, Integer> map1 = new TreeMap<>();
        TreeMap<String, Integer> map2 = new TreeMap<>();

        for (int i = 0; i < length; i++) { // 알파벳 별로 개수 구해서 넣기
            map1.put(sarr1[i], map1.getOrDefault(sarr1[i], 0) + 1);
            map2.put(sarr2[i], map2.getOrDefault(sarr2[i], 0) + 1);
        }

        for (Map.Entry<String, Integer> entry1 : map1.entrySet()) {
            String key1 = entry1.getKey();
            if (!entry1.getValue().equals(map2.get(key1))) { // 한 알파벳이라도 일치하지 않으면 멈추고 NO 출력
                answer = "NO";
                break;
            }
        }

        return answer;
    }

    public static String solution2(String s1, String s2) {
        String answer = "YES";

        // s1에 있으면 map에 (알파벳, 개수) 넣기
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : s1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        // -1해야 하는데 알파벳이 없거나 개수가 0이면 No
        for (char x : s2.toCharArray()) {
            if (!map.containsKey(x) || map.get(x) == 0) {
                return "NO";
            }
            map.put(x, map.get(x) - 1); // s2에 있으면 하나를 빼기
        }

        return answer;
    }
}
