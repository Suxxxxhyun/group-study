package BOJ.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    09:10~
    N개의 물병, K개의 물병을 옮김
    적절히 분배해 K개를 넘지 않는 비어있지 않은 물병

    1 1 1
      2 (1 + 1)
      1

    1 1 1 1 1 1 1 1 1 1 1 1 1
      2   2   2   2   2   2 1
          4       4       4 1
                  8       4 1

    1 1 1 1 1 1 1 1 1 1 1 1 1 1
      2   2   2   2   2   2   2
          4       4       4   2
                  8       4   2

    1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
      2   2   2   2   2   2   2 1
          4       4       4   2 1

    1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
      2   2   2   2   2   2   2   2
          4       4       4       4
                  8               8
                                  16
 */
public class BOJ_1052_230718 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 물병 구매
        int buy = 0;
        while (true) {
            int count = 0;
            int copyN = N;

            // 남는 물병의 수 구하기
            while (copyN != 0) {
                if (copyN % 2 == 1) {
                    count += 1;
                }
                // 짝수 하나로 합치기
                copyN /= 2;
            }
            if (count <= K) {
                break;
            }
            N+=1;
            buy++;
        }


        System.out.println(buy);

    }
}
