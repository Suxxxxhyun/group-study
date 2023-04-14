package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_13223_230414 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        String[] now = str1.split(":");
        String[] endTime = str2.split(":");


        int now_SecondAmount = (Integer.parseInt(now[0]) * 3600) +
                (Integer.parseInt(now[1]) * 60) + Integer.parseInt(now[2]);

        int end_SecondAmount = (Integer.parseInt(endTime[0]) * 3600) +
                (Integer.parseInt(endTime[1]) * 60) + Integer.parseInt(endTime[2]);

        int result_SecondAmount = (end_SecondAmount - now_SecondAmount);

        if (result_SecondAmount <= 0) {
            result_SecondAmount += (24 * 3600);
        }

        int result_H = (result_SecondAmount / 3600);
        int result_M = (result_SecondAmount % 3600) / 60;
        int result_S = (result_SecondAmount % 60);

        System.out.printf("%02d:%02d:%02d", result_H, result_M, result_S);

    }
}
