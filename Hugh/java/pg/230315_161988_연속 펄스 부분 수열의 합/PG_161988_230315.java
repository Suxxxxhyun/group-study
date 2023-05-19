package Programmers;

public class PG_161988_230315 {
    static int[] arr = new int[]{1,2,3,-4,5,6,-7,8};

    public static void main(String[] args) {


        System.out.println(solution(arr));
    }
    static long solution(int[] sequence) {
        long max = Integer.MIN_VALUE;
        long min = Integer.MAX_VALUE;

        long answer = 0;
        long[] sum = new long[sequence.length + 1];
        for(int i = 1; i < sum.length; i++) {
            if(i % 2 == 0) {
                sum[i] = sum[i - 1] + (long) sequence[i - 1] * -1;
            } else {
                sum[i] = sum[i - 1] + (long) sequence[i - 1];
            }
        }

        for(int i = 0; i < sum.length; i++) {

            System.out.println(sum[i]);
            if(max < sum[i]) {
                max = sum[i];
            }
            if(min > sum[i]) {
                min = sum[i];
            }
        }
        answer = (max - min);
        return answer;
    }


}
