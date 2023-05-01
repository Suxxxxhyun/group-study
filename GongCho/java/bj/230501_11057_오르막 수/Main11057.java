package baekjun.src.baekjun.DynamicProgramming;

import java.io.*;
//12:53 ~ 1:00
//https://minhamina.tistory.com/147
public class Main11057 {

    static int n;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n+2][10];

        pro();
    }

    static void pro(){
        //√ ±‚»≠
        for(int i=0; i<=9; i++){
            dp[1][i] = 1;
        }

        for(int i=2; i<=n+1; i++){
            for(int j=0; j<10; j++){
                for(int k=j; k<10; k++){
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }
        System.out.println(dp[n+1][0]);
    }
}
