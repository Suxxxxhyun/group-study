package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1873_230505 {
    static int T, H, W, N;
    static String[][] arr;
    static char[] commends;
    static int posH, posW, boomH, boomW;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            arr = new String[H][W];

            // 배열로 초기화 하고 탱크 위치 저장
            for (int j = 0; j < H; j++) {
                String str = br.readLine();
                for (int k = 0; k < str.length(); k++) {
                    arr[j][k] = String.valueOf(str.charAt(k));
                    if (str.charAt(k) == '^' || str.charAt(k) == 'v' || str.charAt(k) == '<' || str.charAt(k) == '>') {
                        posH = j;
                        posW = k;
                    }
                }
            }

            N = Integer.parseInt(br.readLine());
            commends = br.readLine().toCharArray();

            // 탱크 이동 및 명령어 수행
            commendProcess();

            // 출력
            sb.append(String.format("#%d ", i));
            for (int j = 0; j < H; j++) {
                for (int k = 0; k < W; k++) {
                    sb.append(arr[j][k]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    static void commendProcess() {
        for (int j = 0; j < N; j++) {
            switch (commends[j]) {
                case 'U':
                    arr[posH][posW] = "^";
                    if (isRange(posH - 1, posW) && arr[posH - 1][posW].equals(".")) {
                        arr[posH - 1][posW] = arr[posH][posW];
                        arr[posH][posW] = ".";

                        posH -= 1;
                    }
                    break;
                case 'D':
                    arr[posH][posW] = "v";
                    if (isRange(posH + 1, posW) && arr[posH + 1][posW].equals(".")) {
                        arr[posH + 1][posW] = arr[posH][posW];
                        arr[posH][posW] = ".";

                        posH += 1;
                    }
                    break;
                case 'L':
                    arr[posH][posW] = "<";
                    if (isRange(posH, posW - 1) && arr[posH][posW - 1].equals(".")) {
                        arr[posH][posW - 1] = arr[posH][posW];
                        arr[posH][posW] = ".";

                        posW -= 1;
                    }
                    break;
                case 'R':
                    arr[posH][posW] = ">";
                    if (isRange(posH, posW + 1) && arr[posH][posW + 1].equals(".")) {
                        arr[posH][posW + 1] = arr[posH][posW];
                        arr[posH][posW] = ".";

                        posW += 1;
                    }
                    break;
                case 'S':
                    // 대포 이동 및 벽 제거
                    blockBreak();
                    break;
            }
        }
    }

    static void blockBreak() {
        switch (arr[posH][posW]) {
            case "^":
                boomH = posH;
                boomW = posW;
                while (isRange(boomH - 1, boomW)) {
                    boomH -= 1;
                    if (arr[boomH][boomW].equals("#")) {
                        break;
                    } else if (arr[boomH][boomW].equals("*")) {
                        arr[boomH][boomW] = ".";
                        break;
                    }
                }
                break;
            case "v":
                boomH = posH;
                boomW = posW;
                while (isRange(boomH + 1, boomW)) {
                    boomH += 1;
                    if (arr[boomH][boomW].equals("#")) {
                        break;
                    } else if (arr[boomH][boomW].equals("*")) {
                        arr[boomH][boomW] = ".";
                        break;
                    }
                }
                break;
            case "<":
                boomH = posH;
                boomW = posW;
                while (isRange(boomH, boomW - 1)) {
                    boomW -= 1;
                    if (arr[boomH][boomW].equals("#")) {
                        break;
                    } else if (arr[boomH][boomW].equals("*")) {
                        arr[boomH][boomW] = ".";
                        break;
                    }
                }
                break;
            case ">":
                boomH = posH;
                boomW = posW;
                while (isRange(boomH, boomW + 1)) {
                    boomW += 1;
                    if (arr[boomH][boomW].equals("#")) {
                        break;
                    } else if (arr[boomH][boomW].equals("*")) {
                        arr[boomH][boomW] = ".";
                        break;
                    }
                }
                break;
        }
    }

    // 범위 내에 있는지 확인
    static boolean isRange(int posH, int posW) {
        return posH >= 0 && posW >= 0 && posH < H && posW < W;
    }
}
