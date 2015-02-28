import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

public class PureSingleton implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1526499224432020993L;
	private static final PureSingleton instance = new PureSingleton();
	private static Object mutex = new Object();

	private PureSingleton() {
	}

	public static PureSingleton getInstance() {
		if (instance == null) {
			synchronized (mutex) {
				//if (instance == null)
					//instance = new PureSingleton();
			}
		}
		return instance;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("PureSingleton cannot be cloned");
	}

	private Object readResolve() throws ObjectStreamException {
		return getInstance();

	}

	public static void main(String[] args) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		System.out.println("in main");
		PureSingleton instanceOne = PureSingleton.getInstance();
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
				"filename.ser"));
		out.writeObject(instanceOne);
		out.close();

		// deserailize from file to object
		ObjectInput in = new ObjectInputStream(new FileInputStream(
				"filename.ser"));
		PureSingleton instanceTwo = (PureSingleton) in.readObject();
		in.close();

		System.out.println("instanceOne hashCode=" + instanceOne.hashCode());
		System.out.println("instanceTwo hashCode=" + instanceTwo.hashCode());

		try {
			PureSingleton instanceThree = (PureSingleton) instanceOne.clone();
			System.out.println("instanceThree hashCode="
					+ instanceThree.hashCode());
		} catch (CloneNotSupportedException e) {
			System.out.println(e.getMessage());
		}

	}
}