package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1940_230428 {
    static int T;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int speed = 0;
            int dis = 0;

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int commend = Integer.parseInt(st.nextToken());
                // 0일 경우
                if (commend == 0) {
                    dis += speed;
                    continue;
                }

                int speedCom = Integer.parseInt(st.nextToken());

                if (commend == 1) {
                    speed += speedCom;
                    dis += speed;
                } else if (commend == 2) {
                    speed -= speedCom;
                    // 0밑으로는 내려가지 않음
                    if (speed < 0) {
                        speed = 0;
                    }
                    dis += speed;
                }
            }
            sb.append(String.format("#%d %d\n", i, dis));
        }

        System.out.println(sb);
    }
}
