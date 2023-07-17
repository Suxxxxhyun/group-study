package BOJ.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    공통된 부분 수열 문제
    LCS
    DP(Memoization) - Bottom-up

    *설계*
      A C A Y K P
    C 0 1 1 1 1 1
    A 1 1 2 2 2 2
    P 1 1 2 2 2 3
    C 1 2 2 2 2 3
    A 1 2 3 3 3 3
    K 1 2 3 3 4 4

    // 같은 문자를 만난경우 (대각선 +1)
    str1.charAt(i) == str2.charAt(j)
    dp[i][j] = dp[i-1][j-1]+1

    // 그 외의 경우 (왼쪽, 위에서 더 큰값으로 갱신)
    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j])
 */
public class BOJ_9251_230717 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int[][] dp = new int[str1.length()+1][str2.length()+1];


        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {

                // 같은 문자
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                // 그 외의 경우
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }

            }
        }

//        for (int i = 1; i <= str1.length(); i++) {
//            for (int j = 1; j <= str2.length(); j++) {
//                System.out.print(dp[j][i] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(dp[str1.length()][str2.length()]);

    }
}
