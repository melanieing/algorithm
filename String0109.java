package inflearnAlgorithm;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * 01-09. 숫자만 추출
 * 문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만들기
 * 입력
 * g0en2T0s8eSoft
 * 출력
 * 208
 */
public class String0109 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(solution(str));
    }

    public static int solution(String s){
        //int answer=0;
        StringBuilder answer= new StringBuilder();
        for(char x : s.toCharArray()){
            //if(x>=48 && x<=57) answer=answer*10+(x-48);
			/*if(Character.isDigit(x)){
				answer=answer*10+ Character.getNumericValue(x);
			}*/
            if (Character.isDigit(x)) answer.append(x);
        }
        return Integer.parseInt(answer.toString());
    }
}
