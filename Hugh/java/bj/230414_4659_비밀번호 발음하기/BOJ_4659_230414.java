package BOJ.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_4659_230414 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();
            if (str.equals("end")) {
                break;
            }

            if (!isHighQuality(str)) {
                sb.append("<" +  str + "> is not acceptable.").append("\n");
            } else {
                sb.append("<" +  str + "> is acceptable.").append("\n");
            }

        }

        System.out.println(sb);
    }

    static boolean isHighQuality(String str) {
        if (!haveMo(str)) {
            return false;
        }

        for (int i = 2; i < str.length(); i++) {
            if (isMo(str.charAt(i)) && isMo(str.charAt(i - 1)) && isMo(str.charAt(i - 2))) {
                return false;
            }
            if (!isMo(str.charAt(i)) && !isMo(str.charAt(i - 1)) && !isMo(str.charAt(i - 2))) {
                return false;
            }
        }

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                if ((str.charAt(i) != 'e') && (str.charAt(i) != 'o')) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean haveMo(String str) {
        return (str.contains("a") || str.contains("e") ||str.contains("i") || str.contains("o") || str.contains("u"));
    }

    static boolean isMo(char str) {
        return (str == 'a' || str == 'e' ||str == 'i' || str == 'o' || str == 'u');
    }
}
