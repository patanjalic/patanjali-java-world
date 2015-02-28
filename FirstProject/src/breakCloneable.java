import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

//singleton could be broken with reflection and by implementing serializable,
//this program tries to break it with cloneable interface
class breakCloneable implements Cloneable{
	private static final breakCloneable instance = new breakCloneable();
	private breakCloneable(){
		if(instance != null)
			System.out.println("singletone is already initialized");
	}
	public static breakCloneable getInstance(){
		return instance;
	}

	@Override
	protected breakCloneable clone(){
		return new breakCloneable();
	}
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		breakCloneable inst = breakCloneable.getInstance();
		System.out.println("instance is "+inst);
		breakCloneable dup = inst.clone();
		System.out.println("instance is "+dup);
		//using reflection
		Class cl = breakCloneable.class;
		Constructor ctor = cl.getDeclaredConstructor();
		ctor.setAccessible(true);
		breakCloneable b = (breakCloneable)ctor.newInstance();
		System.out.println("instance is "+b);
	}
}