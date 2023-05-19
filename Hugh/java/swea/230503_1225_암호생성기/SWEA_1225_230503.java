package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1225_230503 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();

       for (int i = 1; i <= 10; i++) {
           T = Integer.parseInt(br.readLine());
           Queue<Integer> que = new LinkedList<>();

           StringTokenizer st = new StringTokenizer(br.readLine());
           int num = 8;
           while (num-- > 0) {
               que.add(Integer.parseInt(st.nextToken()));
           }

           while (true) {
               boolean flag = false;
               for (int j = 1; j <= 5; j++) {
                   int firstQ = que.poll();
                   firstQ -= j;
                   if (firstQ <= 0) {
                       firstQ = 0;
                       que.add(firstQ);
                       flag = true;
                       break;
                   }
                   que.add(firstQ);
               }
               if (flag) {
                   break;
               }
           }

           sb.append(String.format("#%d ", i));
           while (!que.isEmpty()) {
               sb.append(que.poll() + " ");
           }
           sb.append("\n");
       }
        System.out.println(sb);
    }
}
