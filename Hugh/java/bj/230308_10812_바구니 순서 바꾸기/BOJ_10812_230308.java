package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_10812_230308 {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 문자열 토큰으로 입력받음

        n = Integer.parseInt(st.nextToken()); // 첫번째 토큰 정수로 변환
        m = Integer.parseInt(st.nextToken()); // 두번째 토큰 정수로 변환
        int[] arr = new int[n];

        for (int i = 0; i < n; i++){ // n번만큼 반복
            arr[i] = i + 1; // i번 인덱스에 i+1을 넣어줌
        }

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int begin = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int mid = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();

            for (int j = begin; j <= end; j++){ // begin부터 end 가지 반복
                queue.add(arr[begin - 1]); // 큐에 바구니 바꾸기 전 값 넣어줌
                if(mid <= end) {
                    arr[begin - 1] = arr[mid - 1];
                    begin++;
                    mid++;
                } else if (mid > end) {
                    arr[begin - 1] = queue.poll(); // 큐에 넣어둔 begin 값을 넣어줌
                    begin++;
                }

            }

        }
        for (int i:arr){
            System.out.print(i + " ");
        }

    }
}
