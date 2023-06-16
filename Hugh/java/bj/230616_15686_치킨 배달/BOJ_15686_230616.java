package BOJ.Greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class BOJ_15686_230616 {
    static int N, M;
    static ArrayList<Point> person;
    static ArrayList<Point> chicken;
    static int minDis = Integer.MAX_VALUE;
    static boolean[] open;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        person = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (num == 1) person.add(new Point(i, j));
                else if (num == 2) chicken.add(new Point(i, j));
            }
        }

        open = new boolean[chicken.size()];

        dfs(0, 0);
        bw.write(minDis + "\n");
        bw.flush();

        bw.close();
        br.close();
    }

    public static void dfs(int start, int cnt) {
        if (cnt == M) {
            int res = 0;

            for (int i = 0; i < person.size(); i++) {
                int temp = Integer.MAX_VALUE;

                // 어떤 집과 치킨집 중 open한 치킨집의 모든 거리를 비교한다.
                // 그 중, 최소 거리를 구한다.
                for (int j = 0; j < chicken.size(); j++) {
                    if (open[j]) {
                        int distance = Math.abs(person.get(i).x - chicken.get(j).x)
                                + Math.abs(person.get(i).y - chicken.get(j).y);

                        temp = Math.min(temp, distance);
                    }
                }
                res += temp;
            }
            minDis = Math.min(minDis, res);
            return;
        }

        // 백트래킹
        for (int i = start; i < chicken.size(); i++) {
            open[i] = true;
            dfs(i + 1, cnt + 1);
            open[i] = false;
        }
    }
}
