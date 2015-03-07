import org.junit.Test;


public class RotateI {

	@Test
	public void main_test() {
		StringBuilder str = new StringBuilder("abcdefghijklmnop");
		System.out.println("rotated string is "+rotateI(str,5));
	}

	private String rotateI(StringBuilder str,int i) {
		String temp = str.substring(0, i);
		int j = 0;
		for(int k = i; k < str.length() - i; k++){
			str.setCharAt(j, str.charAt(k));
			j++;
		}
		str.append(temp);
		return str.toString();
	}

}
