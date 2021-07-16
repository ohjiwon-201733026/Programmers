package Programmers.Lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class 오픈채팅방 {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String [] record={"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        solution(record);
    }

    public static class Chat{
        String uid;
        String act;

        public Chat(String uid, String act){
            this.uid=uid;
            this.act=act;
        }
    }

    private static String[] solution(String[] record) {
        HashMap<String, String> hm=new HashMap<>(); // key: uid, val: name
        ArrayList<Chat> al=new ArrayList<>();
        for(String s:record){
            String [] arr=s.split(" ");
            if(arr[0].equals("Enter")){
                al.add(new Chat(arr[1],"들어왔습니다."));
                hm.put(arr[1],arr[2]);
            }
            if(arr[0].equals("Leave")){
                al.add(new Chat(arr[1],"나갔습니다."));
            }
            if(arr[0].equals("Change")){
                hm.put(arr[1],arr[2]);
            }

        }

        String [] answer=new String [al.size()];
        int i=0;
        for(Chat c:al){
            answer[i]=hm.get(c.uid)+"님이 "+c.act;
            i++;
        }


        return answer;
    }
}
