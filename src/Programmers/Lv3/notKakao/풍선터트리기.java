package Programmers.Lv3.notKakao;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashSet;

public class 풍선터트리기 {

    @Test
    public void test(){
//        Assertions.assertEquals(3,solution(new int []{9,-1,-5}));
        Assertions.assertEquals(6,solution(new int []{-16,27,65,-2,58,-92,-71,-68,-61,-33}));
    }

    public int solution(int [] a){
        int [] leftMin=new int [a.length];
        int [] rightMin=new int [a.length];
        int l=a[0]; // 왼쪽값 중 최소값
        int r=a[a.length-1]; // 오른쪽 값 중 최소값

        //i일때 왼쪽 원소의 최소값을 저장
        for (int i=1 ; i<a.length-1;++i ) {
            if(l>a[i]) l=a[i];
            leftMin[i]=l;
        }

        // i일 떄 오른쪽 원소의 최소값 저장
        for(int i=a.length-2;i>0;--i){
            if(r>a[i]) r=a[i];
            rightMin[i]=r;
        }
        for (int i=0 ; i<a.length;++i ) {
            System.out.println(i+" "+leftMin[i]+" "+rightMin[i]+" "+a[i]);
        }
        if(a.length==1) return 1;
        int answer=2;
        for(int i=1;i<=a.length-2;++i){
            if(a[i]>leftMin[i] && a[i]>rightMin[i]) continue;
            answer++;
        }
        return answer;
    }
}
