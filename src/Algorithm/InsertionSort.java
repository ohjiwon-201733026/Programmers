package Algorithm;

public class InsertionSort {

	public static int [] insertionSort(int [] array, int n) {

		for(int i=2;i<=n;i++) {
			int loc=i-1;
			int newItem=array[i];

			while(loc>=1 && newItem<array[loc]) {
				int temp=array[loc];
				array[loc]=array[loc+1];
				array[loc+1]=temp;
				loc--;
			}

			array[loc+1]=newItem;
		}
		return array;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array= {3,31,48,73,8,11,20,29,65,15};
		int [] answer=insertionSort(array,array.length-1);

		for(int i=0;i<answer.length;i++) {
			System.out.print(answer[i]+" ");
		}

	}

}
