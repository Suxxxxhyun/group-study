package BOJ.Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1764_230329 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        ArrayList<String> list = new ArrayList<>();
        for(int j = 0; j < M; j++) {
            String check = br.readLine();
            if(set.contains(check)) list.add(check);
        }
        Collections.sort(list);

        sb.append(list.size()).append("\n");
        for(String result:list){
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
