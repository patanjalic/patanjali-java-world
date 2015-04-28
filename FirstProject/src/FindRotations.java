import org.junit.Test;


public class FindRotations {

	@Test
	public void main_test() {
		int[] arr = {8,9,10,11,12,13,14,15,1,2,3,4,5,6,7};
		int noRotations = findRotations(arr,0,arr.length - 1);
		System.out.println("no of rotations is "+noRotations);
	}
	@Test
	public void main_test1() {
		int[] arr = {1,2,3,4,5,6,7};
		int noRotations = findRotations(arr,0,arr.length - 1);
		System.out.println("no of rotations is "+noRotations);
		while(true);
	}

	private int findRotations(int[] arr, int start, int end) {
		if(end < start)
			return 0;
		if(end == start)
			return start;
		int mid = start + (end - start)/2;
		if(arr[mid] < arr[mid-1] && arr[mid] < arr[mid+1] )
			return mid;
		if(arr[mid] > arr[mid+1])
			return mid+1;
		if(arr[mid] > arr[end])
			return findRotations(arr,mid+1,end);
		else
			return findRotations(arr,start,mid-1);
	}

}
