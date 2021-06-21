package study.week7;

import java.util.ArrayList;
import java.util.Stack;

public class 방금그곡 {
    public static void main(String[] args) {
        String m = "ABC";
        String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String answer = solution(m, musicinfos);
        System.out.println(answer);
    }

    private static String solution(String m, String[] musicinfos) {
        String answer="(None)";
        int max=0;

        m=m.replaceAll("C#","c");
        m=m.replaceAll("D#","d");
        m=m.replaceAll("F#","f");
        m=m.replaceAll("G#","g");
        m=m.replaceAll("A#","a");

        for (String musicinfo : musicinfos) {
            String[] music = musicinfo.split(",");
            String 시작시각 = music[0];
            String 끝시각 = music[1];
            String 제목 = music[2];
            String 악보 = music[3];

            악보=악보.replaceAll("C#","c");
            악보=악보.replaceAll("D#","d");
            악보=악보.replaceAll("F#","f");
            악보=악보.replaceAll("G#","g");
            악보=악보.replaceAll("A#","a");

            int time=timeCount(시작시각,끝시각);
            String mel="";
            for(int i=0;i<time;++i){
                mel+=악보.charAt(i%악보.length());
            }

            if(mel.contains(m)){
                if(max<mel.length()) {
                    max=mel.length();
                    answer=제목;
                }
            }

        }

        return answer;

    }

    public static int timeCount(String 시작시각, String 끝시각) {
        String [] 시작=시작시각.split(":");
        String [] 끝=끝시각.split(":");

        int start=Integer.parseInt(시작[0])*60+Integer.parseInt(시작[1]);
        int end=Integer.parseInt(끝[0])*60+Integer.parseInt(끝[1]);

        return end-start;
    }
}
