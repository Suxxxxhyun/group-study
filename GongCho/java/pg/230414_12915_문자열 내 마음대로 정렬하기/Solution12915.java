package Level1;

//1:19 ~ 1:40
import java.util.*;
class Solution12915 {

    public String[] solution(String[] strings, int n) {

        Arrays.sort(strings, new Comparator<String>(){
            public int compare(String o1, String o2){
                if(o1.charAt(n) == o2.charAt(n)){
                    //여기서 털림. String은 compareTo뿐임!
                    return o1.compareTo(o2);
                }
                return o1.charAt(n) - o2.charAt(n);
            }
        });
        return strings;
    }
}
