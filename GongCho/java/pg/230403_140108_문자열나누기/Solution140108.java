package Level1;

import java.util.*;

class Solution140108 {

    int answer = 0;
    ArrayList<String> list = new ArrayList<String>();

    public int solution(String s) {

        char prev = s.charAt(0); //a
        String str = prev + "";
        int prev_count = 1, now_count = 0;

        for(int i=1; i<s.length(); i++){

            if(prev_count == now_count){
                s = s.substring(i,s.length());
                list.add(str);
                i=0;
                if(s.length() > 0){
                    prev = s.charAt(i);
                }
                prev_count = 1;
                now_count = 0;
                i++;
                str = prev + "";
            }

            if(i == s.length()){
                break;
            }
            char ch = s.charAt(i);
            if(prev == ch){
                prev_count++;
                str += ch;
            } else {
                now_count++;
                str += ch;
            }
        }

        answer = list.size();
        return answer;
    }
}