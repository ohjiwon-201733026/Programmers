package BaekJoon.Strings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class B20291_파일정리 {

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        HashMap<String,Integer> hm=new HashMap<>();
        ArrayList<String> list=new ArrayList<>();

        while(N-->0){
            String fileName=sc.next();
            String [] a=fileName.split("[.]");
//            System.out.println(a.length);
            if(hm.containsKey(a[1])) hm.put(a[1],hm.get(a[1])+1);
            else { hm.put(a[1],1); list.add(a[1]); }
        }

        Collections.sort(list);
        for(String s: list){
            System.out.println(s+" "+hm.get(s));
        }


    }
}
