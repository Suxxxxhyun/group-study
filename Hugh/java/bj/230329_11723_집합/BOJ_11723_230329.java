package BOJ.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_11723_230329 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer> list = new LinkedList<>();

        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int val;
            switch(command) {
                case "add":
                    val = Integer.parseInt(st.nextToken());
                    if(!list.contains(val)) list.add(val);
                    break;
                case "remove":
                    val = Integer.parseInt(st.nextToken());
                    if(list.contains(val)) list.remove(Integer.valueOf(val));
                    break;
                case "check":
                    val = Integer.parseInt(st.nextToken());
                    if(list.contains(val)) sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "toggle":
                    val = Integer.parseInt(st.nextToken());
                    if(list.contains(val)) list.remove(Integer.valueOf(val));
                    else list.add(val);
                    break;
                case "all":
                    list.clear();
                    for(int j = 1; j <= 20; j++) list.add(j);
                    break;
                case "empty":
                    list.clear();
                    break;
            }
        }

        System.out.println(sb);
    }
}
