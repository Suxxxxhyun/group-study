/*
2023.06.20
13:41 ~ 13:43
type: 정렬
*/
import java.util.*;

class Solution {
    public String solution(String s) {
        int[] arr = initialIntArr(s);
        Arrays.sort(arr);
        return String.format("%d %d", arr[0], arr[arr.length-1]);
    }
    
    private int[] initialIntArr(String s) {
        String[] parsed = s.split(" ");
        int[] arr = new int[parsed.length];
        for(int i=0, n=parsed.length; i<n; i++) {
            arr[i] = Integer.parseInt(parsed[i]);
        }
        return arr;
    }
}
