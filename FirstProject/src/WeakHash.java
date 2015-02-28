import java.util.HashMap;
import java.util.WeakHashMap;

class WeakHash{
	public static void main(String... args){
		WeakHash w = new WeakHash();
		w.testWeakHashMap();
	}

	private void testWeakHashMap() {
		HashMap<String,Object> m = new HashMap<String,Object>();
		WeakHashMap<String,Object> w = new WeakHashMap<String,Object>();
		String mkey = "kelly";
		String wkey = "brook";
		m.put(mkey, new Object());
		w.put(wkey, new Object());
		mkey = null;
		wkey = null;
		System.gc();
	}
}