class MergeArrays{
	public static void main(String... args){
		MergeArrays m = new MergeArrays();
		int[] a = {1,3,5,7};
		int[] b = {3,6,8,9};
		int[] result = m.merger(a, b);
		for(int temp:result)
			System.out.print(" "+temp);
	}

	private int[] merger(int[] a, int[] b) {
		int[] result = new int[a.length+b.length];
		int i = 0;
		int j = 0;
		int k = 0;
		while(a.length > i && b.length > j){
			if(a[i] <= b[j]){
				result[k++] = a[i++];
			}
			else{
				result[k++] = b[j++];
			}
		}
		while(i < a.length)
			result[k++] = a[i++];
		while(j < b.length)
			result[k++] = b[j++];
		return result;
	}
}