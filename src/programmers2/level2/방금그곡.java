package programmers2.level2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class 방금그곡 {

    @Test
    public void test(){
        Assertions.assertEquals("HELLO",solution("ABCDEFG",new String []{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        Assertions.assertEquals("FOO",solution("CC#BCC#BCC#BCC#B",new String []{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
        Assertions.assertEquals("WORLD",solution("ABC",new String []{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
    }

    public String solution(String m, String [] musicinfos){
        String answer="(None)";
        m=m.replaceAll("C#","c");
        m=m.replaceAll("D#","d");
        m=m.replaceAll("F#","f");
        m=m.replaceAll("G#","g");
        m=m.replaceAll("A#","a");
        int max=0;
        for (String musicinfo : musicinfos) {
            String [] tmp=musicinfo.split(",");
            String music=tmp[3];
            music=music.replaceAll("C#","c");
            music=music.replaceAll("D#","d");
            music=music.replaceAll("F#","f");
            music=music.replaceAll("G#","g");
            music=music.replaceAll("A#","a");
            String s=makeMusic(tmp[0],tmp[1],music);
            if(s.contains(m)){
                if(max<s.length()){
                    max=s.length();
                    answer=tmp[2];
                }
            }

        }

        return  answer;

    }

    public String makeMusic(String start, String end, String m){
        int s=strToMin(start);
        int e=strToMin(end);
        int num=e-s;
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<num/m.length();++i){
            sb.append(m);
        }
        sb.append(m.substring(0,num%m.length()));
        return sb.toString();
    }

    public int strToMin(String s){
        String [] a=s.split(":");
        return 60*Integer.parseInt(a[0])+Integer.parseInt(a[1]);
    }
}
