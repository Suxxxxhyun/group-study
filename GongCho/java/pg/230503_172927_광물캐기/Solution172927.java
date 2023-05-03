package Level2;

///7:50 ~ 9:40 실패
class Solution172927 {

    int answer = Integer.MAX_VALUE;

    public int solution(int[] picks, String[] minerals) {

        pro(picks, minerals, 0, 0);
        return answer;
    }

    //이때 idx는 minerals의 인덱스를 의미함.
    //sum은 구한 피로도의 합
    public void pro(int[] picks, String[] minerals, int idx, int sum){
        if(idx >= minerals.length){
            answer = Math.min(answer, sum);
            return;
        }

        if(picks[0] == 0 && picks[1] == 0 && picks[2] == 0){
            answer = Math.min(answer,sum);
            return;
        }

        int copy_sum = sum;

        for(int cand = 0; cand < picks.length; cand++){
            //다이아몬드 곡괭이를 이용할 경우
            if(cand == 0){
                if(picks[cand] > 0){
                    picks[cand]--;
                    int cnt = idx;
                    for(int i=0; i<5; i++){
                        if(cnt == minerals.length){
                            break;
                        }
                        copy_sum += 1;
                        cnt++;
                    }
                    //System.out.println(cnt);
                    pro(picks, minerals, cnt, copy_sum);
                    picks[cand]++;
                    copy_sum = sum;
                }
            }
            //철 곡괭이를 이용할 경우
            else if(cand == 1){
                if(picks[cand] > 0){
                    picks[cand]--;
                    int cnt = idx;
                    for(int i=0; i<5; i++){
                        if(cnt == minerals.length){
                            break;
                        }
                        if(minerals[cnt].equals("diamond")){
                            copy_sum += 5;
                        } else {
                            copy_sum += 1;
                        }
                        cnt++;
                    }

                    //System.out.println(cnt);
                    //System.out.println("피로도" + copy_sum);
                    pro(picks, minerals, cnt, copy_sum);
                    picks[cand]++;
                    copy_sum = sum;
                }
            }
            //돌 곡괭이를 이용할 경우
            else{
                if(picks[cand] > 0){
                    picks[cand]--;
                    int cnt = idx;
                    for(int i=0; i<5; i++){
                        if(cnt == minerals.length){
                            break;
                        }
                        if(minerals[cnt].equals("diamond")){
                            copy_sum += 25;
                        } else if(minerals[cnt].equals("iron")){
                            copy_sum += 5;
                        } else {
                            copy_sum += 1;
                        }
                        cnt++;
                    }
                    //System.out.println(cnt);
                    //System.out.println("피로도" + copy_sum);
                    pro(picks, minerals, cnt, copy_sum);
                    picks[cand]++;
                    copy_sum = sum;
                }
            }
        }
    }
}