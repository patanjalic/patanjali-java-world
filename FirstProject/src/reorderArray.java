interface Criteria{
	boolean check(int value);
}

class reorderArray{
	public static void main(String... args){
		int arr[] = {1,9,3,7,5};
		reorderArray r = new reorderArray();
//		r.reorder(arr);
//		for(int i =0; i<arr.length;i++)
//			System.out.print(" "+arr[i]);
		r.reorder(arr, r.new oddCriteria());
		for(int i =0; i<arr.length;i++)
			System.out.print(" "+arr[i]);
	}
	public class evenCriteria implements Criteria{

		@Override
		public boolean check(int value) {
			if((value & 1) == 1)
				return true;
			return false;
		}
		
	}
	public class oddCriteria implements Criteria{

		@Override
		public boolean check(int value) {
			if((value & 1) == 0)
				return true;
			return false;
		}
		
	}
	private void reorder(int[] arr, Criteria crit) {
		int begin = 0;
		int end = arr.length - 1;
		while(begin < end){
			while(begin<end && crit.check(arr[begin]))
				begin++;
			while(begin< end && !crit.check(arr[end]))
				end--;
			if(begin < end){
				int temp = arr[begin];
				arr[begin] = arr[end];
				arr[end] = temp;
			}
		}
	}
	private void reorder(int[] arr) {
		int begin = 0;
		int end = arr.length - 1;
		while(begin < end){
			while(isOdd(arr[begin]))
				begin++;
			while(!isOdd(arr[end]))
				end--;
			if(begin < end){
				int temp = arr[begin];
				arr[begin] = arr[end];
				arr[end] = temp;
			}
		}
	}

	private boolean isOdd(int i) {
		if((i & 1) != 0)
			return true;
		return false;
	}
}