package Level2;

//10:20 ~ 10:50
class Solution18118702 {

    long answer = 0;

    public long solution(int r1, int r2) {

        long r1x = (long)Math.pow(r1,2);
        long r2x = (long)Math.pow(r2,2);
        long side = 0;

        //시간복잡도가 백만으로 끝남
        for(int i=0; i<=r2; i++){
            long y2x = (long)Math.sqrt(r2x - (long)Math.pow(i,2)); //3

            long y1x = (long)Math.sqrt(r1x - (long)Math.pow(i,2)); //2

            answer += (y2x - y1x) * 4;

            if(Math.sqrt(r1x - Math.pow(i,2)) % 1 == 0){
                side++;
            }
        }

        answer += side * 4 - 4;
        return answer;
    }
}