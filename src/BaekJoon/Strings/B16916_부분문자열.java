package BaekJoon.Strings;

import java.util.Scanner;

public class B16916_부분문자열 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String S=sc.next();
        String P=sc.next();


        System.out.println(KMP(S,P));
    }

    public static int KMP(String parent,String pattern){
        int [] table=makeTable(pattern);
        int n1=parent.length();
        int n2=parent.length();

        int idx=0;
        for(int i=0;i<n1;++i){
            while(idx>0 && parent.charAt(i)!=pattern.charAt(idx)){
                idx=table[idx-1];
            }

            if(parent.charAt(i)==parent.charAt(idx)){
                if(idx==n2-1){
                    idx=table[idx];
                    return 1;
                }else {
                    idx+=1;
                }
            }
        }

        return 0;
    }

    private static int[] makeTable(String pattern) {
        int n=pattern.length();
        int [] table=new int [n];
        
        int idx=0;
        for(int i=1;i<n;++i){
            // 일치하는 문자가 발생했을 때 (idx>0)
                // 연속적으로 더 일치하지 않으면 idx=table[idx-1]로 돌려준다
            while(idx>0 && pattern.charAt(i)!=pattern.charAt(idx)){
                idx=table[idx-1];
            }

            if(pattern.charAt(i)==pattern.charAt(idx)){
                idx+=1;
                table[i]=idx;
            }
        }

        return table;
    }
}
