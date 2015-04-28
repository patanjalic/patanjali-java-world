import org.junit.Test;


public class kSmallestNumbers {

	@Test
	public void main_test() {
		int arr[] = {4,5,1,6,2,7,3,8};
		findKSmallest(arr,6,0,arr.length - 1);
		for(int x:arr)
			System.out.print(" "+x);
	}

	private void findKSmallest(int[] arr, int k, int b, int e) {
		if(k < 0 || k >= e - b + 1)
			return;
		int pivot = arr[b];
		int start = b;
		int end = e;
		while(start < end){
			while(arr[start] < pivot && start < e)
				start++;
			while(arr[end] > pivot && end > b)
				end--;
			if(start < end)
				swap(arr,start,end);
		}
		if(start == k -1)
			return;
		else if(k - 1 < start)
			findKSmallest(arr,k,b,start - 1);
		else
			findKSmallest(arr,k-start-1,start+1,e);
	}

	private void swap(int[] arr, int start, int end) {
		int temp = arr[start];
		arr[start] = arr[end];
		arr[end] = temp;
	}

}
