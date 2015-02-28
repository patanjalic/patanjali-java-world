public class nestedclasses
{
	private class innerclass
	{
		private String str;
		private int data;
		public String getStr() {
			return str;
		}
		public void setStr(String str) {
			this.str = str;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public innerclass(String str, int data) {
			super();
			this.str = str;
			this.data = data;
		}
		public innerclass()
		{
			this.str = "";
			this.data = 0;
		}
		public void printInnerData()
		{
			System.out.println("inner data is "+this.getData() + " "+this.getStr() );
		}
	}
	int data;
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public void printInnerData()
	{
		innerclass inner = new innerclass("Kelly Brook",21);
		System.out.println("nestedclass data is "+inner.getData()+" "+inner.getStr());
	}
	public static void main(String[] args)
	{
		nestedclasses n = new nestedclasses();
		nestedclasses.innerclass inner = n.new innerclass("Candice",20);
		inner.printInnerData();
		n.printInnerData();
	}
}