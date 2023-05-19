package SWEA.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1859_230420 {
    static int T;
    static int num = 1;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (max < arr[i]) {
                    max = arr[i];
                }
            }

            maxProfit(arr, max);
        }

        System.out.println(sb);
    }

    static void maxProfit(int[] arr, int max) {
        Queue<Integer> q = new LinkedList<>();
        long profit = 0;
        for (int i = 0; i < arr.length; i++) {
           q.offer(arr[i]);
           if (arr[i] == max) {
               while (!q.isEmpty()) {
                   profit += (max - q.poll());
               }

               // max값 재갱신
               max = Integer.MIN_VALUE;
               for (int j = i + 1; j < arr.length; j++) {
                   if (max < arr[j]) {
                       max = arr[j];
                   }
               }
           }
        }
        sb.append("#" + num + " " + profit + "\n");
        num++;
    }
}
