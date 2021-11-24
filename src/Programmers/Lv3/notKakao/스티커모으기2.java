package Programmers.Lv3.notKakao;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class 스티커모으기2 {

    @Test
    public void test(){
        Assertions.assertEquals(36,solution(new int []{14, 6, 5, 11, 3, 9, 2, 10}));
        Assertions.assertEquals(8,solution(new int []{1, 3, 2, 5, 4}));
        Assertions.assertEquals(52,solution(new int []{9,8,10,24,7,20}));
    }

    public int solution(int [] sticker){
        int [] arr1=new int [sticker.length]; // 0번 포함
        int [] arr2=new int [sticker.length]; // 0번 포함 X
        int a=0,b=0;
        int size= sticker.length;
        if(size==1) return sticker[0];
        else if (size==2) return Math.max(sticker[0],sticker[1]);
        else if(size==3) return Math.max(sticker[0]+sticker[2], sticker[1]);
        else{
            arr1[0]=sticker[0];
            arr1[1]=0;
            arr1[2]=arr1[0]+sticker[2];

            for(int i=3;i<size-1;++i){
                arr1[i]=Math.max(arr1[i-3],arr1[i-2])+sticker[i];
                if(a<arr1[i]) a=arr1[i];
            }

            arr2[0]=0;
            arr2[1]=sticker[1];
            arr2[2]=sticker[2];
            for(int i=3;i<size;++i){
                arr2[i]=Math.max(arr2[i-3],arr2[i-2])+sticker[i];
                if(b<arr2[i]) b=arr2[i];
            }

            return a>b?a:b;
        }
    }


}
