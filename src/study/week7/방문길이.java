package study.week7;


public class 방문길이 {

    public static void main(String[] args) {
        String dirs="LULLLLLLU";
        int answer=solution(dirs);
        System.out.println(answer);
    }


    private static int solution(String dirs) {
        int answer=0;

        int [][][] map=new int [11][11][4];
        int curX=5; // 원래 좌표 0 +5
        int curY=5; // 원래 좌표 0 +5

        for(int i=0;i<dirs.length();++i){
            char dir=dirs.charAt(i);
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
                }
                curX=nextX;
                curY=nextY;
            }

        }
        return answer;
    }
}
