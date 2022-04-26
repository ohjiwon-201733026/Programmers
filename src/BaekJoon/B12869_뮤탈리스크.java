package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B12869_뮤탈리스크 {
    // 순서대로 a,b,c의 체력과 누적된 공격횟수에 대한 가능 여부를 저장할 변수
    static int[][][][] d = new int[61][61][61][61];
    // 어차피 맥시멈 체력은 60이라서 70번이면 다 죽이고도 남음
    static int min = 70;
    // 가능한 공격의 경우의 수를 저장
    static int[][] p = { {9,3,1},{9,1,3},{3,9,1},{3,1,9},{1,3,9},{1,9,3} };

    static int go(int a, int b, int c, int cnt){

        // a,b,c가 음수인 경우 배열 인덱스 에러가 나므로 모두 0 으로 변경
        if(a < 0) a = 0;
        if(b < 0) b = 0;
        if(c < 0) c = 0;

        // 이미 최소 공격횟수를 넘어버린 경우 더이상 진행하지 않는다
        if(cnt >= min){
            d[a][b][c][cnt] = 0;
            return 0;
        }

        // 체력이 모두 바닥이라면 cnt값을 min에 저장 후 메모이제이션 후 리턴한다
        if(a<=0 && b<=0 && c<=0){
            min = Math.min(min,cnt);
            d[a][b][c][cnt] = 1;
            return 1;
        }

        // 메모된 값이 있다면 꺼내쓰자
        if(d[a][b][c][cnt] != -1){
            return d[a][b][c][cnt];
        }

        // 가능한 공격 패턴에 대해 모두 진행한다
        for(int i = 0 ; i < 6 ; i++){
            if(go(a-p[i][0], b-p[i][1], c-p[i][2], cnt+1) == 1){
                d[a][b][c][cnt] = 1;
            }
        }

        return 0;
    }

    public static void main(String []args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] scv = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            scv[i] = Integer.parseInt(st.nextToken());
        }

        // d는 -1로 초기화
        for(int i = 0 ; i <= 60 ; i++ ){
            for(int j = 0 ; j <= 60 ; j++){
                for(int k = 0 ; k <= 60 ; k++){
                    Arrays.fill(d[i][j][k], -1);
                }
            }
        }


        go(scv[0], scv[1], scv[2], 0);
        System.out.println(min);
    }
}
