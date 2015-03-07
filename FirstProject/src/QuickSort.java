import org.junit.Test;


public class QuickSort {
	@Test
	public void main_test() {
		int[] arr = {1,3,6,23,11,13,15,20};
		int[] arr1 = new int[arr.length];
		System.out.println("unsorted arr is ");
		for(int temp:arr)
			System.out.print(" "+temp);
		for(int i = 0; i < arr.length; i++)
			arr1[i] = i;
		quicksort(arr, arr1,0, arr.length - 1);
		System.out.println("sorted array is ");
		for(int i = 0 ; i < arr.length; i++)
			System.out.print(" "+arr[arr1[i]]);
	}

	private void quicksort(int[] arr, int[] arr1, int i, int j) {
		if(arr.length <= 0)
			return;
		if(i >= j)
			return;
		
		int index = partition(arr,arr1,i,j);
		if(index - 1 > i)
			quicksort(arr,arr,i,index-1);
		if(index < j)
			quicksort(arr,arr,index,j);
	}

	private int partition(int[] arr, int[] arr1, int start, int end) {
		int mid = start + (end - start)/2;
		int i = start,j = end;
		while(i <= j){
			while(arr[arr1[mid]] > arr[arr1[i]])
				i++;
			while(arr[arr1[mid]] < arr[arr1[j]])
				j--;
			if(i<=j)
			{
				int temp = arr1[i];
				arr1[i] = arr1[j];
				arr1[j] = temp;
				i++;
				j--;
			}
		}
		return i;
	}

}
