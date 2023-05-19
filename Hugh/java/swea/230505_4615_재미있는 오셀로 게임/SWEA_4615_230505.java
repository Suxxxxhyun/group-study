package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_4615_230505 {
    static int T, N, M;
    static int[][] direction = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    static int[][] arr;

    static void init() {
        arr = new int[N][N];
        arr[N / 2][N / 2] = 2;
        arr[N / 2][(N / 2) - 1] = 1;
        arr[(N / 2) - 1][N / 2] = 1;
        arr[(N / 2) - 1][(N / 2) - 1] = 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // 가운데 배치하고 시작
            init();

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken()) - 1;
                int y = Integer.parseInt(st.nextToken()) - 1;
                int idxBW = Integer.parseInt(st.nextToken());
                arr[x][y] = idxBW;

                for (int k = 0; k < 8; k++) {
                    int nx = x + direction[k][0];
                    int ny = y + direction[k][1];

                    while (true) {
                        if (!isRange(nx, ny) || arr[nx][ny] == 0) {
                            break;
                        }
                        if (arr[nx][ny] != arr[x][y]) {
                            nx += direction[k][0];
                            ny += direction[k][1];
                        } else {
                            break;
                        }

                        if (isRange(nx, ny) && arr[nx][ny] == arr[x][y]) {
                            while (x != nx || y != ny) {
                                arr[nx][ny] = arr[x][y];
                                nx -= direction[k][0];
                                ny -= direction[k][1];
                            }
                        }
                    }
                }
            }

            int bCnt = 0, wCnt = 0;
            for (int[] sub : arr) {
                for (int num : sub) {
                    if (num == 1) {
                        bCnt++;
                    } else if (num == 2) {
                        wCnt++;
                    }
                }
            }

            sb.append(String.format("#%d %d %d\n", i, bCnt, wCnt));
        }

        System.out.println(sb);
    }

    static boolean isRange(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < N && ny < N;
    }
}
