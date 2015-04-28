import java.util.ArrayList;

import org.junit.Test;


public class TotalCombinations {

	@Test
	public void main_test() {
		int n = 4;
		int k = 2;
		ArrayList<ArrayList<Integer>> result = getCombinations(n,k);
	}

	private ArrayList<ArrayList<Integer>> getCombinations(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for(int i = 0;i<n-1;i++){
			for(int j = i+1;j<k;j++){
				ArrayList<Integer> temp = new ArrayList<Integer>();
				//for(int l = 0; i<k;l++)
					//temp.add(e)
			}
		}
		return null;
	}

}
