package Programmers.Lv3.notKakao;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 베스트앨범 {

    @Test
    public void test(){
        int [] answer=solution(new String[]{"classic", "pop", "classic", "classic"},new int[]{500, 600, 150, 800});
        for (int i : answer) {
            System.out.println(i);
        }
    }

    private int[] solution(String[] genres, int[] plays) {
        HashMap<String,ArrayList<Song>> songList=new HashMap<>();
        HashMap<String,Integer> songCount=new HashMap<>();
        ArrayList<Count> list=new ArrayList<>();

        for(int i=0;i< genres.length;++i){
            String genre=genres[i];
            if(songList.containsKey(genre)){
                songList.get(genre).add(new Song(i,plays[i]));
                songCount.put(genre,songCount.get(genre)+plays[i]);
            }
            else{
                ArrayList<Song> tmp=new ArrayList<>();
                tmp.add(new Song(i,plays[i]));
                songList.put(genre,tmp);
                songCount.put(genre,plays[i]);
            }
        }



        for (String s : songCount.keySet()) {
            list.add(new Count(s,songCount.get(s)));
        }
        Collections.sort(list);
        ArrayList<Integer> answers=new ArrayList<Integer>();
        for (Count count : list) {
            String genre=count.genre;
            ArrayList<Song> tmp=songList.get(genre);
            Collections.sort(tmp);
            answers.add(tmp.get(0).idx);
            if(tmp.size()>=2) answers.add(tmp.get(1).idx);
        }
        int [] answer=new int [answers.size()];
        for(int i=0;i< answer.length;++i){
            answer[i]=answers.get(i);
        }
        return answer;

    }

    class Count implements Comparable<Count>{
        String genre;
        int totalPlay;

        public Count(String genre, int totalPlay) {
            this.genre = genre;
            this.totalPlay = totalPlay;
        }

        @Override
        public int compareTo(Count o) {
            return o.totalPlay-this.totalPlay;
        }
    }

    class Song implements Comparable<Song> {
        int idx;
        int playCount;

        public Song(int idx, int playCount) {
            this.idx = idx;
            this.playCount = playCount;
        }


        @Override
        public int compareTo(Song o) {
            if(this.playCount==o.playCount){
                return this.idx-o.idx;
            }
            return o.playCount-this.playCount;
        }
    }


}
