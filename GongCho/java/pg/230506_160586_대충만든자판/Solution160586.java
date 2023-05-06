package Level1;

//10:11 ~ 10:41
import java.util.*;
//다 끝나고 호석이가 하는 인접리스트 구현 방식, 나동빈이 하는 인접리스트 구현방식
//확인
class Solution160586 {

    int[] answer;

    private final int VAL = 101;

    public int[] solution(String[] keymap, String[] targets) {

        answer = new int[targets.length];

        ArrayList<String> list = new ArrayList<String>();

        for(int i=0; i<targets.length; i++){
            //[AC]
            for(int j=0; j<targets[i].length(); j++){
                //A
                char c = targets[i].charAt(j);
                //System.out.println(c);
                int val = VAL;
                //1
                for(int k=0; k<keymap.length; k++){
                    if(keymap[k].contains(c + "")){
                        if(val > keymap[k].indexOf(c + "")){
                            val = keymap[k].indexOf(c + "");
                        }
                        //System.out.println(val + "," + c);
                    }
                }
                if(val == VAL){
                    answer[i] = -1;
                    break;
                } else {
                    answer[i] += val + 1;
                }
            }
        }

        return answer;
    }
}
