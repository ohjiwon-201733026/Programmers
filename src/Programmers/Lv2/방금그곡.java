package Programmers.Lv2;


public class 방금그곡 {

    public static void main(String [] args){
        String m="ABC";
        String [] musicinfos={"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution(m,musicinfos));
    }

    public static String solution(String m, String [] musicinfos){
        String answer="(None)";
        m=replace(m);
        int max=0;
        for(String music:musicinfos){
            String [] mus=music.split(",");
            int time=playTime(mus[0],mus[1]);
            String pattern=mus[3]; // 재생될 멜로디
            pattern=replace(pattern);
            StringBuilder sb=new StringBuilder();
            for(int i=0;i<time;++i){
                sb.append(pattern.charAt(i%pattern.length()));
            }
            String melody=sb.toString();
            if(melody.contains(m)){
                if(max<melody.length()) {
                    max=melody.length();
                    answer=mus[2];
                }
            }
        }

    return answer;
    }

    public static int playTime(String start, String end){
        String [] s=start.split(":");
        String [] e=end.split(":");

        int startTime=Integer.parseInt(s[0])*60+Integer.parseInt(s[1]);
        int endTime=Integer.parseInt(e[0])*60+Integer.parseInt(e[1]);

        return endTime-startTime;
    }

    public static String replace(String pattern){
        pattern=pattern.replaceAll("C#","c");
        pattern=pattern.replaceAll("D#","d");
        pattern=pattern.replaceAll("F#","f");
        pattern=pattern.replaceAll("G#","g");
        pattern=pattern.replaceAll("A#","a");

        return pattern;
    }
}
