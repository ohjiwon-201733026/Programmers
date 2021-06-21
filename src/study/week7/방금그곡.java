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

    public static class Music {
        String start; // 시작 시간
        String end; // 종료시간
        String 제목;
        String 악보;

        public Music(String start, String end, String 제목, String 악보) {
            this.start = start;
            this.end = end;
            this.제목 = 제목;
            this.악보 = 악보;
        }
    }

    private static String solution(String m, String[] musicinfos) {
        String l;
        l=m.replace("C#","c");
        l=m.replace("D#","d");
        l=m.replace("F#","f");
        l=m.replace("G#","g");
        l=m.replace("A#","a");
        Music [] musics=new Music[musicinfos.length];
        int i=0;
        for (String musicinfo : musicinfos) {
            String[] music = musicinfo.split(",");
            String 시작시각 = music[0];
            String 끝시각 = music[1];
            String 제목 = music[2];
            String 악보 = music[3];

            악보=악보.replace("C#","c");
            악보=악보.replace("D#","d");
            악보=악보.replace("F#","f");
            악보=악보.replace("G#","g");
            악보=악보.replace("A#","a");
            System.out.println(악보);
            musics[i]=new Music(시작시각,끝시각,제목,악보);i++;
        }

        for(int j=0;j<musics.length;++j){
            Music music=musics[j];
            int time = timeCount(music.start, music.end); // 재생시간
            System.out.println(time);
            StringBuilder 재생=new StringBuilder();
            if(time>music.악보.length()){
                for(int k=0;k<time/music.악보.length();++k)
                    재생.append(music.악보);
                재생.append(music.악보.substring(0,time%music.악보.length()));
            }
            else{
                재생.append(music.악보.substring(0,time));
            }

            for(int k=0;k<재생.length();++k){

            }

        }

        return "";

    }

    public static int timeCount(String 시작시각, String 끝시각) {
        String [] 시작=시작시각.split(":");
        String [] 끝=끝시각.split(":");

        int start=Integer.parseInt(시작[0])*60+Integer.parseInt(시작[1]);
        int end=Integer.parseInt(끝[0])*60+Integer.parseInt(끝[1]);

        return end-start;
    }
}
