/*program to understand abstact classes and methods */

abstract class abc
{
	abstract void mymethod();
	public final String mystr = "junk";
	public void junk()
	{
		System.out.println("in abstract junk");
	}
}

class abc1 extends abc
{
	public final String mystr = "junk1";
	@Override
	void mymethod() {
		System.out.println("in abc1 mymethod");
	}
}
//private class xyz
//{
//	
//}
