package BOJ.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_4949_230321 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            Stack<Character> stack = new Stack<>();
            String str = br.readLine();

            if(str.equals(".")) break;

            for(int i = 0; i < str.length(); i++) {
                char bal = str.charAt(i);
                if(bal == '(' || bal == '[') stack.push(bal);

                else if(bal == ')' && !stack.isEmpty() && stack.peek() == '(') stack.pop();
                else if(bal == ']' && !stack.isEmpty() && stack.peek() == '[') stack.pop();

                // 닫히는 괄호가 먼저 오면
                else if(bal == ')' || bal == ']') stack.push(bal);
            }

            if(stack.isEmpty()) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
        }

        System.out.println(sb);
    }
}
