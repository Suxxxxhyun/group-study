package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/*
    중앙값 찾는 그리디형식으로 진행
 */


// 마을 클래스
class Node {
    int x; // 위치
    int a; // 인원

    public Node(int x, int a) {
        this.x = x;
        this.a = a;
    }
}
public class BOJ_2285_230727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Node> list = new ArrayList<>();

        long sum = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            list.add(new Node(x, a));
            sum += a; // 총 인원 수 구하기
        }

        // 리스트에 들어온 값 마을 위치 기준으로 오름차순 정렬
        Collections.sort(list, (o1, o2) -> o1.x - o2.x);

        long result = 0;
        for (int i = 0; i < n; i++) {
            result += list.get(i).a;
            if (result >= (sum + 1) / 2) { // 중앙값과 같거나 더 크면
                System.out.println(list.get(i).x);
                break;
            }
        }
    }
}
