package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_24266_230313 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Long n = Long.parseLong(br.readLine());


        sb.append(n * n * n).append("\n").append(3);
        System.out.println(sb);

    }
}
