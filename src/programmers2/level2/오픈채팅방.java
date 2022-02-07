package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class 오픈채팅방 {
    @Test
    public void test(){
        String [] result=new String []{"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."};
        String [] answer=solution(new String []{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"});
        for(int i=0;i< result.length;++i)
        Assertions.assertEquals(result[i],answer[i]);
    }

    class Chat{
        String uid;
        String action;

        public Chat(String uid, String action) {
            this.uid = uid;
            this.action = action;
        }
    }

    public String [] solution(String [] record){

        HashMap<String,String> map=new HashMap<>();
        ArrayList<Chat> list=new ArrayList<>();

        for (String s : record) {
            String [] spl=s.split(" ");

            if(spl[0].equals("Enter")){
                list.add(new Chat(spl[1],spl[0]));
                map.put(spl[1],spl[2]);
            }
            if(spl[0].equals("Leave")){
                list.add(new Chat(spl[1],spl[0]));
            }
            if(spl[0].equals("Change")){
                map.put(spl[1],spl[2]);
            }
        }
        String [] arr=new String[list.size()];
        for (int i=0;i<list.size();++i) {
            Chat chat=list.get(i);
            String name=map.get(chat.uid);
            String action=chat.action.equals("Enter")?"님이 들어왔습니다.":"님이 나갔습니다.";

            arr[i]=name+action;

        }
        return arr;
    }
}
