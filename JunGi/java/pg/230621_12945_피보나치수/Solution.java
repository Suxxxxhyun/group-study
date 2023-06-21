class Solution {
    public int solution(int n) {
        int[] arr = new int[n+1];
        arr[1] = 1;
        arr[2] = 1;
        for(int i=3; i<n+1; i++) {
            arr[i] = (arr[i-2] + arr[i-1]) % 1234567;
        }
        return arr[n] % 1234567;
    }
}
