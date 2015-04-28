import java.util.PriorityQueue;

import org.junit.Test;


public class QuickSort {
	@Test
	public void main_test() {
		//int[] arr = {1,3,6,11,11,11,11,23,1001,1001,1001,1001,1001,2000,2000,2000,11,13,15,20,99,100,999};
		int[] arr = {17,15,1,3,6,11,23,1001,2000};
		int[] arr1 = {1,3,6,23,1001,2000,11,13,15,20,99,100,999};
		//System.out.println("unsorted arr is ");
		//for(int temp:arr)
			//System.out.print(" "+temp);
		quicksort(arr,0, arr.length - 1);
		System.out.println("sorted array is ");
		for(int i = 0 ; i < arr.length; i++)
			System.out.print(" "+arr[i]);
		System.out.println("  ");
		kthSmallest(arr1,4,0,arr1.length - 1);
		for(int i = 0 ; i < arr1.length; i++)
			System.out.print(" "+arr1[i]);
	}

	private void kthSmallest(int[] arr1, int k,int start, int end) {
		if(k > 0 && k<=end - start+1){
			int index = partition(arr1,start,end);
			if(index - start == k-1)
				return;
			if(index - start < k-1)
				kthSmallest(arr1,k,start,index-1);
			else
				kthSmallest(arr1,k-index+start-1,index+1,end);
		}
	}

	private void quicksort(int[] arr, int i, int j) {
		if(arr.length <= 0)
			return;
		if(i >= j)
			return;
		
		int index = partition(arr,i,j);
		quicksort(arr,i,index-1);
		quicksort(arr,index+1,j);
	}

	private int partition(int[] arr, int start, int end) {
		int pivot = arr[start];
		int i = start,j = end;
		while(i < j){
			while(arr[i] < pivot)
				i++;
			while(arr[j] > pivot)
				j--;
			swap(arr,i,j);
		}
		return i;
	}
	private int partition1(int[] arr, int start, int end){
		int pivot = arr[end];
		int k = start;
		for(int i = start; i < end-1; i++){
			if(arr[i] <= pivot){
				swap(arr,i,k);
				k++;
			}
		}
		swap(arr,k,end);
		return k;
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
