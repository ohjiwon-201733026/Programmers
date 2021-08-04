package BaekJoon.Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class B1159_농구경기 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        HashMap<Character,Integer> hm=new HashMap<>();
        while(T-->0){
            char c=sc.next().charAt(0);
            if(hm.containsKey(c)) hm.put(c,hm.get(c)+1);
            else hm.put(c,1);
        }
        ArrayList<Character> list=new ArrayList<>();
        for(char key:hm.keySet()){
            if(hm.get(key)>=5) list.add(key);
        }
        if(list.size()==0) System.out.println("PREDAJA");
        else{
            Collections.sort(list);
            for(char c:list) System.out.print(c);
        }
    }
}
