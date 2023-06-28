package BOJ.Stack;

import java.io.*;
import java.util.Stack;

/**
 * 10:20~11:57
 *
 * +를 주는것
 */
public class BOJ_2504_230628 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        Stack<Character> stack = new Stack<>();

        int result = 0;
        int val = 1;
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);

            if (a == '(') {
                stack.push(a);
                val *= 2;
            } else if (a == '[') {
                stack.push(a);
                val *= 3;
            } else if (a == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                } else if (str.charAt(i - 1) == '(') {
                    result += val;
                }
                stack.pop();
                val /= 2;
            } else if (a == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                } else if (str.charAt(i - 1) == '[') {
                    result += val;
                }
                stack.pop();
                val /= 3;
            }
        }

        if (!stack.isEmpty()) sb.append(0).append("\n");
        else sb.append(result).append("\n");

        bw.write(sb.toString());
        bw.flush();

        bw.close();
        br.close();
    }
}
