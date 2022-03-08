package programmers2.level3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 베스트앨범 {

    @Test
    public void test(){
        int [] answer={4,1,3,0};
        int [] result=solution(new String []{"classic", "pop", "classic", "classic", "pop"},
                new int []{500, 600, 150, 800, 2500});

        for(int i=0;i<answer.length;++i){
            Assertions.assertEquals(answer[i],result[i]);
        }
    }

    HashMap<String, ArrayList<Song>> map;
    HashMap<String,Integer> genre;
    public int [] solution(String[] genres, int [] plays){
        map=new HashMap<>();
        genre=new HashMap<>();

        for(int i=0;i<genres.length;++i){
            String g=genres[i];
            if(genre.containsKey(g)) {
                genre.put(g,genre.get(g)+plays[i]);
                map.get(g).add(new Song(i,plays[i]));
            }
            else {
                genre.put(g,plays[i]);
                ArrayList<Song> tmp=new ArrayList<>();
                tmp.add(new Song(i,plays[i]));
                map.put(g,tmp);
            }
        }

        ArrayList<Genre> list=new ArrayList<>();
        for (String s : genre.keySet()) {
            list.add(new Genre(s,genre.get(s)));
        }
        Collections.sort(list);
        ArrayList<Integer> ans=new ArrayList<>();
        for (Genre genre1 : list) {
            ArrayList<Song> tmp=map.get(genre1.genre);
            Collections.sort(tmp);
            ans.add(tmp.get(0).i);
            if(tmp.size()!=1) ans.add(tmp.get(1).i);
        }


        int [] answer=new int [ans.size()];
        for(int i=0;i<ans.size();++i){
            answer[i]=ans.get(i);
        }
        return answer;
    }

    class Genre implements Comparable<Genre>{
        String genre;
        int play;

        public Genre(String genre, int play) {
            this.genre = genre;
            this.play = play;
        }

        @Override
        public int compareTo(Genre o) {
            return o.play-this.play;
        }
    }

    class Song implements Comparable<Song>{
        int i;
        int play;

        public Song(int i, int play) {
            this.i = i;
            this.play = play;
        }

        @Override
        public int compareTo(Song o) {
            if(o.play==this.play) return this.i-o.i;
            return o.play-this.play;
        }

        @Override
        public String toString() {
            return "Song{" +
                    "i=" + i +
                    ", play=" + play +
                    '}';
        }
    }
}
