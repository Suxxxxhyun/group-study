package BOJ.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    10:36~12:58

    *이분탐색*

    인접한 두 공유기 사이의 거리를 최대로
    이분탐색으로 나누면서 각각 mid 에 공유기 설치

    이분탐색은 정렬이 필수

    최소 거리가 가질 수 있는 최솟값
    최소 거리가 가질 수 있는 최댓값
 */
public class BOJ_2110_230809 {
    static long[] arr;
    static int n, c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new long[n];
        for (int i = 0; i < n; i++) {
            long home = Long.parseLong(br.readLine());
            arr[i] = home;
        }
        Arrays.sort(arr);

        System.out.println(binarySearch());
    }

    // 최댓값을 좁혀가는 과정
    static long binarySearch() {
        long L = 1; // 최소 거리가 가질 수 있는 최솟값
        long R = arr[n-1] - arr[0]; // 최소 거리가 가질 수 있는 최댓값

        while (L <= R) {
            long mid = (L+R)/2;

            if (install(mid) < c) {
                R = mid-1;
            } else {
                L = mid+1;
            }
        }
        return L-1;
    }

    static int install(long dist) {
        int count = 1;
        long pre = arr[0];

        for (int i = 1; i < n; i++) {
            long now = arr[i];
            if (now - pre >= dist) {
                count++;
                pre = now;
            }
        }

        return count;
    }
}
