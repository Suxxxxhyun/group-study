class Solution {
    public int solution(int K, String[] user_scores){
        int answer = 0; // 랭킹이 몇번바뀌는지 count
        // 페이지당 k명씩 닉네임 보여줌 
        String[] rank_arr = new String[K+1];

        for(int i=0; i<user_scores.length; i++){
            // 유저 이름, 점수 
            String u_name = user_scores[i].split(" ")[0];
            int u_score = Integer.parseInt(user_scores[i].split(" ")[1]);
            // 랭킹된 점수 비교하기
            for(int l=0; l<K; l++){
                if(rank_arr[l]==null){// 처음 등재될경우 
                    rank_arr[l] = user_scores[i]; 
                    answer++;
                    break;
                }else{
                    // 랭크에 등재된 이름, 점수 
                    String r_name = rank_arr[l].split(" ")[0];
                    int r_score = Integer.parseInt(rank_arr[l].split(" ")[1]);
                    if(r_score < u_score){ // 점수가 크거나 이름이 다를경우만 등재하기
                        if(!u_name.equals(r_name)){
                            rank_arr[l] = user_scores[i];
                            answer++;
                        }
                        break;
                    }
                }
            }
        }
        return answer;
    }//with A as(
}// 50 40 35 21 20 10  