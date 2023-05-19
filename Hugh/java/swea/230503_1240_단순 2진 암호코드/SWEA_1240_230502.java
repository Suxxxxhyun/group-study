package SWEA.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_1240_230502 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            String source = "";
            for (int j = 0; j < a; j++) {
                String str = br.readLine();
                if (str.contains("1")) {
                    StringBuilder sb1 = new StringBuilder(str);
                    source += sb1.reverse().toString();
                }
            }

            ArrayList<Integer> list = new ArrayList<>();
            for (int k = 0; k < source.length(); k++) {
                if (source.charAt(k) == '1') {
                    String pass = "";
                    for (int z = k; z < k + 7; z++) {
                        pass += source.charAt(z);
                    }
                    StringBuilder sb2 = new StringBuilder(pass);
                    switch (sb2.reverse().toString()) {
                        case "0001101":
                            list.add(0);
                            break;
                        case "0011001":
                            list.add(1);
                            break;
                        case "0010011":
                            list.add(2);
                            break;
                        case "0111101":
                            list.add(3);
                            break;
                        case "0100011":
                            list.add(4);
                            break;
                        case "0110001":
                            list.add(5);
                            break;
                        case "0101111":
                            list.add(6);
                            break;
                        case "0111011":
                            list.add(7);
                            break;
                        case "0110111":
                            list.add(8);
                            break;
                        case "0001011":
                            list.add(9);
                            break;
                    }
                    k += 6;
                }
                if (list.size() == 8) {
                    break;
                }
            }

            int even = 0;
            int odd = 0;
            for (int j = 0; j < list.size(); j++) {
                if (j % 2 == 0) {
                    odd += list.get(j);
                } else if (j % 2 == 1) {
                    even += list.get(j);
                }
            }
            if (((even * 3) + odd) % 10 == 0) {
                sb.append(String.format("#%d %d\n", i, even + odd));
            } else {
                sb.append(String.format("#%d %d\n", i, 0));
            }
        }
        System.out.println(sb);
    }
}