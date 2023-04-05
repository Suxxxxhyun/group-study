package Level2;

//11:17 ~ 12:00
import java.util.*;

class Solution6406502 {

    ArrayList<Integer> answer = new ArrayList<Integer>();

    public ArrayList<Integer> solution(String s) {

        s = s.substring(2,s.length());
        s = s.substring(0,s.length()-2);
        //s = s.replace("},{","-");
        //14라인에서 },{를 구분자로 넣고싶다면, 아래와 같이 한다.
        String[] str = s.split("\\}\\,\\{");
        Arrays.toString(str);

        Arrays.sort(str, new Comparator<String>(){
            public int compare(String o1, String o2){
                return o1.length() - o2.length();
            }
        });

        for(int i=0; i<str.length; i++){
            String[] temp = str[i].split(",");

            for(int j=0; j<temp.length; j++){
                int num = Integer.parseInt(temp[j]);
                if(!answer.contains(num)){
                    answer.add(num);
                }
            }
        }
        return answer;
    }
}