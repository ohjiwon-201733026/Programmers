package Algorithm;

public class BubbleSort2 {

	public static int [] bubbleSort(int [] array, int n) {

		for(int last=n;last>=1;last--) {
			boolean SORTED=true;
			for(int i=0;i<last-1;i++) {
				if(array[i]>array[i+1]) {
					int temp=array[i];
					array[i]=array[i+1];
					array[i+1]=temp;
					SORTED=false;
				}
			}

			if(SORTED==true) return array;
		}

		return array;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array= {3,31,48,73,8,11,20,29,65,15};
		int [] answer=bubbleSort(array,array.length);

		for(int i=0;i<answer.length;i++){
			System.out.print(answer[i]+" ");
		}

	}

}
