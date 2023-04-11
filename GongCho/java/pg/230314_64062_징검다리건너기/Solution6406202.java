package Programmers;

//12:30 ~ 1:00 시작
//stones배열의 원소의 값[2억, 1억, 1억, 2억, 2억]
//1억번째 사람이 건너려고할때 1억이하의 숫자값은 사라진다.
import java.util.*;

class Solution6406202 {
  
  int answer = 0;
  //Integer[] st;
  
  public int solution(int[] stones, int k) {
      
      /*st = new Integer[stones.length];
      for(int i=0; i<st.length; i++){
          st[i] = stones[i];
      }
      
      Arrays.sort(st, Collections.reverseOrder());
      System.out.println(Arrays.toString(st));*/
      int L = 1, R = 200000000;
      //R을 2억으로 설정한 이유는?
      //2억1로 설정할 필요가 없는 이유는, stones배열의 모든값이 2억으로 설정되어있고, k가 3이라고 하였을때, 2억1번째 사람은 어차피 건너지 못함. 2억번째 사람까지만 확인하면 될듯.
      //System.out.println(R);
      while(L <= R){
          int mid = (L + R) / 2;
          if(determination(mid, stones, k)){
              L = mid + 1;
              //answer++이 안되는 이유는? - 주어진 입력으로 생각하고, R = 5로 설정해보면,
              //mid = 3이었을때 answer를 한번세주고, mid = 4가 되었을때, 결국 건너지 못해서
              //answer를 1로 반환하게 됨.
              answer = Math.max(mid, answer);
          } else {
              R = mid - 1;
          }
      }
      
      return answer;
  }
  
  boolean determination(int x, int[] stones, int k){
      int count = 0;
      for(int i=0; i<stones.length; i++){
          if(x > stones[i]){
              count++;
              if(count >= k){
                  return false;
              }
          } else {
              count = 0;
          }
      }
      return true;
  }
}
