package study.week7;


public class 방문길이 {

    public static void main(String[] args) {
        String dirs="LULLLLLLU";
        int answer=solution(dirs);
        System.out.println(answer);
    }


    private static int solution(String dirs) {
        int answer=0;
        // -5 -4 -3 -2 -1 0
        // 0 1    2  3 4  5
        // 0,0 -> -1,0 L

        int [][][] map=new int [11][11][4];
        int curX=5; // 원래 좌표 0 +5
        int curY=5; // 원래 좌표 0 +5

        for(int i=0;i<dirs.length();++i){
            char dir=dirs.charAt(i); // L
            int nextX=curX;
            int nextY=curY;
            int dirNum=0;
            switch (dir){
                case 'U':nextY=curY-1;dirNum=0;break;
                case 'D':nextY=curY+1;dirNum=1;break;
                case 'R':nextX=curX+1;dirNum=2;break;
                case 'L':nextX=curX-1;dirNum=3;break;
            }

            if(0<=nextX && nextX <11 &&0<=nextY && nextY<11) {
                if (map[nextX][nextY][dirNum] == 0) {

                    answer++;
                    map[nextX][nextY][dirNum] = 1;
                    if(dir=='U') dirNum=1;
                    if(dir=='D') dirNum=0;
                    if(dir=='R') dirNum=3;
                    if(dir=='L') dirNum=2;
                    map[curX][curY][dirNum]=1;

                }
                curX=nextX;
                curY=nextY;
            }

        }
        return answer;
    }
}
