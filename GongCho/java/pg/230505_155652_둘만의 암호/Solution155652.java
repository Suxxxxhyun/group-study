package Level1;

import java.util.*;

public class Solution155652 {

    String answer = "";

    public String solution(String s, String skip, int index) {

        for(int i=0; i<s.length(); i++) {
            char w = s.charAt(i);
            int count = index, j = 1, word = 0;
            while(count > 0) {
                word = (int)w + j++;
                //System.out.println("빼기전" + "," + word);
                if(word > 122) {
                    while(word > 122){
                        word -= 26;
                    }
                    //System.out.println("탔음" + "," + word);
                }
                if(!skip.contains((char)word + "")) {
                    //System.out.println("탔음" + "," + word);
                    count--;
                }
                //System.out.println((char)word + "," + count + "," + word);

            }
            //System.out.println("==============");
            answer += (char)word + "";
        }
        return answer;
    }

}

