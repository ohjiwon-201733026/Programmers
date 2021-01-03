package Algorithm;

public class SelectionSort {

	public static int [] selection(int [] array) {
		for(int last=array.length-1;last>=1;last--) {
			int largestIndex=theLargest(array,last);
			int temp=array[largestIndex];
			array[largestIndex]=array[last];
			array[last]=temp;
		}
		return array;
	}

	public static int theLargest(int [] array, int last) {
		int max=0;
		int maxIdx=0;
		for(int i=0;i<=last;i++) {
			if(array[i]>max) {
				max= array[i];
				maxIdx=i;
			}
		}

		return maxIdx;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array= {8,31,48,73,3,65,20,29,11,15};
		int [] answer=selection(array);

		for(int i=0;i<answer.length;i++) {
			System.out.print(answer[i]+" ");
		}

	}

}
