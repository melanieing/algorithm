package inflearnAlgorithm.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 10-04. 가장 높은 탑 쌓기
 * 밑면이 정사각형인 직육면체 벽돌들(최대 100개)을 한 개씩 아래에서 위로 쌓기
 * 가장 높이 쌓을 수 있는 탑의 높이를 출력
 * 벽돌 회전시킬 수 없음
 * 밑면의 넓이가 같은 벽돌, 무게가 같은 벽돌은 없음, 벽돌들의 높이는 같을 수도 있음
 * 밑면이 좁은 벽돌 위에 밑면이 넓은 벽돌을 놓을 수는 없음
 * 무게가 무거운 벽돌을 무게가 가벼운 벽돌 위에 놓을 수 없음
 * 입력 (입력될 벽돌의 수 / 밑면의 넓이, 높이, 무게)
 * 5
 * 25 3 4
 * 4 4 6
 * 9 2 3
 * 16 2 5
 * 1 5 2
 * 출력
 * 10
 */
class Brick implements Comparable<Brick> {

    public int s, h, w; // 밑면 넓이, 높이, 무게

    Brick(int s, int h, int w) {
        this.s = s;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Brick o) {
        return o.s - this.s; // 밑면 넓이 내림차순 정렬
    }
}
public class Dp1004 {

    static int[] dy;

    public static void main(String[] args) {
        Dp1004 main = new Dp1004();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 원소 개수
        ArrayList<Brick> arr = new ArrayList<>();
        dy = new int[n];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arr.add(new Brick(a, b, c));
        }

        System.out.println(main.solution(arr));

    }

    public int solution(ArrayList<Brick> arr) {

        Collections.sort(arr); // 일단 정렬하기 (내림차순)
        dy[0] = arr.get(0).h; // 첫 번째 높이 저장
        int answer = dy[0]; // 서로 아무것도 못 올리는 경우가 있을 수도 있으니까 초기화

        for (int i = 1; i < arr.size(); i++) {
            int maxH = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr.get(j).w > arr.get(i).w && dy[j] > maxH) {
                    maxH = dy[j];
                }
            }
            dy[i] = maxH + arr.get(i).h;
            answer = Math.max(answer , dy[i]);
        }

        return answer;

    }
}
