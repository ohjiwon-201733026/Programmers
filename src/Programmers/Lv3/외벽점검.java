package Programmers.Lv3;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class 외벽점검 {
    
    private int n,answer;
    private int [] weak,dist,spreadWeak;
    private boolean finish;

    public int solution(int n, int [] weak, int [] dist){
        this.n=n;
        this.weak=weak;
        this.dist=dist;
        makeSpreadWeak();
        // 1 5 6 10 13 17 18
        finish=false;

        answer=Integer.MAX_VALUE;

        // i 자리 순열 만들기 ( i 명의 친구들 점검 )
        for(int i=1;i<= dist.length;++i){
            permutation(0,i,new boolean[dist.length],new int [i]);
        }

        return answer == Integer.MAX_VALUE?-1 :answer;
    }
    
    private void permutation(int depth, int num, boolean [] visited, int [] res){
        // 종료 flag
        if(finish) return;
        
        if(depth==num){
            checkIfCanCover(res);
            return;
        }

        for(int i=0;i< dist.length;++i){
            if(!visited[i]){
                res[depth]= dist[i];
                visited[i]=true;
                permutation(depth+1,num,visited,res);
                visited[i]=false;
            }
        }
    }

    private void checkIfCanCover(int[] res) {
        // 시작점 i 기분으로 한바퀴 돌기
        for(int i=0;i<weak.length;++i){
            int start=i;
            boolean flag=true;

            // 친구 수만큼
            for(int idx=0;idx< res.length;++idx){
                // i 위치에서 weak point 개수만큼
                for(int j=i;j<i+weak.length;++j){
                    // 두점 사이의 거리가 검사 가능한 거리보다 크면 커버할 수 없음
                    // 현재 시점을 시작점으로 지정(이전 지점은 검사가 완료됐으므로)
                    if(spreadWeak[j]- spreadWeak[start]>res[idx]){
                        start=j;
                        idx++;

                        // 현재 지점을 커버할 수 없는데 다음 친구가 없다면, 남은 지점들을 검사할 필요가 없다
                        if(idx== res.length){
                            flag=false;
                            break;
                        }
                    }
               }

                // 주어진 사람으로 전체 weak point를 커버할 수 있다면
                // 더이상 검사 진행할 필요 없음(작은크기의 순열부터 만들었으니까)
                if(flag){
                    answer=idx+1;
                    finish=true;
                    return;
                }
            }
        }
    }

    // weak point 일자로 펼치는 과정
    private void makeSpreadWeak() {
        int size=weak.length;
        spreadWeak=new int [size*2-1];

        for(int i=0;i<size;++i){
            spreadWeak[i]=weak[i];
        }

        for(int i=0;i<size-1;++i){
            spreadWeak[i+size]=weak[i]+n;
        }
    }

    @Test
    public void test(){
        Assertions.assertEquals(2,solution(12, new int []{1,5,6,10},new int []{1,2,3,4}));
    }
}
