package Level1;

//https://bacchus-lover.tistory.com/521?category=903169블로그 풀이

public class Solution161990 {

    private static char EMPTY = '.';
    private static char FILE = '#';
    private static int MAX_VALUE = 51;

    public int[] solution(String[] wallpaper) {

        int[] answer;
        int minX = MAX_VALUE, minY = MAX_VALUE, maxY = 0, maxX = 0;
        for(int i=0; i<wallpaper.length; i++){
            for(int j=0; j<wallpaper[0].length(); j++){
                //i = 0, j = 1일때 file이 있음
                //i = 1, j = 2일때 file이 있음
                //i = 2, j = 3일때 file이 있음
                if(wallpaper[i].charAt(j) == FILE){
                    minX = Math.min(minX, i); //[무한, 0] - 0 / [0, 1] - 0 / [0, 2] - 0
                    minY = Math.min(minY, j); //[무한, 1] - 1 / [1, 2] - 1 / [1, 3] - 1
                    maxX = Math.max(maxX, i+1); //[0,1] - 1 / [1,2] - 2 / [2,3] - 3
                    maxY = Math.max(maxY, j+1); //[0,2] - 2 / [2,3] - 3 / [3,4] - 4
                }
            }
        }
        answer = new int[] {minX, minY, maxX, maxY};

        return answer;
    }
}
