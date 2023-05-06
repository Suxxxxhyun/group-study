package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_1234_230505 {
    static Stack<Integer> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            String pass = st.nextToken();

            stack = new Stack<>();
            for (int k = 0; k < pass.length(); k++) {
                int num = Integer.parseInt(String.valueOf(pass.charAt(k)));
                if (!stack.isEmpty() && stack.peek() == num) {
                    stack.pop();
                } else {
                    stack.push(num);
                }
            }

            StringBuilder sb2 = new StringBuilder();
            while (!stack.isEmpty()) {
                sb2.append(stack.pop());
            }

            sb.append(String.format("#%d %s\n", i, sb2.reverse()));
        }
        System.out.println(sb);
    }
}
