package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    09:37~12:54

    *구현*
    (배열 돌리기)

    - N M 짝수
    - 배열 원소 1 <= Aij <= 1억

    매번 배열 크기 갱신하며 진행

    1차 시도 - IndexOutOfBounds
    2차 시도 - 정답
 */
public class BOJ_16935_230814 {
    static int n,m;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) { // R 만큼 실행
            int func = Integer.parseInt(st.nextToken());

            if (func == 1) func_1();
            else if (func == 2) func_2();
            else if (func == 3) func_3();
            else if (func == 4) func_4();
            else if (func == 5) func_5();
            else if (func == 6) func_6();
        }

        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    static void func_1() {
        int R = map.length;
        int C = map[0].length;
        int[][] tmp = new int[R][C]; // 복사할 배열

        for (int i = R-1; i >= 1; i--) {
            for (int j = 1; j < C; j++) {
                tmp[((R-1)-i)+1][j] = map[i][j];
            }
        }

        map = new int[R][C];
        // 복사한 배열 원본으로 대체
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                map[i][j] = tmp[i][j];
            }
        }
    }
    static void func_2() {
        int R = map.length;
        int C = map[0].length;
        int[][] tmp = new int[R][C]; // 복사할 배열

        for (int i = 1; i < R; i++) {
            for (int j = (C-1); j >= 1; j--) {
                tmp[i][((C-1)-j)+1] = map[i][j];
            }
        }

        map = new int[R][C];
        // 복사한 배열 원본으로 대체
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                map[i][j] = tmp[i][j];
            }
        }

    }
    static void func_3() {
        int R = map.length;
        int C = map[0].length;

        int[][] tmp = new int[C][R]; // 복사할 배열

        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                tmp[j][R-i] = map[i][j];
            }
        }

        map = new int[C][R];
        // 복사한 배열 원본으로 대체
        for (int i = 1; i < C; i++) {
            for (int j = 1; j < R; j++) {
                map[i][j] = tmp[i][j];
            }
        }

    }
    static void func_4() {
        int R = map.length;
        int C = map[0].length;
        int[][] tmp = new int[C][R]; // 복사할 배열

        for (int i = 1; i < R; i++) {
            for (int j = C-1; j >= 1; j--) {
                tmp[C-j][i] = map[i][j];
            }
        }

        map = new int[C][R];
        // 복사한 배열 원본으로 대체
        for (int i = 1; i < C; i++) {
            for (int j = 1; j < R; j++) {
                map[i][j] = tmp[i][j];
            }
        }
    }

    static void func_5() {
        int R = map.length;
        int C = map[0].length;
        int[][] arr1 = new int[(R/2)+1][(C/2)+1];
        int[][] arr2 = new int[(R/2)+1][(C/2)+1];
        int[][] arr3 = new int[(R/2)+1][(C/2)+1];
        int[][] arr4 = new int[(R/2)+1][(C/2)+1];


        for (int i = 1; i <= R/2; i++) { // 부분 배열 1
            for (int j = 1; j <= C/2; j++) {
                arr1[i][j] = map[i][j];
            }
        }

        for (int i = 1; i <= R/2; i++) { // 부분 배열 2
            for (int j = (C/2)+1; j < C; j++) {
                arr2[i][j-(C/2)] = map[i][j];
            }
        }

        for (int i = (R/2)+1; i < R; i++) { // 부분 배열 3
            for (int j = (C/2)+1; j < C; j++) {
                arr3[i-(R/2)][j-(C/2)] = map[i][j];
            }
        }

        for (int i = (R/2)+1; i < R; i++) { // 부분 배열 4
            for (int j = 1; j <= C/2; j++) {
                arr4[i-(R/2)][j] = map[i][j];
            }
        }

        map = new int[R][C];
        // 원본 배열에 복사
        for (int i = 1; i <= R/2; i++) {
            for (int j = 1; j <= C/2; j++) {
                map[i][j+(C/2)] = arr1[i][j];
            }
        }

        for (int i = 1; i <= R/2; i++) {
            for (int j = 1; j <= C/2; j++) {
                map[i+(R/2)][j+(C/2)] = arr2[i][j];
            }
        }

        for (int i = 1; i <= R/2; i++) {
            for (int j = 1; j <= C/2; j++) {
                map[i+(R/2)][j] = arr3[i][j];
            }
        }

        for (int i = 1; i <= R/2; i++) {
            for (int j = 1; j <= C/2; j++) {
                map[i][j] = arr4[i][j];
            }
        }
    }

    static void func_6() {
        int R = map.length;
        int C = map[0].length;
        int[][] arr1 = new int[(R/2)+1][(C/2)+1];
        int[][] arr2 = new int[(R/2)+1][(C/2)+1];
        int[][] arr3 = new int[(R/2)+1][(C/2)+1];
        int[][] arr4 = new int[(R/2)+1][(C/2)+1];


        for (int i = 1; i <= R/2; i++) { // 부분 배열 1
            for (int j = 1; j <= C/2; j++) {
                arr1[i][j] = map[i][j];
            }
        }

        for (int i = 1; i <= R/2; i++) { // 부분 배열 2
            for (int j = (C/2)+1; j < C; j++) {
                arr2[i][j-(C/2)] = map[i][j];
            }
        }

        for (int i = (R/2)+1; i < R; i++) { // 부분 배열 3
            for (int j = (C/2)+1; j < C; j++) {
                arr3[i-(R/2)][j-(C/2)] = map[i][j];
            }
        }

        for (int i = (R/2)+1; i < R; i++) { // 부분 배열 4
            for (int j = 1; j <= C/2; j++) {
                arr4[i-(R/2)][j] = map[i][j];
            }
        }

        map = new int[R][C];
        // 원본 배열에 복사
        for (int i = 1; i <= R/2; i++) {
            for (int j = 1; j <= C/2; j++) {
                map[i+(R/2)][j] = arr1[i][j];
            }
        }

        for (int i = 1; i <= R/2; i++) {
            for (int j = 1; j <= C/2; j++) {
                map[i][j] = arr2[i][j];
            }
        }

        for (int i = 1; i <= R/2; i++) {
            for (int j = 1; j <= C/2; j++) {
                map[i][j+(C/2)] = arr3[i][j];
            }
        }

        for (int i = 1; i <= R/2; i++) {
            for (int j = 1; j <= C/2; j++) {
                map[i+(R/2)][j+(C/2)] = arr4[i][j];
            }
        }
    }
}
