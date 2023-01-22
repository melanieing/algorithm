package inflearnAlgorithm.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 02-03. 가위 바위 보
 * 두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력
 * 입력
 * 5
 * 2 3 3 1 3
 * 1 1 2 2 3
 * 출력
 * A
 * B
 * A
 * B
 * D
 * 가위(1) + 바위(2) = 바위(2)
 * 가위(1) + 보(3) = 가위(1)
 * 바위(2) + 보(3) = 보(3)
 */
public class Array0203 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        for (String s : solution1(n, a, b)) {
            System.out.println(s);
        }

        for(char x : solution2(n, a, b).toCharArray()) {
            System.out.println(x);
        }
    }

    public static String[] solution1(int n, int[] a, int[] b) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) answer[i] = "D";
            else if (a[i] + b[i] == 3) answer[i] = (a[i] < b[i]) ? "B" : "A";
            else if (a[i] + b[i] == 4) answer[i] = (a[i] < b[i]) ? "A" : "B";
            else if (a[i] + b[i] == 5) answer[i] = (a[i] < b[i]) ? "B" : "A";
        }
        return answer;
    }

    public static String solution2(int n, int[] a, int[] b) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++){
            if (a[i] == b[i]) answer.append("D");
            else if (a[i]==1 && b[i]==3) answer.append("A");
            else if (a[i]==2 && b[i]==1) answer.append("A");
            else if (a[i]==3 && b[i]==2) answer.append("A");
            else answer.append("B");
        }
        return answer.toString();
    }
}
