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

        long [] answer=new long[room_number.length];
        map=new HashMap<>();
        for(int i=0;i<room_number.length;++i){
            answer[i]=roomAlloc(room_number[i]);
        }

        return answer;
    }

    public long roomAlloc(long room){
        if(!map.containsKey(room)){
            map.put(room,room+1);
            return room;
        }

        long emptyRoom=roomAlloc(map.get(room));
        map.put(room,emptyRoom);
        return emptyRoom;
    }





}
