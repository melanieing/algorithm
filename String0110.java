package inflearnAlgorithm;

import java.util.Scanner;
/**
 * 01-10. 가장 짧은 문자거리
 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력
 * 입력
 * teachermode e
 * 출력
 * 1 0 1 2 1 0 1 2 2 1 0
 */
public class String0110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        for (int x : solution(str, c)){
            System.out.print(x + " ");
        }
    }

    public static int[] solution(String s, char t){
        int[] answer = new int[s.length()];
        int p = 1000;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == t){
                p = 0;
            } else{
                p++;
            }
            answer[i] = p;
        }
        p = 1000;
        for(int i = s.length()-1; i >= 0; i--){
            if (s.charAt(i) == t) p = 0;
            else {
                p++;
                answer[i] = Math.min(answer[i], p);
            }
        }
        return answer;
    }
}
