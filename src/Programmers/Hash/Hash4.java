package Programmers.Hash;

import java.util.Scanner;

public class Hash4 {
	 static class Song{
		private int id;
		private String genre;
		private int play;

		Song(int id, String genre, int play) {
			this.id=id;
			this.genre=genre;
			this.play=play;
		}


	}

	public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        Song [] songs=new Song[genres.length];
        for(int i=0;i<genres.length;i++) {
        	songs[i]=new Song(i,genres[i],plays[i]);
        }








        return answer;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int genre=sc.nextInt();
		String [] genres= new String[genre];
		for(int i=0;i<genre;i++) {
			genres[i]=sc.next();
		}

		int [] plays= new int[genre];
		for(int i=0;i<genre;i++) {
			plays[i]=sc.nextInt();
		}

		int [] answer=solution(genres,plays);
		System.out.println(answer);
	}

}
