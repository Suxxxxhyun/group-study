package Programmers;

import java.util.Arrays;
import java.util.Comparator;

public class PG_42746_230310 {
    public static void main(String[] args) {
        int[] numbers = new int[]{6, 10, 2};

        System.out.println(solution(numbers));
    }

    static String solution(int[] numbers){
        String[] strNumbers = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++){
            strNumbers[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if(strNumbers[0].equals("0")) return "0";

        return String.join("", strNumbers);
    }
}
