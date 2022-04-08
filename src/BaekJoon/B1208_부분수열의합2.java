package BaekJoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B1208_부분수열의합2 {
    static int n,s;
    static long cnt;
    static ArrayList<Integer> leftList;
    static ArrayList<Integer> rightList;
    static int [] arr;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        s=sc.nextInt();

        arr=new int [n];
        leftList=new ArrayList<>();
        rightList=new ArrayList<>();

        for(int i=0;i<n;++i) arr[i]=sc.nextInt();

        makeSum(0,0,n/2,leftList);
        makeSum(0,n/2,n,rightList);

        Collections.sort(leftList);
        Collections.sort(rightList);

        cnt=0;
        calcC();

        if(s==0){
            System.out.println(cnt-1);
        }
        else{
            System.out.println(cnt);
        }
    }

    public static void calcC(){
        int pointerL=0;
        int pointerR=rightList.size()-1;

        while (true){
            if(pointerL==leftList.size() || pointerR<0) break;

            int lv=leftList.get(pointerL);
            int rv=rightList.get(pointerR);

            if(lv+rv==s){
                long lc=0;
                while (pointerL<leftList.size() && leftList.get(pointerL)==lv){
                    lc++;
                    pointerL++;
                }

                long rc=0;
                while (0<=pointerR && rightList.get(pointerR)==rv){
                    rc++;
                    pointerR--;
                }
                cnt+=lc*rc;
            }

            if(lv+rv>s){
                pointerR--;
            }
            if(lv+rv<s){
                pointerL++;
            }
        }
    }

    public static void makeSum(int sum, int start, int end, ArrayList<Integer> list){
        if(start==end){
            list.add(sum);
            return;
        }

        makeSum(sum,start+1,end,list);
        makeSum(sum+arr[start],start+1,end,list);
    }

}
