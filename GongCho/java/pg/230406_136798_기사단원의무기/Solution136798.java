package Level1;

//~8:00
//제곱근까지 구해서 하는게 뭐였더라..? -> 오늘 알아볼것. -> 이게 약수의 개수일것같은데? -> 맞음.
import java.util.*;

class Solution136798 {

    int answer = 0;
    ArrayList<Integer> list = new ArrayList<Integer>();

    public int solution(int number, int limit, int power) {

        //1의 약수는 1개
        list.add(1);

        for(int j=2; j<=number; j++){
            int count = 0;
            for(int i=1; i<=Math.sqrt(j); i++){
                if(i * i == j){
                    count++;
                } else if(j % i == 0){
                    count += 2;
                }
            }
            list.add(count);
        }

        //System.out.println(list);

        for(int i=0; i<list.size(); i++){
            if(limit < list.get(i)){
                answer += power;
            } else {
                answer += list.get(i);
            }
        }
        return answer;
    }
}
