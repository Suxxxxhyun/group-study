package baekjun.src.baekjun.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//블로그 https://bcp0109.tistory.com/154참조
//구현 실패
//n과 k의 최댓값이 10만이므로 int가능
//수빈이가 0, 동생은 10만의 위치에 있다고 한다면(혹은 그 반대)
//이때의 경우에 대비하여 0에서 10만까지의 위치의 방문여부를 체크하기 위해 크기가 10만1인 check배열 생성
//bfs로 접근해줄 것인데, bfs의 시간복잡도는 O(N)의 시간복잡도로 2초안에 충분히 문제풀수있음.
public class Main12851 {

    static StringTokenizer st;
    static int n,k,count = 0;
    static int minTime = Integer.MAX_VALUE;
    static int[] check = new int[100001];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if(n == k) {
            sb.append(0).append('\n');
            sb.append(1);
        } else {
            bfs(n);
            sb.append(minTime);
            sb.append('\n');
            sb.append(count);
        }

        System.out.println(sb);
    }

    static void bfs(int n) {
        Queue<Integer> q = new LinkedList<Integer>();

        q.offer(n);
        check[n] = 1;

        while(!q.isEmpty()) {
            int x = q.poll();

            if(minTime < check[x]) {
                return;
            }

            for(int i=0; i<3; i++) {

                int next;

                if(i == 0) {
                    next = x - 1;
                } else if(i == 1) {
                    next = x + 1;
                } else {
                    next = x * 2;
                }

                if(next == k) {
                    count++;
                    minTime = check[x];
                }

                if (next < 0 || next > 100000)
                    continue;

                if(check[next] == 0 || check[next] == check[x] + 1) {
                    q.offer(next);
                    check[next] = check[x] + 1;
                }
            }
        }

    }

}
