import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/** 2023.08.01 (09:47 ~ 10:30)

 제한: 2초, 512mb
 입력:
  1. L: 1 ~ 20억
  2. R: L ~ 20억

 목표: L보다 크거나 같고, R보다 작거나 같은 자연수 중 8이 가장 적게 들어있는 수에 들어있는 8의 개수 구하기
 -> 수를 linear 완탐 X
 -> log scale로 어떤 수 구하기
 -> or 수 길이 linear 하게 구하기
 -> or 수식적으로 구할수도?


 시도1:
 1. R의 자릿수가 길면 무조건 0 (0으로 채워버릴 수 있으니까)
 2. 그 외의 경우
 -> 같은 자릿수가 모두 8인 경우 카운트

 반례: L: 11 118111  R: 11 918111

 시도2:
 1. 동일
 2. 동일
 3. 단, 같은 자릿수가 서로 다른 수면 종료 (무조건 8이 안나오게 할 수 있으니까)
 L: 18  118111
 R: 18  918111
 -> 18까진 동일해야하고,
 -> 이후인 118111 ~ 918111 사이 수 중에서 8이 무조건 안나오게 할 수 있음

 */
public class Main {
    private static String L, R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        L = info[0];
        R = info[1];
        System.out.println(pro());
    }

    private static int pro() {
        // R의 자릿수가 더 큰 경우
        if(L.length() < R.length()) {
            return 0;
        }
        int count = 0;
        for(int idx=0; idx<L.length(); idx++) {
            char lTarget = L.charAt(idx);
            char rTarget = R.charAt(idx);
            if(lTarget == rTarget) {
                if(lTarget == '8') {
                    count++;
                }
            } else {    //중요!!!!! 없을 시, 반례: 11118111 , 11918111
                break;
            }
        }
        return count;
    }
}
