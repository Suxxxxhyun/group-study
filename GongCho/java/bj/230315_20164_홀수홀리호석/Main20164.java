package baekjun.src.baekjun.implement;

import java.io.*;
public class Main20164 {

    static int n, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        cut(n, getOdd(n));
        System.out.println(min + " " + max);
    }

    static void cut(int x, int total){
        if(x < 10){
            min = Math.min(min, total);
            max = Math.max(max, total);
        } else if(x < 100){
            int a = x / 10;
            int b = x % 10;
            cut(a + b, total + getOdd(a + b));
        } else {
            String st = Integer.toString(x);
            int len = st.length();
            for(int i=0; i<=len-3; i++){
                for(int j=i+1; j<=len-2; j++){
                    String s1 = st.substring(0, i+1);
                    String s2 = st.substring(i+1, j+1);
                    String s3 = st.substring(j+1, len);
                    System.out.print(s1 + " " + s2 + " " + s3);
                    System.out.println();

                    int sum = Integer.parseInt(s1) + Integer.parseInt(s2) + Integer.parseInt(s3);
                    cut(sum, total + getOdd(sum));
                }
            }
        }
    }

    //입력의 최댓값이 10^9 - 1, 최대 9자리수, 따라서 getOdd메소드는 최대 9번까지 연산을 함.
    static int getOdd(int n){
        int cnt = 0;
        while(n > 0){
            int val = n % 10;
            if(val % 2 == 1){
                cnt++;
            }
            n /= 10;
        }
        return cnt;
    }
}
