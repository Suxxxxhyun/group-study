package BOJ.Hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BOJ_1620_230329 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            String name = br.readLine();
            map.put(name, i);
            list.add(name);
        }
        while(M-- > 0) {
            String val = br.readLine();
            if(isStringNumber(val)){
                sb.append(list.get(Integer.parseInt(val) - 1)).append("\n");
            } else {
                sb.append(map.get(val)).append("\n");
            }
        }
        System.out.println(sb);
    }
    static boolean isStringNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
}