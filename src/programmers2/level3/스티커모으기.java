package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 스티커모으기 {

    @Test
    public void test(){
        Assertions.assertEquals(36,solution(new int []{14, 6, 5, 11, 3, 9, 2, 10}));
        Assertions.assertEquals(8,solution(new int []{1, 3, 2, 5, 4}));
    }

    public int solution(int [] sticker){
        int n=sticker.length;
        int [] arr1=new int [n]; // 0 포함
        int [] arr2=new int [n]; // 0 포함 X

        if(n==1) return sticker[0];
        if(n==2) return Math.max(sticker[0],sticker[1]);
        if(n==3) return Math.max(sticker[0]+sticker[2],sticker[1]);

        int a=0,b=0;
        arr1[0]=sticker[0];
        arr1[1]=0;
        arr1[2]=arr1[0]+sticker[2];
        for(int i=3;i<n-1;++i){
            arr1[i]=Math.max(arr1[i-2],arr1[i-3])+sticker[i];
            a=Math.max(a,arr1[i]);
        }

        arr2[0]=0;
        arr2[1]=sticker[1];
        arr2[2]=arr2[0]+sticker[2];
        for(int i=3;i<n;++i){
            arr2[i]=Math.max(arr2[i-2],arr2[i-3])+sticker[i];
            b=Math.max(b,arr2[i]);
        }

        return a>b?a:b;
    }


}
