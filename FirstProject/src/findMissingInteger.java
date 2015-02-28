
public class findMissingInteger {

	public static void main(String[] args) {
		findMissingInteger fm = new findMissingInteger();
		int[] arr = {0,1,2,3,4,5,6,8,9};
		System.out.println("missing number is " + fm.findMissing(arr,0,arr.length - 1));
	}

	private int findMissing(int[] arr, int i, int j) {
		if(arr[i] != i)
			return i;
		int mid = i + (j - i)/2;
		if(arr[mid] == mid)
			return findMissing(arr,mid+1,j);
		else
			return findMissing(arr,i,mid);
	}

}
