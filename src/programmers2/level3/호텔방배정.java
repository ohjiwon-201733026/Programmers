package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class 호텔방배정 {

    @Test
    public void test(){
        long [] result={1,3,4,2,5,6};
        long [] room_number={1,3,4,1,3,1};

        long [] answer=solution(10,room_number);
        for(int i=0;i<answer.length;++i){
            Assertions.assertEquals(answer[i],result[i]);
        }
    }

    static HashMap<Long,Long> map;
    public long[] solution(long k, long [] room_number){
        map=new HashMap<>();
        int n= room_number.length;
        long [] answer=new long[n];
        for(int i=0;i<n;++i){
            answer[i]=findEmptyRoom(room_number[i]);
        }

        return answer;
    }

    private long findEmptyRoom(long room){
        if(!map.containsKey(room)){ // 즉시 방 배정
            map.put(room,room+1);
            return room;
        }

        long nextRoom=map.get(room);
        long emptyRoom=findEmptyRoom(nextRoom);
        map.put(room,emptyRoom);
        return emptyRoom;
    }



}
