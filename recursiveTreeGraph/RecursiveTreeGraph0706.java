package inflearnAlgorithm.recursiveTreeGraph;

/**
 * 07-06. 부분집합 구하기(깊이우선탐색, DFS)
 * 첫 번째 줄부터 각 줄에 하나씩 부분집합을 순서대로 출력 (공집합은 출력X)
 * 상태트리 만들기
 * 입력
 * 3
 * 출력
 * 1 2 3
 * 1 2
 * 1 3
 * 1
 * 2 3
 * 2
 * 3
 */
public class RecursiveTreeGraph0706 {

    static int n;
    static int[] ch; // 체크배열
    public void DFS(int L){
        if (L == n + 1) { // 다 체크하면
            StringBuilder tmp = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    tmp.append(i).append(" ");
                }
            }
            if (tmp.length() > 0) { // 공집합이 아닐 경우
                System.out.println(tmp);
            }
        } else { // 아직 체크할 게 남았다면
            ch[L]=1;
            DFS(L+1);
            ch[L]=0;
            DFS(L+1);
        }
    }

    public static void main(String[] args){
        RecursiveTreeGraph0706 T = new RecursiveTreeGraph0706();
        n = 4;
        ch = new int[n + 1];
        T.DFS(1);
    }
}
