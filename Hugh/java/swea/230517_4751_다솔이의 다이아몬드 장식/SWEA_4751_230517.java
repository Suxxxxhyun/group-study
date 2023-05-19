package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_4751_230517 {
    static int T;
    static char[][] diamond;
    static int[][] idxArr = new int[][]{{-2,0},{-1,1},{0,2},{1,1},{2,0},{1,-1},{0,-2},{-1,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            String str = br.readLine();
            if (str.length() == 1) {
                diamond = new char[5][5];
            } else {
                diamond = new char[5][(5 * str.length()) - (str.length() - 1)];
            }

            for (int x = 0; x < diamond.length; x++) {
                for (int y = 0; y < diamond[x].length; y++) {
                    if (diamond[x][y] == '\0') diamond[x][y] = '.';
                    if (x == 2) {
                        int idx = 0;
                        for (int z = 2; z < diamond[x].length; z += 4) {
                            diamond[x][z] = str.charAt(idx++);
                            for (int a = 0; a < 8; a++) {
                                int nx = x + idxArr[a][0];
                                int ny = z + idxArr[a][1];
                                diamond[nx][ny] = '#';
                            }
                        }
                    }
                }
            }

            for (int j = 0; j < diamond.length; j++) {
                for (int k = 0; k < diamond[j].length; k++) {
                    sb.append(diamond[j][k]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
