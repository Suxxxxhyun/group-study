/*
2023.06.21
09:30 ~ 10:20
*/
import java.util.*;

class Solution {
    private Map<String, Integer> wordAndIdx;
    private int wordAndIdxCount = 26;
    public int[] solution(String msg) {
        List<Integer> result = new ArrayList<>();
        initialWordAndIdx();
        
        while(!msg.equals("")) {
            int lastIdx = findW(msg);

            String w = msg.substring(0, lastIdx);
            result.add(wordAndIdx.get(w));
            
            if(lastIdx != msg.length()) {
                String newWord = msg.substring(0, lastIdx+1);
                wordAndIdx.put(newWord, ++wordAndIdxCount);
            }
            msg = msg.substring(lastIdx, msg.length());
        }
        
        int[] answer = new int[result.size()];
        for(int i=0, n=answer.length; i<n; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
    
    private int findW(String msg) {
        int idx = 0;
        for(int lastIdx=msg.length(); lastIdx>=0; lastIdx--) {
            String tempW = msg.substring(0, lastIdx);
            if(wordAndIdx.containsKey(tempW)) {
                idx = lastIdx;
                break;
            }
        }
        return idx;
    }
    
    private void initialWordAndIdx() {
        wordAndIdx = new HashMap<>();
        for(char c='A', idx=1; c<='Z'; c++, idx++) {
            wordAndIdx.put(c + "", (int)idx);
        }
    }   
}
