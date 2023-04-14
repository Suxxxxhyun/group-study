package baekjun.src.baekjun.String;

//9:50 ~ 10:10
import java.io.*;
public class Main1543 {

    static String a, b;
    static int cnt;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine();
        b = br.readLine();

        /*int L = 0,R = 0;
        String str = "";
        while(R + 1 <= a.length()){
            if(a.charAt(R) == b.charAt(L)){
                str += b.charAt(L++);
                R++;
            } else {
                R++;
            }

            if(str.length() == b.length()){
                cnt += 1;
                str = "";
                L = 0;
            }
        }*/
        //위처럼 풀면 안되는 이유 : a b a b a / ba로 주게 된다면, 결과값이 2가나옴.
        while(a.contains(b)){
            cnt++;
            a = a.replaceFirst(b, " ");
        }
        System.out.println(cnt);

    }
}
