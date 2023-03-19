package Level2;

//emoticons의 길이가 최대 7이고, emoticons의 할인율은 4^7의 경우의 수 = 2^14이므로,
//2^20이 백만이므로, 2^14는 백만보다 작은값, 따라서 완탐으로 문제를 해결할 수 있음.
//2^14 + 각 경우의 수에 대해서 list에 이모티콘 플러스와 이모티콘 매출액을 확인한다.
import java.util.*;

class Solution150368 {

    int[] answer;
    //emoticons의 0번째부터 emoticons의 길이까지의 할인율
    int[] selected;
    //할인율이 10,20,30,40 중 하나라고 하였음.
    //중복을 허용하면서 순서를 고려하여 나열하기(조합)
    int[] a = {10,20,30,40};

    ArrayList<Node> list = new ArrayList<Node>();
    class Node implements Comparable<Node>{
        int e_plus, e_price;

        public Node(int e_plus, int e_price){
            this.e_plus = e_plus;
            this.e_price = e_price;
        }

        public int compareTo(Node other){
            if(this.e_plus == other.e_plus){
                return this.e_price - other.e_price;
            }
            return this.e_plus - other.e_plus;
        }
    }

    public int[] solution(int[][] users, int[] emoticons) {

        selected = new int[emoticons.length];
        pro(users, emoticons, 0);
        //answer = {plus, cost};
        answer = new int[2];
        Collections.sort(list);
        /*for(int i=0; i<list.size(); i++){
            System.out.print("[" + list.get(i).e_plus + "," + list.get(i).e_price + "]");
        }
        System.out.println();*/
        answer[0] = list.get(list.size()-1).e_plus;
        answer[1] = list.get(list.size()-1).e_price;
        return answer;
    }

    public void pro(int[][] users, int[] emoticons, int idx){
        if(idx == emoticons.length){
            result(users, emoticons);
            return;
        }

        for(int i=0; i<a.length; i++){
            selected[idx] = a[i];
            pro(users, emoticons, idx + 1);
        }
    }

    public void result(int[][] users, int[] emoticons){
        //이모티콘 플러스를 가입한 사람의 수
        int plus = 0;
        int sum = 0;
        for(int i=0; i<users.length; i++){
            //이모티콘 매출액
            int cost = 0;
            for(int j=0; j<selected.length; j++){
                //어떤 상품에 대해서 30%할인하는데, 사용자는 40%까지 할인을 원한다면
                //사용자는 이 상품에 대해서 구매하지 않음.
                if(selected[j] < users[i][0]){
                    continue;
                } else {
                    int price = (int)((double)emoticons[j] * (double)selected[j] * 0.01);
                    //구매한 비용
                    int get_price = emoticons[j] - price;
                    //System.out.println(get_price);
                    cost += get_price;
                }
            }

            if(cost >= users[i][1]){
                plus++;
                //sum = 0;
            } else {
                sum += cost;
            }
            //System.out.println(i + "번째 사람" + cost + "," + plus);
        }
        /*for(int i=0; i<selected.length; i++){
            System.out.print(selected[i] + ",");
        }
        System.out.println(plus + "," + sum);*/
        list.add(new Node(plus,sum));
    }
}