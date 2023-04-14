package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1543_230414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int cnt = 0;

        while(str1.contains(str2)) {
            cnt++;
            str1 = str1.replaceFirst(str2," ");
        }

        System.out.println(cnt);

    }
}
