import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String now=sc.next();
		String throwTime=sc.next();

		String [] nowArr=now.split(":");
		String [] throwArr=throwTime.split(":");
		int [] nowTimeArr=new int [3];
		int [] throwTimeArr=new int [3];
		for(int i=0;i<3;++i){
			nowTimeArr[i] = Integer.parseInt(nowArr[i]);
			throwTimeArr[i] = Integer.parseInt(throwArr[i]);
		}

		if(now.equals(throwTime)) { System.out.println("24:00:00"); return;}

		int sec=throwTimeArr[2]-nowTimeArr[2];
		if(sec<0) { sec+=60; throwTimeArr[1]--; }

		int min=throwTimeArr[1]-nowTimeArr[1];
		if(min<0) {min+=60; throwTimeArr[0]--; }

		int hour=throwTimeArr[0]-nowTimeArr[0];
		if(hour<0){ hour+=24; }

		System.out.println(String.format("%02d:%02d:%02d",hour,min,sec));



	}



}
