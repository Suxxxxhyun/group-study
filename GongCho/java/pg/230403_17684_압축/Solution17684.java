package Level2;

import java.util.*;
class Solution17684 {

    ArrayList<Integer> answer = new ArrayList<Integer>();
    HashMap<String, Integer> map = new HashMap<String, Integer>();

    public ArrayList<Integer> solution(String msg) {

        for(int i=0; i<26; i++){
            char ch = (char)(i + 'A');
            map.put(String.valueOf(ch), i+1);
        }

        int dic = 27;
        boolean isEnd = false;

        for(int i=0; i<msg.length(); i++){
            String word = msg.charAt(i) + "";

            while(map.containsKey(word)){
                i++;
                if(i == msg.length()){
                    isEnd = true;
                    break;
                }
                word += msg.charAt(i);
            }

            if(isEnd){
                answer.add(map.get(word));
                break;
            }

            answer.add(map.get(word.substring(0,word.length()-1)));
            map.put(word, dic++);
            i--;
        }
        return answer;
    }
}