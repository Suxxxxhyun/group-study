package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SWEA_1216_230504 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10; i++) {
            N = Integer.parseInt(br.readLine());
            char[][] arr = new char[101][101];

            for (int j = 0; j < 100; j++) {
                String str = br.readLine();
                for (int k = 0; k < 100; k++) {
                    arr[j][k] = str.charAt(k);
                }
            }

            sb.append(String.format("#%d %d\n", i, reverseCnt(arr)));
        }
        System.out.println(sb);
    }

    // 회문 찾기
    static int reverseCnt(char[][] arr) {
        ArrayList<String> list = new ArrayList<>();

        for (int j = 0; j < 100; j++) {
            for (int k = 0; k < 100; k++) {
                String palinX = "";
                String palinY = "";
                for (int z = k; z < 100; z++) {
                    palinX += arr[j][z];
                    palinY += arr[z][j];

                    if (palinX.length() >= 3 && palinY.length() >= 3) {
                        StringBuilder sb1 = new StringBuilder(palinX);
                        StringBuilder sb2 = new StringBuilder(palinY);
                        if (palinX.equals(sb1.reverse().toString())) {
                            list.add(palinX);
                        }
                        if (palinY.equals(sb2.reverse().toString())) {
                            list.add(palinY);
                        }
                    }
                }
            }
        }

        return maxPalin(list);
    }

    // 가장 긴 회문 찾기
    static int maxPalin(ArrayList<String> list) {
        int max = Integer.MIN_VALUE;
        for (String str : list) {
            max = Math.max(max, str.length());
        }
        return max;
    }
}
