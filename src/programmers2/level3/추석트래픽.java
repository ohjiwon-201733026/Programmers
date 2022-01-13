package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class 추석트래픽 {
    @Test
    public void test(){
        Assertions.assertEquals(1,solution(new String[]{"2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"}));
        Assertions.assertEquals(2,solution(new String[]{"2016-09-15 01:00:04.002 2.0s",
                "2016-09-15 01:00:07.000 2s"}));
        Assertions.assertEquals(7,solution(new String[]{"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"}));
    }

    public int solution(String [] lines){
        ArrayList<Long> checkPointList=new ArrayList<>();
        ArrayList<Log> logList=new ArrayList<Log>();

        for (String line : lines) {
            Log log=new Log(line);
            checkPointList.add(log.getStart());
            checkPointList.add(log.getEnd());
            logList.add(log);
        }

        Collections.sort(checkPointList);

        int top=0;
        for(int i=0;i<checkPointList.size();++i){
            int count=0;
            for(Log log:logList){
                if(log.isIn(checkPointList.get(i),checkPointList.get(i)+999)){
                    count++;
                }
            }

            top=Math.max(top,count);
        }

        return top;
    }

    class Log{
        private long start;
        private long duration;
        private long end;

        public Log(String line){
            String [] split=line.split(" ");
            String dateString=split[0]+" "+split[1];

            try{
                Date startDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(dateString);
                this.end=startDate.getTime();

                this.duration=(long)(Double.parseDouble(split[2].substring(0,split[2].length()-1))*1000);

                this.start=this.end-this.duration;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        public boolean isIn(long startSection,long endSection){
            if(this.end <startSection || endSection <=start) return false;
            else return true;
        }


        public long getStart() {
            return start;
        }

        public long getDuration() {
            return duration;
        }

        public long getEnd() {
            return end;
        }
    }
}
